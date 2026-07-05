# Learning Tracker

**Learning Tracker** to aplikacja do organizowania nauki programowania. Jej zadaniem jest pomagać w planowaniu tematów, zapisywaniu sesji nauki, śledzeniu postępu, tworzeniu notatek oraz budowaniu własnej bazy fiszek.

Docelowo aplikacja ma odpowiadać na proste pytania:

- czego aktualnie się uczę,
- które tematy są rozpoczęte, zakończone albo odłożone,
- ile czasu poświęcam na naukę,
- jakie notatki i fiszki powstały po danym temacie,
- które obszary wymagają powtórki.

## Funkcje Aplikacji

| Obszar | Opis |
| --- | --- |
| Tematy nauki | Dodawanie tematów, zmiana statusu, filtrowanie i wyszukiwanie. |
| Sesje nauki | Zapisywanie dnia, czasu pracy, celu i krótkiego podsumowania. |
| Notatki | Przechowywanie notatek przypisanych do tematów. |
| Fiszki | Tworzenie pytań i odpowiedzi do powtórek. |
| Statystyki | Podsumowanie postępu, czasu nauki i ukończonych tematów. |
| Konto użytkownika | Docelowo logowanie i dane przypisane do konkretnego użytkownika. |

## Technologie

| Warstwa | Technologie |
| --- | --- |
| Frontend docelowy | React, TypeScript, Next.js |
| Frontend obecny | React, Vite, JavaScript |
| Backend | Java, Spring Boot, Spring Web, Spring Data JPA |
| Baza danych | PostgreSQL |
| Testy | JUnit, Spring Boot Test, React Testing Library, Playwright albo Cypress |
| CI/CD | GitHub Actions, Docker build, automatyczne testy |
| Uruchamianie lokalne | Docker Compose |

> Frontend został rozpoczęty jako prosty React + Vite. W planie nauki jest świadoma migracja do Next.js i TypeScriptu, żeby najpierw zrozumieć podstawowy przepływ aplikacji, a potem przejść do bardziej produkcyjnego podejścia.

## Uruchomienie

```bash
docker compose up --build -d
```

Po starcie:

| Usługa | Adres |
| --- | --- |
| Frontend | http://localhost:5173 |
| Backend API | http://localhost:8081/api/topics |
| PostgreSQL | localhost:5432 |

Zatrzymanie aplikacji:

```bash
docker compose down
```

Podgląd logów:

```bash
docker compose logs -f backend
docker compose logs -f frontend
```

## Aktualny Stan

Pierwsza wersja obsługuje podstawowy przepływ pracy z tematami nauki:

1. Pobranie listy tematów z backendu.
2. Dodanie nowego tematu.
3. Zmiana statusu tematu.
4. Usunięcie tematu.

Ten przepływ przechodzi przez całą aplikację: frontend wysyła request HTTP, Spring Boot obsługuje endpoint, serwis wykonuje logikę, repozytorium zapisuje dane w PostgreSQL.

## Dokumentacja

| Plik | Opis |
| --- | --- |
| [doc/plan-nauki-90-dni.md](doc/plan-nauki-90-dni.md) | Plan nauki React, TypeScript, Next.js, Spring Boot, testów i CI/CD. |
| [doc/fiszki.md](doc/fiszki.md) | Miejsce na fiszki tworzone po kolejnych dniach nauki. |

## Zasada Pracy

Każdy dzień powinien kończyć się:

1. Małą zmianą w aplikacji albo świadomym ćwiczeniem debugowania.
2. Krótkim review kodu.
3. Jedną fiszką dopisaną do `doc/fiszki.md`.
4. Notatką, jaki błąd lub mechanizm udało się zrozumieć.
