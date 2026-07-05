# Plan Nauki na 90 Dni

Plan zakłada około 1 godzinę dziennie. Celem jest dojście do swobody w budowaniu aplikacji webowej z Reactem, TypeScriptem, Next.js i Spring Bootem, ale też w debugowaniu, testowaniu i pracy z CI/CD.

## Główna Zasada

Nie uczymy się przez przepisywanie tutoriala. Każdy dzień ma kończyć się małym, konkretnym efektem:

1. Rozumiesz jeden temat.
2. Piszesz samodzielnie mały fragment kodu.
3. Debugujesz przynajmniej jeden problem albo świadomie sprawdzasz zachowanie aplikacji.
4. Dopisujesz jedną fiszkę do `doc/fiszki.md`.

## Etapy

| Dni | Etap | Cel |
| --- | --- | --- |
| 1-10 | Fundamenty projektu | Zrozumieć działający przepływ: frontend -> API -> backend -> baza. |
| 11-20 | Spring Boot REST API | Kontrolery, serwisy, repozytoria, walidacja, błędy. |
| 21-30 | React i TypeScript | Komponenty, stan, propsy, typowanie danych i requestów. |
| 31-40 | Migracja do Next.js | Routing, struktura Next.js, server/client components na rozsądnym poziomie. |
| 41-50 | Funkcje aplikacji | Notatki, sesje nauki, relacje w bazie, filtrowanie. |
| 51-60 | Debugowanie i refaktor | Network tab, logi backendu, stack trace, refaktor frontu i backendu. |
| 61-72 | Testy | Backend, frontend, integracja i podstawowe E2E. |
| 73-82 | CI/CD | GitHub Actions, buildy, testy automatyczne, Docker image. |
| 83-90 | Finalizacja | Stabilizacja, dokumentacja, demo i przygotowanie projektu do pokazania. |

## Plan Dzienny

