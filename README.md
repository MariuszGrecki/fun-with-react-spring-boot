# Product Planner

**Product Planner** to aplikacja do planowania rozwoju produktu. Pomaga małym zespołom i founderom zebrać pomysły w jednym miejscu, ocenić ich priorytet, zaplanować roadmapę i zamienić decyzje produktowe w konkretne sprinty.

Główne pytanie, na które odpowiada aplikacja:

> Co powinniśmy zbudować dalej i dlaczego?

## Cel Produktu

Product Planner nie jest klasycznym task managerem. Aplikacja skupia się na decyzjach produktowych przed rozpoczęciem pracy:

- jaki problem rozwiązujemy,
- dla kogo jest ważny,
- jaki ma wpływ na produkt,
- ile wymaga pracy,
- czy pasuje do aktualnego celu produktu,
- dlaczego trafia do roadmapy albo sprintu.

Docelowy przepływ:

```txt
pomysł -> analiza -> priorytet -> roadmapa -> sprint -> realizacja -> podsumowanie
```

## MVP

Pierwsza wersja ma być mała, ale użyteczna. Zakres MVP:

| Moduł | Zakres |
| --- | --- |
| Dashboard | Najważniejsze liczby: pomysły w inboxie, top priorytety, aktywny sprint. |
| Product Inbox | Dodawanie pomysłów, bugów, usprawnień i długu technicznego. |
| Backlog | Przenoszenie wybranych pomysłów do backlogu i nadawanie statusu. |
| Scoring | Ocena `impact`, `effort`, `confidence` i wyliczony priorytet. |
| Roadmapa | Widok kolumn `Now`, `Next`, `Later`, `Done`. |
| Sprinty | Tworzenie sprintu, cel sprintu, daty i lista zadań. |
| Sprint Board | Kolumny `To Do`, `In Progress`, `Review`, `Done`. |
| Spec Builder | Prosta specyfikacja: problem, cel, user story, acceptance criteria. |
| Komentarze | Krótkie komentarze przy pomysłach i zadaniach. |
| Activity Timeline | Podstawowa historia zmian statusów i priorytetów. |

Po MVP można dodać AI, integracje, role, publiczne API i bardziej rozbudowane raporty.

## Technologie

| Warstwa | Technologia |
| --- | --- |
| Frontend | React, TypeScript, Mantine |
| Backend | Java, Spring Boot, Spring Web, Spring Data JPA |
| Baza danych | PostgreSQL |
| UI | Mantine components, Mantine forms, Mantine notifications |
| Drag and drop | `@dnd-kit` |
| Testy backendu | JUnit, Spring Boot Test, MockMvc |
| Testy frontendu | Vitest, React Testing Library |
| E2E | Playwright |
| CI/CD | GitHub Actions |
| Uruchamianie lokalne | Docker Compose |

## Uruchomienie Lokalne

```bash
docker compose up --build -d
```

Po starcie:

| Usługa | Adres |
| --- | --- |
| Frontend | http://localhost:5173 |
| Backend API | http://localhost:8081 |
| PostgreSQL | localhost:5432 |

Zatrzymanie:

```bash
docker compose down
```

Logi:

```bash
docker compose logs -f backend
docker compose logs -f frontend
```

## Kierunek Implementacji

Projekt będzie rozwijany małymi krokami:

1. Ustalenie modelu danych dla Product Plannera.
2. Przebudowa frontendu na React + TypeScript + Mantine.
3. Implementacja Product Inbox.
4. Dodanie backlogu i scoringu.
5. Dodanie roadmapy i sprintów.
6. Dodanie testów.
7. Dodanie CI/CD.

Priorytetem jest zrozumiały kod, debugowanie i realny przepływ danych przez całą aplikację.

## Dokumentacja

| Plik | Opis |
| --- | --- |
| [doc/idea.md](doc/idea.md) | Pełniejszy opis koncepcji Product Plannera. |
| [doc/mvp.md](doc/mvp.md) | Przycięty zakres MVP, estymacje i kryteria ukończenia. |
| [doc/domain-model.md](doc/domain-model.md) | Model domeny, tabele, relacje, statusy i decyzje MVP. |
| [doc/backend-architecture.md](doc/backend-architecture.md) | Architektura backendu, moduły i zasady komunikacji między modułami. |
| [doc/frontend-architecture.md](doc/frontend-architecture.md) | Architektura frontendu, feature’y, shared, API client i Mantine. |
| [doc/plan-nauki-90-dni.md](doc/plan-nauki-90-dni.md) | Plan nauki i budowy MVP na 90 dni. |
| [doc/fiszki.md](doc/fiszki.md) | Fiszki tworzone po kolejnych dniach pracy. |

## Zasada Pracy

Każdy dzień powinien kończyć się:

1. Małą zmianą w aplikacji albo świadomym ćwiczeniem debugowania.
2. Krótkim review kodu.
3. Jedną fiszką dopisaną do `doc/fiszki.md`.
4. Notatką, jaki mechanizm lub błąd udało się zrozumieć.
