# MVP Product Planner

## Decyzja na dzień 1

Budujemy **Product Planner jako wewnętrzne narzędzie do podejmowania decyzji produktowych**, nie pełny SaaS z organizacjami, rolami, AI i integracjami.

MVP ma udowodnić jeden główny przepływ:

```txt
pomysł -> analiza -> backlog -> scoring -> roadmapa -> sprint -> board
```

Najważniejsza wartość MVP:

> Użytkownik może zebrać pomysły, ocenić je, zdecydować co robić dalej i przenieść wybrane rzeczy do sprintu.

## Założenie czasowe

Zakładamy około **90 godzin pracy**, czyli 90 dni po około 1 godzinie.

To nie jest 90 godzin ciągłego kodowania. W tym czasie mieszczą się:

- nauka Angular + TypeScript + Angular Material,
- nauka Spring Boot i JPA,
- debugowanie,
- refaktor,
- testy,
- CI/CD,
- dokumentacja,
- poprawki po review.

Dlatego realny zakres funkcjonalny musi być mniejszy niż pełna wizja z `doc/idea.md`.

## Wchodzi do MVP

### 1. Dashboard

**Cel:** dać szybki obraz tego, na czym zespół powinien się skupić.

Zakres:

- liczba pomysłów w inboxie,
- liczba elementów w backlogu,
- liczba rzeczy w roadmapie `Now` i `Next`,
- aktywny sprint,
- lista top priorytetów.

Szacowany czas: **4-6h**

Uzasadnienie:

Dashboard spina aplikację i daje dobre miejsce do ćwiczenia pobierania danych, agregacji i prezentacji w Angular Material.

### 2. Product Inbox

**Cel:** zebrać wszystkie pomysły, bugi i potrzeby w jednym miejscu.

Zakres:

- lista wpisów,
- dodawanie wpisu,
- edycja podstawowych pól,
- status,
- typ wpisu,
- proste filtrowanie.

Pola:

- `title`,
- `description`,
- `type`,
- `status`,
- `source`,
- `createdAt`.

Typy:

- `FEATURE`,
- `BUG`,
- `IMPROVEMENT`,
- `TECH_DEBT`,
- `RESEARCH`.

Statusy:

- `NEW`,
- `NEEDS_REVIEW`,
- `ACCEPTED`,
- `REJECTED`.

Szacowany czas: **10-14h**

Uzasadnienie:

To pierwszy główny moduł i najlepsze miejsce do nauki CRUD, walidacji, formularzy, obsługi błędów i typowania danych.

### 3. Backlog

**Cel:** oddzielić surowe pomysły od rzeczy zaakceptowanych do dalszej analizy.

Zakres:

- przeniesienie wpisu z inboxa do backlogu,
- lista backlog itemów,
- status backlogu,
- owner jako zwykłe pole tekstowe,
- decyzja produktowa w krótkim polu tekstowym.

Statusy:

- `NEW`,
- `NEEDS_REVIEW`,
- `READY_FOR_PLANNING`,
- `LATER`,
- `REJECTED`.

Szacowany czas: **8-10h**

Uzasadnienie:

Backlog pokazuje różnicę między "ktoś coś zgłosił" a "zespół zdecydował, że warto to analizować".

### 4. Scoring

**Cel:** pomóc w priorytetyzacji bez budowania skomplikowanego modelu.

Zakres:

- `impact` od 1 do 5,
- `effort` od 1 do 5,
- `confidence` od 1 do 5,
- wyliczony score,
- sortowanie po score,
- proste badge: low / medium / high.

Proponowany wzór:

```txt
score = (impact * confidence) / effort
```

Szacowany czas: **6-8h**

Uzasadnienie:

To rdzeń Product Plannera. Aplikacja zaczyna odpowiadać na pytanie: "co warto zrobić najpierw?".

### 5. Roadmapa

**Cel:** pokazać decyzję produktową w prostym układzie planowania.

Zakres:

- kolumny `Now`, `Next`, `Later`, `Done`,
- przenoszenie backlog itemu do roadmapy,
- zmiana kolumny przez select albo prostą akcję,
- widok kart w kolumnach.

