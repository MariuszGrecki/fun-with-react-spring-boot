# Model Domeny

## Cel dnia 2

Celem dnia 2 było ustalenie modelu domeny przed pisaniem encji JPA.

Najważniejsza decyzja:

> Nie robimy osobnych tabel `ideas`, `backlog_items` i `roadmap_items` jako kolejnych kopii tego samego opisu. Robimy jeden główny rekord `product_items`, a etap procesu zapisujemy w polach i tabelach pomocniczych.

To ogranicza duplikację `title` / `description`, upraszcza zapytania i nadal pozwala modelować backlog, roadmapę, sprinty, komentarze, specyfikacje i historię.

## Główny przepływ

```txt
ProductItem -> backlog/scoring -> roadmap -> sprint -> sprint board
```

W praktyce:

```txt
product_items.stage = CONCEPT
product_items.stage = BACKLOG
product_items.stage = ROADMAP

sprint_items łączy product_items ze sprintem
```

Nie przenosimy fizycznie rekordu między tabelami. Zmieniamy jego etap i dopisujemy dane pomocnicze.

## Tabele MVP

Na start przyjmujemy taki model:

```txt
product_items
product_item_contents
product_item_specs
product_item_comments
product_item_events
sprints
sprint_items
```

## product_items

Główna tabela dla rzeczy produktowej: pomysłu, buga, usprawnienia, długu technicznego albo researchu.

To jest główne źródło prawdy dla danych listowych.

Proponowane pola:

```txt
id
title
summary
type
stage
source
impact
effort
confidence
roadmap_column
created_at
updated_at
```

### Dlaczego `summary`, ale bez pełnego `description`

`summary` trzymamy w `product_items`, bo jest potrzebne w listach, tabelach, kartach i dashboardzie.

Pełny opis może być długi, zawierać markdown, tabelki, obrazki albo linki. Dlatego pełny content przenosimy do `product_item_contents`.

Lista może pobierać lekki DTO:

```txt
id, title, summary, type, stage, score
```

Szczegóły itemu pobierają dopiero pełny content, specyfikację, komentarze i historię.

## product_item_contents

Tabela z pełnym opisem itemu.

Proponowane pola:

```txt
id
product_item_id
content
format
created_at
updated_at
```

Format na MVP:

```txt
MARKDOWN
```

Obrazki na start mogą być linkami w markdownie. Upload plików odkładamy po MVP.

## product_item_specs

Tabela dla Spec Buildera.

Proponowane pola:

```txt
id
product_item_id
problem
goal
user_story
acceptance_criteria
out_of_scope
created_at
updated_at
```

Specyfikacja nie jest tym samym co opis itemu.

- `content` opisuje kontekst i pełny opis zgłoszenia.
- `spec` opisuje decyzję wykonawczą: co budujemy i po czym poznamy, że jest gotowe.

## product_item_comments

Komentarze przy itemie.

Proponowane pola:

```txt
id
product_item_id
author_name
body
created_at
updated_at
```

Na MVP nie budujemy użytkowników i ról, więc `author_name` wystarczy jako zwykłe pole tekstowe.

## product_item_events

Historia tego, co działo się z itemem.

Proponowane pola:

```txt
id
product_item_id
event_type
message
old_value
new_value
created_at
```

Przykładowe typy eventów:

```txt
CREATED
STAGE_CHANGED
SCORE_CHANGED
ROADMAP_COLUMN_CHANGED
ADDED_TO_SPRINT
REMOVED_FROM_SPRINT
SPRINT_STATUS_CHANGED
COMMENT_ADDED
SPEC_UPDATED
```

To nie jest event sourcing. To prosta tabela audytowa.

Przykład logiki:

```txt
changeStage(productItemId, BACKLOG)
1. Pobierz product item.
2. Zapamiętaj stary stage.
3. Ustaw nowy stage.
4. Zapisz product item.
5. Zapisz ProductItemEvent typu STAGE_CHANGED.
```

## sprints

Tabela sprintów.

Proponowane pola:

```txt
id
number
name
goal
starts_at
ends_at
status
created_at
updated_at
```

Statusy:

```txt
PLANNED
ACTIVE
COMPLETED
```

Sprint nie jest dzieckiem roadmapy. Sprint to pojemnik na pracę w określonym czasie.

## sprint_items

Tabela łącząca sprint z product itemem.

To jest odpowiednik zadania na sprint boardzie.

Proponowane pola:

```txt
id
sprint_id
product_item_id
board_status
sort_order
created_at
updated_at
```

Statusy boarda:

```txt
TODO
IN_PROGRESS
REVIEW
DONE
```

Dzięki `sprint_items` ten sam `product_item` może trafić do sprintu, a status pracy w sprincie nie miesza się z etapem produktowym.

## Statusy i enumy

### ProductItemType

```txt
FEATURE
BUG
IMPROVEMENT
TECH_DEBT
RESEARCH
```

### ProductItemStage

```txt
CONCEPT
BACKLOG
ROADMAP
ARCHIVED
```

Znaczenie:

- `CONCEPT` - item jest w Product Inboxie.
- `BACKLOG` - item został zaakceptowany do analizy i scoringu.
- `ROADMAP` - item został zaplanowany na roadmapie.
- `ARCHIVED` - item został odłożony albo zamknięty bez realizacji.

### RoadmapColumn

```txt
NOW
NEXT
LATER
DONE
```

`roadmap_column` ma sens głównie wtedy, gdy:

```txt
stage = ROADMAP
```

### SprintStatus

```txt
PLANNED
ACTIVE
COMPLETED
```

### SprintBoardStatus

```txt
TODO
IN_PROGRESS
REVIEW
DONE
```

## Relacje

```txt
product_items 1 -> 0..1 product_item_contents
product_items 1 -> 0..1 product_item_specs
product_items 1 -> many product_item_comments
product_items 1 -> many product_item_events

sprints 1 -> many sprint_items
product_items 1 -> many sprint_items
```

W MVP zakładamy, że item może być dodany do sprintu więcej niż raz w czasie, ale nie powinien być dodany dwa razy do tego samego aktywnego sprintu.

## Dlaczego nie fizyczne przenoszenie rekordu

Nie robimy:

```txt
insert do backlog_items
delete z ideas
```

Powody:

- tracimy stabilne ID głównego itemu,
- komplikujemy historię,
- musimy kopiować `title` i `description`,
- trudniej linkować komentarze, specyfikację i eventy,
- łatwo zgubić kontekst.

Lepszy model:

```txt
product_items = główny rekord
stage = aktualny etap
tabele pomocnicze = content, spec, komentarze, historia, sprint board
```

## Wydajność

Ten model jest wydajny dla MVP i dalej, jeśli pilnujemy kilku zasad:

1. Listy pobierają lekkie DTO bez pełnego contentu.
2. Szczegóły itemu pobierają content, spec, komentarze i eventy osobnymi endpointami albo tylko w widoku szczegółów.
3. Dodajemy indeksy pod najczęstsze filtry.
4. Nie pobieramy relacji leniwie w pętli, żeby nie zrobić problemu N+1.
5. Stosujemy paginację.

Proponowane indeksy:

```txt
product_items(stage)
product_items(stage, roadmap_column)
product_items(type)
product_items(created_at)
sprint_items(sprint_id)
sprint_items(product_item_id)
sprint_items(board_status)
product_item_events(product_item_id, created_at)
```

## Decyzje MVP

1. Używamy `product_items`, a nie osobnych tabel `ideas`, `backlog_items`, `roadmap_items`.
2. `summary` jest w `product_items`.
3. Pełny opis jest w `product_item_contents`.
4. Specyfikacja jest osobną tabelą `product_item_specs`.
5. Komentarze są w `product_item_comments`.
6. Historia zmian jest w `product_item_events`.
7. Sprint board opiera się o `sprint_items`.
8. Na MVP nie robimy uploadu plików.
9. Na MVP nie robimy użytkowników, ról ani organizacji.
10. Na MVP nie robimy soft delete jako domyślnego mechanizmu przepływu.

## Otwarte pytania

1. Czy `product_item_contents` ma być zawsze tworzone razem z `product_items`, czy dopiero po wejściu w szczegóły?
2. Czy `acceptance_criteria` w `product_item_specs` trzymamy jako markdown, czy później jako osobne checklist items?
3. Czy `product_item_events.old_value` i `new_value` wystarczą jako tekst, czy docelowo chcemy JSON?
4. Czy `sprint_items` powinno mieć własny `title`, jeśli zadanie sprintowe jest tylko częścią większego itemu?

Na MVP odpowiedzi mogą być proste:

- content tworzymy razem z itemem,
- acceptance criteria jako markdown,
- old/new value jako tekst,
- `sprint_items` bez własnego title, dopóki nie poczujemy realnej potrzeby rozbijania itemu na mniejsze taski.
