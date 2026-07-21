# Plan Nauki na 90 Dni

Plan zakłada około 1 godzinę dziennie. Celem jest zbudowanie realnego MVP aplikacji **Product Planner** oraz nabranie biegłości w Angularze, TypeScripcie, Angular Material, Spring Boot, PostgreSQL, testach, debugowaniu i CI/CD.

## Stack Docelowy

```txt
Angular + TypeScript + Angular Material
Spring Boot
PostgreSQL
Docker Compose
JUnit / MockMvc / Jasmine-Karma lub Vitest / Angular Testing Library / Playwright
GitHub Actions
```

## MVP na 90 Dni

W 90 godzin nie budujemy pełnej wizji z `doc/idea.md`. Budujemy wersję, która pokazuje najważniejszy przepływ:

```txt
pomysł -> backlog -> scoring -> roadmapa -> sprint -> board -> podsumowanie
```

Zakres MVP:

1. Dashboard.
2. Product Inbox.
3. Backlog.
4. Scoring `impact / effort / confidence`.
5. Roadmapa `Now / Next / Later / Done`.
6. Sprinty.
7. Sprint Board `To Do / In Progress / Review / Done`.
8. Spec Builder v1.
9. Komentarze.
10. Podstawowa historia aktywności.
11. Testy backendu i frontendu.
12. CI/CD.

Poza zakresem MVP:

- AI,
- rozbudowane role i uprawnienia,
- integracje,
- publiczne API,
- webhooki,
- zaawansowany reporting,
- pełny system organizacji i workspace'ów.

## Rytm Dnia

Każdy dzień:

1. 10 minut: temat i wyjaśnienie.
2. 35 minut: samodzielne kodowanie.
3. 10 minut: debugowanie albo review.
4. 5 minut: fiszka w `doc/fiszki.md`.

## Etapy

| Dni | Etap | Cel |
| --- | --- | --- |
| 1-10 | Pivot i fundamenty | Przestawić projekt na Product Planner i zrozumieć architekturę. |
| 11-20 | Backend MVP | Model danych, REST API, walidacja i błędy. |
| 21-30 | Angular fundamenty | Szkielet Angulara, routing, typowanie i klient API. |
| 31-40 | Angular Material UI | Layout aplikacji, dashboard, formularze, tabele i dialogi. |
| 41-50 | Backlog i scoring | Priorytetyzacja, filtry, sortowanie, statusy. |
| 51-60 | Roadmapa i sprinty | Roadmap board i sprint board; drag and drop jest opcjonalny. |
| 61-70 | Spec Builder i aktywność | Specyfikacje, komentarze, timeline i stabilizacja przepływu. |
| 71-80 | Testy | Testy backendu, frontendu i pierwszy E2E. |
| 81-90 | CI/CD i finalizacja | GitHub Actions, dokumentacja, polish i demo. |

## Plan Dzienny