| Dzień | Temat | Zadanie |
| --- | --- | --- |
| 1 | Mapa aplikacji | Przejdź przez aktualny przepływ `App.jsx -> api.js -> TopicController -> TopicService -> TopicRepository`. |
| 2 | Docker Compose | Zrozum usługi `frontend`, `backend`, `db`, porty i zmienne środowiskowe. |
| 3 | HTTP i REST | Przetestuj `GET`, `POST`, `PATCH`, `DELETE` przez UI i `curl`. |
| 4 | Debugowanie requestów | Użyj Network tab i logów backendu do sprawdzenia jednego requestu od początku do końca. |
| 5 | React state | Przećwicz `useState` na formularzu dodawania tematu. |
| 6 | React effect | Zrozum `useEffect` i moment pobierania danych z API. |
| 7 | Spring Controller | Omów adnotacje `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`. |
| 8 | Service layer | Zrozum, dlaczego logika nie powinna siedzieć bezpośrednio w kontrolerze. |
| 9 | JPA Repository | Przećwicz `JpaRepository`, `findAll`, `save`, `deleteById`. |
| 10 | Review fundamentów | Opowiedz własnymi słowami, co dzieje się po kliknięciu "Dodaj". |
| 11 | DTO requestu | Rozbuduj request tworzenia tematu i zrozum rekordy w Javie. |
| 12 | Walidacja backendu | Dodaj lub popraw walidację pustego tytułu. |
| 13 | Obsługa błędów | Dodaj spójniejszy format błędu dla 400 i 404. |
| 14 | Enum statusu | Przećwicz statusy `TODO`, `IN_PROGRESS`, `DONE`. |
| 15 | Update tematu | Dodaj endpoint do zmiany tytułu tematu. |
| 16 | Filtrowanie API | Dodaj filtrowanie tematów po statusie. |
| 17 | Wyszukiwanie API | Dodaj wyszukiwanie po fragmencie tytułu. |
| 18 | Paginacja | Dodaj prostą paginację na backendzie. |
| 19 | Debug SQL | Włącz logowanie SQL i zobacz zapytania generowane przez JPA. |
| 20 | Review backendu | Przejrzyj kontroler, serwis, repozytorium i wyjątki. |
| 21 | TypeScript start | Wprowadź podstawy typów: `string`, `number`, union types, typ obiektu. |
| 22 | Typ danych z API | Zdefiniuj typ `Topic` po stronie frontendu. |
| 23 | Typowanie funkcji API | Nadaj typy funkcjom pobierającym i zapisującym dane. |
| 24 | Typowanie propsów | Rozbij UI na komponenty i typuj propsy. |
| 25 | Typowanie eventów | Przećwicz typowanie `onChange`, `onSubmit`, `MouseEvent`. |
| 26 | Union type dla statusu | Zdefiniuj typ statusu tematu jako union albo enum. |
| 27 | Type narrowing | Obsłuż sytuacje, gdy dane mogą być puste albo błędne. |
| 28 | Błędy TypeScriptu | Celowo popsuj typ i naucz się czytać komunikat kompilatora. |
| 29 | Refaktor frontu | Uporządkuj komponenty z użyciem typów. |
| 30 | Review TypeScript | Opisz, gdzie TS realnie pomógł uniknąć błędu. |
| 31 | Next.js: po co | Zrozum różnicę między Vite React a Next.js. |
| 32 | Struktura Next.js | Poznaj `app`, `page.tsx`, `layout.tsx`, routing plikowy. |
| 33 | Migracja startowa | Przygotuj plan migracji frontendu z Vite do Next.js. |
| 34 | Pierwsza strona Next | Utwórz bazową stronę listy tematów w Next.js. |
| 35 | Client components | Zrozum `"use client"` i kiedy komponent potrzebuje stanu. |
| 36 | Server components | Zrozum, kiedy komponent może zostać server component. |
| 37 | Fetch w Next.js | Porównaj pobieranie danych po stronie klienta i serwera. |
| 38 | Routing | Dodaj stronę szczegółów tematu. |
| 39 | Formularze w Next.js | Przenieś formularz dodawania tematu do Next.js. |
| 40 | Review migracji | Sprawdź, czy aplikacja działa po przejściu na Next.js. |
| 41 | Model notatek | Zaprojektuj encję `Note` powiązaną z tematem. |
| 42 | Backend notatek | Dodaj endpointy listowania i tworzenia notatek. |
| 43 | Frontend notatek | Wyświetl notatki przypisane do tematu. |
| 44 | Walidacja notatek | Obsłuż pustą treść i zbyt długie notatki. |
| 45 | Model sesji nauki | Zaprojektuj encję `StudySession`. |
| 46 | Backend sesji | Dodaj tworzenie i listowanie sesji nauki. |
| 47 | Frontend sesji | Dodaj widok ostatnich sesji. |
| 48 | Relacje JPA | Zrozum relacje `Topic -> Note` i `Topic -> StudySession`. |
| 49 | Filtrowanie i sortowanie | Dodaj filtrowanie tematów, notatek albo sesji. |
| 50 | Review funkcji | Przejdź pełny scenariusz: temat, notatka, sesja, status. |
| 51 | Debug backendu | Naucz się czytać stack trace Spring Boota. |
| 52 | Debug frontu | Naucz się sprawdzać state, propsy i requesty w przeglądarce. |
| 53 | Debug Dockera | Przećwicz `docker compose ps`, `logs`, `down`, `up`. |
| 54 | Problem CORS | Zrozum CORS i sprawdź konfigurację backendu. |
| 55 | Problem z bazą | Celowo zatrzymaj bazę i zobacz zachowanie backendu. |
| 56 | Refaktor kontrolera | Uporządkuj kontrolery i odpowiedzi API. |
| 57 | Refaktor serwisu | Uprość logikę serwisów i nazwy metod. |
| 58 | Refaktor React/Next | Wyciągnij większe fragmenty UI do komponentów. |
| 59 | Refaktor API clienta | Uporządkuj funkcje komunikacji z backendem. |
| 60 | Review debugowania | Spisz najczęstsze błędy i sposób diagnozy. |
| 61 | Testy jednostkowe backendu | Dodaj test serwisu z mockowanym repozytorium. |
| 62 | Testy kontrolera | Dodaj test `MockMvc` dla listy tematów. |
| 63 | Test walidacji | Przetestuj odpowiedź 400 dla pustych danych. |
| 64 | Test repozytorium | Dodaj test JPA dla zapisu i odczytu encji. |
| 65 | Test integracyjny | Przetestuj przepływ API z kontekstem Spring Boot. |
| 66 | Testy frontendu | Dodaj React Testing Library do sprawdzenia renderowania listy. |
| 67 | Test formularza | Przetestuj wpisanie danych i submit formularza. |
| 68 | Mockowanie API | Zamockuj requesty frontendu w testach. |
| 69 | Test błędu UI | Sprawdź, czy błąd API pokazuje komunikat użytkownikowi. |
| 70 | E2E wstęp | Dodaj prosty scenariusz E2E: wejście, dodanie tematu, zmiana statusu. |
| 71 | Pokrycie ryzyka | Wybierz najważniejsze ścieżki do testowania, nie gonimy samych procentów. |
| 72 | Review testów | Uporządkuj nazwy testów i dane testowe. |
| 73 | GitHub Actions start | Dodaj workflow uruchamiający testy backendu. |
| 74 | CI frontendu | Dodaj workflow uruchamiający build/test frontendu. |
| 75 | Jeden pipeline | Połącz backend i frontend w jeden pipeline pull requesta. |
| 76 | Docker build w CI | Dodaj sprawdzanie budowania obrazów Docker. |
| 77 | Cache zależności | Dodaj cache Maven i npm/pnpm. |
| 78 | Quality gate | Ustal, że testy i build muszą przejść przed merge. |
| 79 | Zmienne środowiskowe | Uporządkuj konfigurację przez env vars. |
| 80 | Sekrety | Zrozum, czego nie trzymać w repozytorium. |
| 81 | Smoke test | Dodaj prosty test dostępności API po starcie. |
| 82 | Review CI/CD | Celowo zepsuj build i zdebuguj pipeline. |
| 83 | Dokumentacja API | Dopisz listę endpointów i przykładowe requesty. |
| 84 | Dokumentacja uruchomienia | Upewnij się, że README pozwala odpalić projekt od zera. |
| 85 | Stabilizacja błędów | Sprawdź przypadki: 400, 404, brak backendu, brak bazy. |
| 86 | Poprawa UX bez stylowania | Uporządkuj komunikaty, loadingi i stany puste. |
| 87 | Finalny refaktor | Usuń martwy kod, powtórzenia i zbędne logi. |
| 88 | Demo aplikacji | Przygotuj scenariusz pokazania aplikacji komuś innemu. |
| 89 | Podsumowanie techniczne | Spisz decyzje: Next.js, TypeScript, Spring Boot, PostgreSQL, Docker, CI. |
| 90 | Review końcowe | Przejdź projekt jak na rozmowie technicznej i przygotuj listę dalszych kroków. |

## Testy i CI/CD w Planie

Testy i CI/CD nie są dodatkiem na końcu. Wchodzą w plan jako normalna część pracy:

- backend: od dnia 61,
- frontend: od dnia 66,
- E2E: od dnia 70,
- CI/CD: od dnia 73,
- smoke test i debug pipeline: dni 81-82.

## Fiszka Po Każdym Dniu

Na koniec dnia dopisujemy jedną fiszkę do `doc/fiszki.md`. Fiszka ma dotyczyć mechanizmu, frameworka albo narzędzia, na przykład:

- czym różni się server component od client component w Next.js,
- po co typować odpowiedź API w TypeScript,
- czym różni się test jednostkowy od integracyjnego,
- jak czytać status HTTP 400, 404 i 500,
- po co w CI uruchamiać testy przed buildem obrazu Docker.
