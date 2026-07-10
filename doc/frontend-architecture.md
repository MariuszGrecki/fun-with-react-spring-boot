# Architektura Frontendu

## Cel dnia 4

Celem dnia 4 było ustalenie docelowej architektury frontendu przed migracją na React + TypeScript + Mantine.

Najważniejsza decyzja:

> Frontend dzielimy podobnie jak backend: po funkcjach domenowych, a nie po typach plików. `productItems` i `sprints` są osobnymi feature'ami, a `shared` zawiera tylko rzeczy naprawdę wspólne.

## Stack docelowy

```txt
React
TypeScript
Mantine
Vite
```

Na dziś projekt ma jeszcze prosty frontend JavaScript. Migrację na TypeScript i Mantine wykonamy później jako osobny dzień.

## Docelowa struktura katalogów

```txt
frontend/src
├── app
│   ├── App.tsx
│   ├── AppProviders.tsx
│   └── routes.tsx
├── api
│   ├── httpClient.ts
│   └── apiError.ts
├── features
│   ├── productItems
│   │   ├── api
│   │   │   └── productItemsApi.ts
│   │   ├── components
│   │   │   ├── ProductItemTable.tsx
│   │   │   ├── ProductItemForm.tsx
│   │   │   ├── ProductItemDetails.tsx
│   │   │   ├── ProductItemStageBadge.tsx
│   │   │   └── ProductItemScoreBadge.tsx
│   │   ├── hooks
│   │   │   └── useProductItems.ts
│   │   ├── pages
│   │   │   ├── ProductItemsPage.tsx
│   │   │   └── ProductItemDetailsPage.tsx
│   │   └── types.ts
│   ├── sprints
│   │   ├── api
│   │   │   └── sprintsApi.ts
│   │   ├── components
│   │   │   ├── SprintBoard.tsx
│   │   │   ├── SprintColumn.tsx
│   │   │   ├── SprintItemCard.tsx
│   │   │   └── SprintForm.tsx
│   │   ├── hooks
│   │   │   └── useSprints.ts
│   │   ├── pages
│   │   │   └── SprintsPage.tsx
│   │   └── types.ts
│   └── dashboard
│       ├── components
│       │   └── DashboardStats.tsx
│       ├── pages
│       │   └── DashboardPage.tsx
│       └── types.ts
├── shared
│   ├── components
│   │   ├── EmptyState.tsx
│   │   ├── ErrorAlert.tsx
│   │   └── LoadingState.tsx
│   ├── layout
│   │   ├── AppShellLayout.tsx
│   │   └── Navigation.tsx
│   └── utils
│       ├── dateFormat.ts
│       └── scoreFormat.ts
└── main.tsx
```

## Mapowanie backend -> frontend

```txt
backend productitem -> frontend features/productItems
backend sprint      -> frontend features/sprints
backend shared      -> frontend shared
backend config      -> frontend app / api
```

Nie będzie to idealne 1:1, bo frontend ma UI, routing, layout i hooki, ale mentalny podział zostaje podobny.

## app

`app` zawiera składanie całej aplikacji.

Odpowiedzialność:

- główny `App`,
- providery Mantine,
- routing,
- globalny layout,
- konfiguracja aplikacji.

Przykłady:

```txt
App.tsx
AppProviders.tsx
routes.tsx
```

`app` nie powinien zawierać logiki domenowej Product Itemów ani sprintów.

## api

`api` zawiera niskopoziomową komunikację HTTP.

Przykłady:

```txt
httpClient.ts
apiError.ts
```

`httpClient.ts` odpowiada za:

- bazowy URL API,
- nagłówki,
- parsowanie odpowiedzi,
- obsługę błędów HTTP,
- wspólną funkcję `request`.

Nie trzymamy tu funkcji domenowych typu:

```txt
getProductItems()
createSprint()
```

One należą do feature'ów:

```txt
features/productItems/api/productItemsApi.ts
features/sprints/api/sprintsApi.ts
```

## features/productItems

Feature odpowiedzialny za Product Itemy.

Obejmuje:

- listę itemów,
- szczegóły itemu,
- formularze,
- typy,
- API product itemów,
- komponenty związane tylko z product itemami.

Przykładowe typy:

```ts
export type ProductItemType =
  | 'FEATURE'
  | 'BUG'
  | 'IMPROVEMENT'
  | 'TECH_DEBT'
  | 'RESEARCH';

export type ProductItemStage =
  | 'CONCEPT'
  | 'BACKLOG'
  | 'ROADMAP'
  | 'ARCHIVED';

export type RoadmapColumn =
  | 'NOW'
  | 'NEXT'
  | 'LATER'
  | 'DONE';
```

`features/productItems` może używać:

- `api/httpClient`,
- `shared/components`,
- `shared/utils`.

Nie powinno importować komponentów z `features/sprints`.

## features/sprints

Feature odpowiedzialny za sprinty i sprint board.

Obejmuje:

