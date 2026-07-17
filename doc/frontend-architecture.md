# Architektura Frontendu

## Cel dnia 4

Celem dnia 4 jest ustalenie architektury Angulara przed implementacją widoków.

Najważniejsza decyzja:

> Frontend dzielimy po funkcjach domenowych, a nie po technicznych typach plików. `product-items` i `sprints` są osobnymi feature'ami, a `shared` zawiera wyłącznie rzeczy niezależne od domeny.

## Stack docelowy

```txt
Angular (standalone components)
TypeScript
Angular Material
Angular Router
HttpClient i RxJS
Reactive Forms
```

## Docelowa struktura katalogów

```txt
frontend/src/app
├── core
│   ├── api
│   │   ├── api-error.ts
│   │   └── http-error.interceptor.ts
│   └── config
│       └── api.config.ts
├── features
│   ├── product-items
│   │   ├── data-access
│   │   │   └── product-items-api.service.ts
│   │   ├── models
│   │   │   └── product-item.model.ts
│   │   ├── pages
│   │   │   ├── product-items-page.component.ts
│   │   │   └── product-item-details-page.component.ts
│   │   └── ui
│   │       ├── product-item-form.component.ts
│   │       ├── product-item-table.component.ts
│   │       └── product-item-stage-badge.component.ts
│   ├── sprints
│   │   ├── data-access
│   │   │   └── sprints-api.service.ts
│   │   ├── models
│   │   │   └── sprint.model.ts
│   │   ├── pages
│   │   │   └── sprints-page.component.ts
│   │   └── ui
│   │       ├── sprint-board.component.ts
│   │       └── sprint-form.component.ts
│   └── dashboard
│       └── pages/dashboard-page.component.ts
├── shared
│   ├── layout
│   │   ├── app-shell.component.ts
│   │   └── navigation.component.ts
│   └── ui
│       ├── empty-state.component.ts
│       ├── error-alert.component.ts
│       └── loading-state.component.ts
├── app.component.ts
├── app.config.ts
└── app.routes.ts
```

## Zasady odpowiedzialności

- `core` zawiera singletony aplikacji: konfigurację API, interceptory i globalną obsługę błędów.
- `features` zawiera logikę oraz widoki konkretnej domeny.
- `data-access` zawiera serwisy komunikujące się z REST API; komponenty nie używają `HttpClient` bezpośrednio.
- `ui` zawiera komponenty prezentacyjne danego feature'a.
- `shared` zawiera tylko neutralne komponenty i layout, bez wiedzy o Product Itemach oraz sprintach.

Mapowanie backendu na frontend:

```txt
backend productitem -> features/product-items
backend sprint      -> features/sprints
backend shared      -> shared
backend config      -> core
```

## Komunikacja z API

Każdy feature posiada własny serwis API, na przykład `ProductItemsApiService`. Serwis zwraca typowane obserwowalne odpowiedzi HTTP i zna wyłącznie kontrakt REST, nie encje JPA.

```ts
export interface ProductItemListResponse {
  id: number;
  title: string;
  summary: string;
  type: ProductItemType;
  stage: ProductItemStage;
  score: number | null;
}
```

Globalny interceptor przekształca błędy HTTP do wspólnego typu `ApiError`. Komponent strony obsługuje stan ładowania, błąd, pustą listę i sukces zapisu.

## Formularze i UI

Formularze tworzymy przez Reactive Forms. Angular Material zapewnia podstawowe elementy: `mat-form-field`, `mat-select`, `mat-table`, `mat-dialog`, `mat-chip` i `MatSnackBar`.

Nie tworzymy własnego design systemu na MVP. Drag and drop przez Angular CDK jest opcjonalny i nie blokuje ukończenia MVP.

## Routing

```txt
/                       dashboard
/product-items          lista Product Itemów
/product-items/:id      szczegóły Product Itemu
/roadmap                roadmapa
/sprints                sprinty
/sprints/:id            szczegóły sprintu i board
```

Każdy feature jest ładowany leniwie przez `loadComponent` lub `loadChildren`, gdy pojawi się więcej niż jedna strona. Dzięki temu `app.routes.ts` pozostaje prosty, a moduły domenowe niezależne.

## Decyzje dnia 4

1. Używamy Angulara ze standalone components; nie tworzymy na start `NgModule`.
2. Feature'y są podzielone według domeny: `product-items`, `sprints`, `dashboard`.
3. Serwisy `data-access` są jedynym miejscem wywołującym REST API.
4. `core` przechowuje konfigurację i globalne mechanizmy, a `shared` neutralne UI.
5. Angular Material jest podstawą UI, a Reactive Forms podstawą formularzy.
6. Frontend używa DTO API, nie encji JPA.