Na start bez drag and drop.

Szacowany czas: **8-10h**

Uzasadnienie:

Roadmapa jest widocznym efektem priorytetyzacji. Drag and drop jest wygodny, ale nie jest konieczny do udowodnienia wartości.

### 6. Sprinty

**Cel:** zamienić decyzje z roadmapy w konkretną pracę.

Zakres:

- tworzenie sprintu,
- nazwa sprintu,
- cel sprintu,
- data startu i końca,
- status sprintu,
- dodawanie zadań z roadmapy/backlogu.

Statusy sprintu:

- `PLANNED`,
- `ACTIVE`,
- `COMPLETED`.

Szacowany czas: **8-12h**

Uzasadnienie:

Sprinty domykają przepływ od pomysłu do realizacji.

### 7. Sprint Board

**Cel:** pokazać aktualny stan pracy w aktywnym sprincie.

Zakres:

- kolumny `To Do`, `In Progress`, `Review`, `Done`,
- karty zadań,
- zmiana statusu przez select albo przyciski,
- proste liczniki w kolumnach.

Drag and drop jako stretch, nie jako warunek MVP.

Szacowany czas: **8-10h**

Uzasadnienie:

Board jest znany użytkownikom i pozwala ćwiczyć UI aplikacyjne, stan, aktualizacje i statusy.

### 8. Spec Builder v1

**Cel:** przejść od pomysłu do minimalnej specyfikacji.

Zakres:

- `problem`,
- `goal`,
- `userStory`,
- `acceptanceCriteria`,
- `outOfScope`.

Bez AI i bez rozbudowanego edytora.

Szacowany czas: **6-8h**

Uzasadnienie:

To ważny wyróżnik względem task managera. Pokazuje, że Product Planner zaczyna od "dlaczego" i "co ma być prawdą po wdrożeniu".

### 9. Komentarze

**Cel:** umożliwić krótką dyskusję przy pomyśle albo backlog itemie.

Zakres:

- dodanie komentarza,
- lista komentarzy,
- autor jako zwykłe pole tekstowe,
- data utworzenia.

Szacowany czas: **4-6h**

Uzasadnienie:

Komentarze są przydatne, ale nie powinny urosnąć do systemu dyskusji zespołowej.

### 10. Testy i CI/CD

**Cel:** ćwiczyć jakość projektu, a nie tylko pisanie funkcji.

Zakres:

- test serwisu backendu,
- test kontrolera przez MockMvc,
- test walidacji,
- test komponentu frontendu,
- test formularza,
- prosty smoke test E2E,
- GitHub Actions dla backendu i frontendu.

Szacowany czas: **12-16h**

Uzasadnienie:

Bez testów i CI projekt będzie wyglądał jak demo. Z testami zaczyna wyglądać jak projekt pisany z myślą o utrzymaniu.

## Stretch Goals

Te funkcje są sensowne, ale robimy je tylko jeśli rdzeń działa.

### 1. Drag and drop

Zakres:

- przeciąganie kart na sprint boardzie,
- zapis statusu po dropie.

Szacowany czas: **4-8h**

Powód odłożenia:

Drag and drop łatwo pochłania dużo czasu przez edge case'y. Najpierw wystarczy zmiana statusu przez select/przycisk.

### 2. Activity Timeline v1

Zakres:

- zapis zmiany statusu,
- zapis zmiany score,
- zapis przeniesienia do roadmapy,
- prosty widok historii.

Szacowany czas: **6-10h**

Powód odłożenia:

Timeline jest wartościowy, ale wymaga dodatkowego modelu danych i podpinania zdarzeń w wielu miejscach.

### 3. Product Goals

Zakres:

- lista celów produktowych,
- przypisanie backlog itemu do celu.

Szacowany czas: **6-8h**

Powód odłożenia:

Cele produktowe są świetne, ale MVP może działać bez nich. Najpierw trzeba mieć pomysły, scoring, roadmapę i sprint.

## Po MVP

Te rzeczy mają sens po zbudowaniu stabilnego rdzenia.