- listę sprintów,
- aktywny sprint,
- sprint board,
- karty sprint itemów,
- API sprintów,
- typy sprintowe.

Przykładowe typy:

```ts
export type SprintStatus =
  | 'PLANNED'
  | 'ACTIVE'
  | 'COMPLETED';

export type SprintBoardStatus =
  | 'TODO'
  | 'IN_PROGRESS'
  | 'REVIEW'
  | 'DONE';
```

Jeśli sprint musi pokazać podstawowe dane Product Itema, używamy typu kontraktowego albo DTO z API sprintów, np.:

```ts
export type SprintItem = {
  id: number;
  productItemId: number;
  productItemTitle: string;
  productItemSummary: string;
  boardStatus: SprintBoardStatus;
};
```

Nie importujemy `ProductItemTable` ani innych komponentów product itemów do sprintów.

## features/dashboard

Dashboard agreguje dane z różnych obszarów, ale nie powinien przejmować ich logiki.

Dashboard może pobierać gotowe DTO z backendu:

```txt
GET /api/dashboard
```

albo tymczasowo składać dane z kilku endpointów.

Na MVP preferujemy prosty wariant. Jeśli dashboard zacznie robić zbyt dużo, przeniesiemy agregację do backendu.

## shared

`shared` zawiera tylko rzeczy naprawdę wspólne.

Dozwolone:

```txt
EmptyState
ErrorAlert
LoadingState
AppShellLayout
Navigation
dateFormat
scoreFormat
```

Niedozwolone:

```txt
ProductItemTable
SprintBoard
ProductItemForm
SprintItemCard
```

Zasada:

> Jeśli komponent zna domenę Product Itemów albo sprintów, nie jest shared.

## Komunikacja między feature'ami

Feature'y nie powinny importować od siebie komponentów.

Nie robimy:

```ts
// features/sprints/components/SprintItemCard.tsx
import { ProductItemStageBadge } from '../../productItems/components/ProductItemStageBadge';
```

Lepsze opcje:

1. Przenieść naprawdę neutralny komponent do `shared`.
2. Zduplikować mały, specyficzny komponent, jeśli zachowania są różne.
3. Użyć DTO z backendu, które zawiera dane potrzebne dla sprintu.

Feature może importować typ z innego feature'a tylko ostrożnie. Jeśli typ staje się kontraktem API używanym w kilku miejscach, rozważamy:

```txt
shared/types
```

ale nie robimy tego przedwcześnie.

## DTO i typy

Frontend typuje odpowiedzi API osobno od wewnętrznych komponentów, jeśli będzie taka potrzeba.

Na start możemy trzymać typy w:

```txt
features/productItems/types.ts
features/sprints/types.ts
```

Przykład:

```ts
export type ProductItemListResponse = {
  id: number;
  title: string;
  summary: string;
  type: ProductItemType;
  stage: ProductItemStage;
  score: number | null;
};
```

Nie zakładamy, że typ frontendu musi być identyczny z encją JPA. Frontend zna API DTO, nie bazę danych.

## Mantine

Mantine używamy jako głównej biblioteki UI.

Zastosowania:

- `AppShell` dla layoutu,
- `Table` albo `Card` dla list,
- `Modal` dla formularzy,
- `Select` i `SegmentedControl` dla statusów,
- `Badge` dla stage, type i priority,
- `Notification` dla sukcesów i błędów,
- `TextInput`, `Textarea`, `NumberInput` dla formularzy.

Nie budujemy własnego design systemu na starcie. Używamy gotowych komponentów Mantine i trzymamy layout prosty.

## Routing

Docelowe trasy:

```txt
/                       dashboard
/product-items          lista product itemów
/product-items/:id      szczegóły product itemu
/roadmap                roadmapa
/sprints                sprinty
/sprints/:id            szczegóły sprintu / board
```

Na MVP możemy zacząć od jednej strony i prostych zakładek, ale docelowo ta struktura jest czytelniejsza.

## Obsługa błędów i loadingu

Każdy feature powinien obsługiwać:

- loading,
- error,
- empty state,
- success notification po zapisie.

Wspólne komponenty:

```txt
shared/components/LoadingState.tsx
shared/components/ErrorAlert.tsx
shared/components/EmptyState.tsx
```

## Decyzje dnia 4

1. Frontend dzielimy po feature'ach, podobnie jak backend.
2. `features/productItems` odpowiada za Product Itemy.
3. `features/sprints` odpowiada za sprinty i sprint board.
4. `shared` zawiera tylko komponenty i utilsy niezależne od domeny.
5. `api/httpClient.ts` jest niskopoziomowy, a domenowe API siedzi w feature'ach.
6. Feature'y nie importują od siebie komponentów.
7. Mantine jest podstawą UI.
8. Frontend używa DTO z API, nie encji JPA.
9. Dzień 4 nie wymaga jeszcze migracji kodu na TypeScript; dokumentuje docelową strukturę.
