# Architektura Backendu

## Cel dnia 3

Celem dnia 3 było ustalenie, jak układamy backend Spring Boot, zanim zaczniemy pisać encje i endpointy.

Najważniejsza decyzja:

> Dzielimy backend po modułach domenowych, a nie po typach plików. Moduły komunikują się ze sobą przez jawne klasy typu `Facade` / `Reader`, a nie przez bezpośredni dostęp do repozytoriów innego modułu.

## Pakiet główny

```txt
backend/src/main/java/pl/productplanner
```

Proponowana struktura:

```txt
pl.productplanner
├── ProductPlannerApplication.java
├── config
├── shared
├── productitem
├── sprint
└── identity
```

`identity` jest modułem docelowym. Na początku może nie mieć kodu, ale rezerwujemy dla niego miejsce w architekturze, bo później obsłuży użytkowników, firmy i logowanie.

## Podział modułów

### config

Konfiguracja techniczna aplikacji.

Przykłady:

```txt
WebConfig
CorsConfig
SecurityConfig później
```

Ten pakiet nie zawiera logiki biznesowej.

### shared

Kod wspólny, który nie należy do jednego konkretnego modułu domenowego.

Przykłady:

```txt
ApiError
GlobalExceptionHandler
NotFoundException
ValidationError
```

Zasada:

> `shared` nie może stać się workiem na wszystko. Trafiają tu tylko rzeczy faktycznie wspólne.

### productitem

Moduł odpowiedzialny za główny obiekt Product Plannera.

Obejmuje:

- `product_items`,
- `product_item_contents`,
- `product_item_specs`,
- `product_item_comments`,
- `product_item_events`.

Proponowane pliki:

```txt
productitem
├── ProductItem.java
├── ProductItemContent.java
├── ProductItemSpec.java
├── ProductItemComment.java
├── ProductItemEvent.java
├── ProductItemType.java
├── ProductItemStage.java
├── RoadmapColumn.java
├── ProductItemEventType.java
├── ProductItemRepository.java
├── ProductItemContentRepository.java
├── ProductItemSpecRepository.java
├── ProductItemCommentRepository.java
├── ProductItemEventRepository.java
├── ProductItemService.java
├── ProductItemFacade.java
├── ProductItemController.java
└── dto
    ├── ProductItemCreateRequest.java
    ├── ProductItemUpdateRequest.java
    ├── ProductItemListResponse.java
    ├── ProductItemDetailsResponse.java
    ├── ProductItemContentRequest.java
    └── ProductItemStageChangeRequest.java
```

Dlaczego `ProductItemContent` jest w module `productitem`, mimo że to osobna tabela?

Bo to nadal część tej samej funkcji biznesowej. Tabela jest osobna ze względów wydajnościowych i organizacyjnych, ale domenowo content należy do Product Item.

### sprint

Moduł odpowiedzialny za sprinty i sprint board.

Obejmuje:

- `sprints`,
- `sprint_items`.

Proponowane pliki:

```txt
sprint
├── Sprint.java
├── SprintItem.java
├── SprintStatus.java
├── SprintBoardStatus.java
├── SprintRepository.java
├── SprintItemRepository.java
├── SprintService.java
├── SprintController.java
└── dto
    ├── SprintCreateRequest.java
    ├── SprintResponse.java
    ├── SprintItemCreateRequest.java
    └── SprintItemStatusChangeRequest.java
```

`SprintItem` łączy sprint z `ProductItem`.

### identity

Moduł docelowy dla logowania, użytkowników i firm.

Na MVP startujemy bez pełnego auth, ale architektonicznie zakładamy, że później pojawią się:

```txt
identity
├── Company.java
├── User.java
├── AuthService.java
├── CurrentUserContext.java
└── dto
```

Docelowo główne dane będą filtrowane po firmie:

```txt
product_items.company_id
sprints.company_id
product_item_comments.company_id
product_item_events.company_id
```

Na start możemy działać bez `company_id` albo z jedną domyślną firmą. Pełne logowanie odkładamy po ustabilizowaniu rdzenia Product Plannera.

## Komunikacja między modułami

Moduł nie powinien sięgać bezpośrednio po repozytorium innego modułu.

Nie robimy:

```java
// sprint/SprintService.java
productItemRepository.findById(productItemId);
```

Robimy:

```java
// sprint/SprintService.java
productItemFacade.getExistingProductItem(productItemId);
```

Czyli:

```txt
sprint -> productitem/ProductItemFacade -> ProductItemRepository
```

## ProductItemFacade

`ProductItemFacade` jest publicznym punktem dostępu do modułu `productitem` dla innych modułów.

Przykładowe metody:

```java
public ProductItem getExistingProductItem(Long id)
public void markAddedToSprint(Long productItemId, Long sprintId)
public void recordEvent(Long productItemId, ProductItemEventType type, String message)
```