| Status | Dzień | Temat | Zadanie |
| --- | --- | --- | --- |
| [x] | 1 | Product Planner MVP | Przejdź przez `doc/idea.md` i zaznacz, co wchodzi do MVP, a co odkładamy. |
| [x] | 2 | Model domeny | Zaprojektuj `ProductItem`, jego etapy oraz `Sprint` i `SprintItem`. |
| [x] | 3 | Architektura backendu | Ustal moduły backendu: productitem, sprint, shared, config oraz komunikację między modułami przez facade. |
| [x] | 4 | Architektura frontendu | Ustal strukturę Angular: core, features, shared, data-access oraz zasady komunikacji między feature'ami. |
| [x] | 5 | Docker i środowisko | Sprawdź Compose, porty, zmienne środowiskowe i logi. |
| [x] | 6 | REST flow | Przećwicz request od frontendu do Spring Boota i bazy. |
| [x] | 7 | Debugowanie startowe | Celowo wywołaj błąd API i odczytaj go w Network tab oraz logach backendu. |
| [x] | 8 | Decyzja o migracji frontu | Przygotuj plan przejścia obecnego frontu React na Angular. |
| [x] | 9 | README i konwencje | Ustal nazwy statusów, typów i endpointów. |
| [x] | 10 | Review fundamentów | Opowiedz przepływ danych własnymi słowami. |
| [x] | 11 | Encja ProductItem | Dodaj model Product Itemu z tytułem, summary, typem i etapem. |
| [x] | 11b | Flyway i migracje bazy | Wyczyść lokalną bazę, dodaj Flyway oraz pierwszą migrację SQL tworzącą tabelę `product_items`. |
| [ ] | 12 | Repozytorium ProductItem | Dodaj repozytorium i serwis dla Product Inbox. |
| [ ] | 13 | Kontroler Inbox | Dodaj endpointy listowania i tworzenia pomysłów. |
| [ ] | 14 | Walidacja | Dodaj walidację tytułu, typu i opisu. |
| [ ] | 15 | Obsługa błędów | Dodaj spójny format błędów API. |
| [ ] | 16 | Update statusu | Dodaj zmianę statusu pomysłu. |
| [ ] | 17 | Typy wpisów | Dodaj typy: feature, bug, improvement, tech debt, research. |
| [ ] | 18 | Filtrowanie backendu | Dodaj filtrowanie po statusie i typie. |
| [ ] | 19 | Sortowanie backendu | Dodaj sortowanie po dacie utworzenia i priorytecie. |
| [ ] | 20 | Review backendu | Sprawdź endpointy przez `curl` i logi. |
| [x] | 21 | Angular start | Utwórz szkielet Angulara ze standalone components i routingiem. |
| [ ] | 22 | Model ProductItem | Zdefiniuj interfejsy `ProductItem`, `ProductItemType`, `ProductItemStage`. |
| [ ] | 23 | API service | Napisz `ProductItemsApiService` do pobierania i tworzenia Product Itemów. |
| [ ] | 24 | Lista pomysłów | Wyświetl Product Inbox z danych z backendu. |
| [ ] | 25 | Formularz Product Itemu | Dodaj Reactive Form tworzenia Product Itemu. |
| [ ] | 26 | Reactive Forms | Przećwicz walidację, submit i select w formularzu Angulara. |
| [ ] | 27 | Error handling | Pokaż błąd API w UI w kontrolowany sposób. |
| [ ] | 28 | Loading states | Dodaj loading dla pobierania i zapisu. |
| [ ] | 29 | Refaktor frontu | Wyciągnij komponenty: ProductItemList, ProductItemForm, StageBadge. |
| [ ] | 30 | Review Angulara | Spisz trzy sytuacje, gdzie Angular lub TypeScript pomógł. |
| [ ] | 31 | Angular Material | Dodaj Angular Material, theme i podstawowy layout. |
| [ ] | 32 | App shell | Zbuduj layout z sidebar, header i główną treścią. |
| [ ] | 33 | Dashboard v1 | Dodaj kafle: total ideas, backlog, active sprint, done. |
| [ ] | 34 | Material form | Użyj `mat-form-field`, `mat-select` i walidacji w formularzu. |
| [ ] | 35 | Notifications | Dodaj powiadomienia po sukcesie i błędzie. |
| [ ] | 36 | Modal | Dodaj modal do tworzenia nowego pomysłu. |
| [ ] | 37 | Table | Wyświetl inbox w `mat-table` albo prostych kartach. |
| [ ] | 38 | Select filters | Dodaj filtry etapu i typu z `mat-select`. |
| [ ] | 39 | Empty states | Dodaj stany puste dla list i filtrów. |
| [ ] | 40 | Review UI | Sprawdź, czy UI jest czytelny bez ręcznego stylowania. |
| [ ] | 41 | Backlog model | Dodaj backendowy model backlog item albo status przeniesienia do backlogu. |
| [ ] | 42 | Move to backlog | Dodaj akcję przeniesienia pomysłu do backlogu. |
| [ ] | 43 | Backlog view | Dodaj widok backlogu we frontendzie. |
| [ ] | 44 | Scoring fields | Dodaj pola `impact`, `effort`, `confidence`. |
| [ ] | 45 | Score calculation | Wylicz prosty score i pokaż go w UI. |
| [ ] | 46 | Score sorting | Sortuj backlog po score. |
| [ ] | 47 | Priority badges | Dodaj wizualne oznaczenia low, medium, high. |
| [ ] | 48 | Backlog filters | Dodaj filtrowanie backlogu po typie i priorytecie. |
| [ ] | 49 | Decision note v1 | Dodaj proste pole "dlaczego to robimy". |
| [ ] | 50 | Review scoringu | Sprawdź kilka przykładów i oceń, czy score ma sens. |
| [ ] | 51 | Roadmap model | Dodaj status roadmapy: Now, Next, Later, Done. |
| [ ] | 52 | Roadmap endpoint | Dodaj endpoint zmiany kolumny roadmapy. |
| [ ] | 53 | Roadmap UI | Dodaj widok kolumn roadmapy. |
| [ ] | 54 | Roadmap move | Dodaj zmianę kolumny bez drag and drop, np. przez select. |
| [ ] | 55 | Sprint model | Dodaj sprint: nazwa, cel, start, koniec, status. |
| [ ] | 56 | Sprint API | Dodaj tworzenie i listowanie sprintów. |
| [ ] | 57 | Sprint UI | Dodaj widok aktywnego sprintu. |
| [ ] | 58 | Sprint tasks | Dodaj zadania sprintu powiązane z backlog itemem. |
| [ ] | 59 | Sprint Board | Dodaj kolumny To Do, In Progress, Review, Done. |
| [ ] | 60 | Review roadmapy i sprintów | Przejdź flow od backlogu do sprint boarda. |
| [ ] | 61 | Drag and drop (stretch) | Opcjonalnie dodaj Angular CDK DragDrop dla boardu albo roadmapy. |
| [ ] | 62 | Persist order (stretch) | Jeśli wdrożono drag and drop, zapisuj status i kolejność po przeciągnięciu. |
| [ ] | 63 | Spec model | Dodaj specyfikację: problem, goal, user story, acceptance criteria. |
| [ ] | 64 | Spec Builder UI | Dodaj formularz specyfikacji dla backlog itemu. |
| [ ] | 65 | Comments model | Dodaj komentarze do pomysłu albo backlog itemu. |
| [ ] | 66 | Comments UI | Dodaj listę i formularz komentarzy. |
| [ ] | 67 | Activity model | Zapisuj zdarzenia: zmiana statusu, scoringu, roadmapy. |
| [ ] | 68 | Activity timeline | Wyświetl prostą historię aktywności. |
| [ ] | 69 | Stabilizacja MVP | Przejdź cały flow i zapisz błędy. |
| [ ] | 70 | Review funkcjonalny | Zdecyduj, co wyciąć przed testami, jeśli zakres jest za duży. |
| [ ] | 71 | Test serwisu | Dodaj test jednostkowy backendowego serwisu inboxa. |
| [ ] | 72 | Test kontrolera | Dodaj test `MockMvc` dla tworzenia pomysłu. |
| [ ] | 73 | Test walidacji | Przetestuj 400 dla pustego tytułu. |
| [ ] | 74 | Test repozytorium | Dodaj test zapisu encji w JPA. |
| [ ] | 75 | Test score | Przetestuj wyliczanie score. |
| [ ] | 76 | Testy Angulara | Skonfiguruj Jasmine/Karma lub Vitest i Angular Testing Library. |
| [ ] | 77 | Test komponentu | Przetestuj renderowanie pustego inboxa. |
| [ ] | 78 | Test formularza | Przetestuj wpisanie tytułu i submit. |
| [ ] | 79 | Mock API | Zamockuj klienta API w teście frontendu. |
| [ ] | 80 | Playwright smoke | Dodaj prosty test E2E: otwarcie aplikacji i widoczny dashboard. |
| [ ] | 81 | GitHub Actions backend | Dodaj workflow dla build/test backendu. |
| [ ] | 82 | GitHub Actions frontend | Dodaj workflow dla build/test frontendu. |
| [ ] | 83 | Docker build CI | Dodaj sprawdzanie budowania obrazów Docker. |
| [ ] | 84 | Cache | Dodaj cache Maven i npm. |
| [ ] | 85 | Quality gate | Ustal, że pipeline musi przejść przed merge. |
| [ ] | 86 | README final | Uzupełnij README o endpointy, uruchomienie i flow MVP. |
| [ ] | 87 | Debug pipeline | Celowo zepsuj test i naucz się czytać błąd w CI. |
| [ ] | 88 | Final polish | Popraw nazwy, komunikaty, stany puste i małe niespójności. |
| [ ] | 89 | Demo script | Przygotuj scenariusz pokazania aplikacji. |
| [ ] | 90 | Review końcowe | Przejdź projekt jak na rozmowie technicznej i spisz dalsze kroki. |

## Fiszka Po Każdym Dniu

Po każdym dniu dopisujemy jedną fiszkę do `doc/fiszki.md`.

Fiszka powinna dotyczyć mechanizmu, a nie tylko konkretnego fragmentu aplikacji. Przykłady:

- czym różni się Reactive Form od template-driven form w Angularze,
- po co typować odpowiedź API w TypeScript,
- czym różni się kontroler od serwisu w Spring Boot,
- jak działa walidacja requestu przez `@Valid`,
- czym różni się test jednostkowy od integracyjnego,
- po co pipeline CI uruchamia testy przed buildem Docker image.

## Zasady Mentoringu

W trakcie pracy:

1. Najpierw omawiamy temat.
2. Potem Ty piszesz kod.
3. Ja robię review, wyjaśniam błędy i proponuję poprawki.
4. Nie przeskakujemy do kolejnego modułu, jeśli obecny flow nie działa.
5. Debugowanie traktujemy jako część nauki, nie jako przerwę od nauki.