- AI Inbox Cleaner,
- AI Spec Writer,
- AI Sprint Summary,
- AI Prioritization Assistant,
- organizacje,
- workspace'y,
- projekty,
- role i uprawnienia,
- logowanie,
- integracje z GitHubem,
- integracje ze Slackiem,
- publiczne API,
- webhooki,
- eksport danych,
- zaawansowany dashboard,
- raporty tygodniowe,
- capacity planning,
- dependency tracking.

## Nie robimy teraz

Tych rzeczy świadomie unikamy w pierwszych 90 godzinach:

- pełnego klona Jiry, ClickUpa albo Linear,
- rozbudowanego systemu uprawnień,
- SSO,
- Redis,
- RabbitMQ,
- S3,
- WebSocketów,
- zaawansowanego edytora dokumentów,
- rozbudowanego Gantta,
- time trackingu,
- whiteboardów,
- czatu zespołowego,
- pełnego modułu billingowego,
- prawdziwego AI z płatnym API.

## Rekomendowana kolejność budowy

1. **Product Inbox**  
   Najpierw CRUD, walidacja i podstawowy UI.

2. **Backlog + scoring**  
   Dopiero tutaj aplikacja zaczyna mieć sens produktowy.

3. **Roadmapa**  
   Pokazuje plan i decyzje.

4. **Sprinty + sprint board**  
   Zamienia plan w pracę.

5. **Spec Builder**  
   Dodaje warstwę "dlaczego i co dokładnie budujemy".

6. **Komentarze**  
   Uzupełniają kontekst.

7. **Testy + CI/CD**  
   Stabilizują projekt i uczą profesjonalnego workflow.

8. **Stretch: drag and drop albo activity timeline**  
   Wybieramy tylko jedno, jeśli zostanie czas.

## Estymacja całego MVP

| Obszar | Estymacja |
| --- | ---: |
| Fundamenty i architektura | 6-8h |
| Product Inbox | 10-14h |
| Backlog | 8-10h |
| Scoring | 6-8h |
| Roadmapa | 8-10h |
| Sprinty | 8-12h |
| Sprint Board | 8-10h |
| Spec Builder | 6-8h |
| Komentarze | 4-6h |
| Dashboard | 4-6h |
| Testy i CI/CD | 12-16h |
| Refaktor, debugowanie, dokumentacja | 8-12h |

Razem: **88-120h**

Wniosek:

> Pełny zakres MVP jest na granicy 90 godzin. Musimy traktować activity timeline, drag and drop i product goals jako stretch goals, a nie warunek ukończenia.

## Twardy MVP na 90 godzin

Jeśli czas zacznie uciekać, minimalny zakres, którego bronimy, to:

1. Product Inbox.
2. Backlog.
3. Scoring.
4. Roadmapa.
5. Sprint.
6. Sprint Board bez drag and drop.
7. Spec Builder v1.
8. Podstawowe testy backendu i frontendu.
9. GitHub Actions.

To wystarczy, żeby pokazać pełny proces:

```txt
mam pomysł -> oceniam go -> planuję -> realizuję w sprincie
```

## Kryteria ukończenia MVP

MVP uznajemy za ukończone, gdy można wykonać taki scenariusz:

1. Użytkownik dodaje pomysł do Product Inboxa.
2. Użytkownik akceptuje pomysł do backlogu.
3. Użytkownik ocenia `impact`, `effort`, `confidence`.
4. Aplikacja pokazuje score.
5. Użytkownik przenosi element do roadmapy.
6. Użytkownik dodaje element do sprintu.
7. Użytkownik przesuwa zadanie po statusach sprint boarda.
8. Użytkownik dopisuje prostą specyfikację.
9. Dashboard pokazuje aktualny stan.
10. Testy i CI potwierdzają, że podstawowy flow działa.

## Najważniejsza decyzja produktowa

Nie budujemy "wszystkiego po trochu".

Budujemy jedną spójną ścieżkę:

```txt
od pomysłu do sprintu
```

Każda nowa funkcja musi przejść pytanie:

> Czy ta funkcja pomaga użytkownikowi zdecydować, co budować dalej, albo zamienić tę decyzję w sprint?

Jeśli nie, odkładamy ją po MVP.