Na początku możemy trzymać facade jako zwykłą klasę Spring:

```java
@Service
public class ProductItemFacade {
}
```

Nie musimy od razu robić interfejsu. Interfejs dodamy dopiero, jeśli pojawi się realna potrzeba.

## Zasada zależności

Dopuszczalne:

```txt
sprint -> productitem facade
productitem -> shared
sprint -> shared
productitem -> identity później
sprint -> identity później
```

Niedopuszczalne:

```txt
sprint -> ProductItemRepository
sprint -> ProductItemEventRepository
productitem -> SprintRepository bez wyraźnej potrzeby
shared -> productitem
shared -> sprint
```

`shared` nie zna modułów domenowych.

## Przepływ requestu

Standardowy przepływ:

```txt
Controller -> Service -> Repository -> Database
```

Przykład dla utworzenia product itemu:

```txt
ProductItemController
-> ProductItemService
-> ProductItemRepository
-> product_items
```

Przykład dla dodania itemu do sprintu:

```txt
SprintController
-> SprintService
-> ProductItemFacade
-> ProductItemRepository
-> SprintRepository
-> SprintItemRepository
```

`SprintService` zarządza sprintem, ale nie zna szczegółów przechowywania Product Itemów.

## Odpowiedzialności warstw

### Controller

Odpowiada za:

- przyjęcie requestu HTTP,
- walidację wejściowego DTO przez `@Valid`,
- wywołanie serwisu,
- zwrócenie response DTO.

Nie odpowiada za:

- logikę biznesową,
- liczenie score,
- zmianę stage,
- zapisywanie eventów,
- bezpośredni dostęp do repozytoriów.

### Service

Odpowiada za:

- decyzje biznesowe,
- zmianę stanu encji,
- transakcje,
- zapis eventów historii,
- używanie repozytoriów swojego modułu,
- używanie facade innych modułów.

Przykład:

```txt
ProductItemService.changeStage()
```

powinien:

1. pobrać item,
2. zapamiętać poprzedni stage,
3. ustawić nowy stage,
4. zapisać item,
5. dodać event `STAGE_CHANGED`.

### Repository

Odpowiada za:

- pobieranie danych,
- zapis danych,
- proste zapytania bazodanowe.

Nie odpowiada za:

- decyzje biznesowe,
- walidację procesu,
- tworzenie eventów.

### DTO

Frontend nie dostaje encji JPA bezpośrednio.

Robimy osobne DTO:

```txt
ProductItemListResponse
ProductItemDetailsResponse
SprintResponse
SprintItemResponse
```

Powody:

- nie ujawniamy struktury bazy,
- kontrolujemy rozmiar payloadu,
- unikamy przypadkowego pobrania relacji,
- łatwiej zmieniać bazę bez psucia API.

## Eventy historii

Historię zmian zapisujemy w serwisach po ważnych akcjach.

Przykłady:

```txt
ProductItemService.create() -> CREATED
ProductItemService.changeStage() -> STAGE_CHANGED
ProductItemService.updateScore() -> SCORE_CHANGED
SprintService.addItemToSprint() -> ADDED_TO_SPRINT
SprintService.changeBoardStatus() -> SPRINT_STATUS_CHANGED
```

Jeśli event dotyczy Product Itemu, zapisuje go moduł `productitem`.

Jeśli akcja dzieje się w module `sprint`, `SprintService` wywołuje `ProductItemFacade`, żeby dopisać event po stronie `productitem`.

## Company i filtrowanie danych

Docelowo aplikacja będzie wielofirmowa.

Później dodamy:

```txt
companies
users
company_id w głównych tabelach
```

Zasada docelowa:

```sql
where company_id = :currentCompanyId
```

Na MVP:

- nie budujemy jeszcze pełnego logowania,
- nie komplikujemy pierwszych encji auth,
- możemy zostawić miejsce na `company_id` w dokumentacji,
- wrócimy do tego, gdy rdzeń Product Plannera będzie działał.

## Decyzje dnia 3

1. Backend dzielimy po modułach domenowych.
2. `productitem` zawiera także content, spec, komentarze i eventy.
3. `sprint` komunikuje się z `productitem` przez `ProductItemFacade`.
4. Inny moduł nie używa repozytorium obcego modułu.
5. Controller nie zawiera logiki biznesowej.
6. Service podejmuje decyzje i zapisuje eventy.
7. Repository tylko pobiera i zapisuje dane.
8. Frontend dostaje DTO, nie encje JPA.
9. `identity` i `company_id` są przewidziane, ale nie blokują MVP.
10. Pełne auth odkładamy do momentu, gdy rdzeń aplikacji będzie stabilny.
