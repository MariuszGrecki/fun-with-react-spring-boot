# Konwencje domeny i API

## Język

Nazwy w kodzie, API i bazie danych są po angielsku.
Teksty widoczne dla użytkownika mogą być po polsku.

## Typy pomysłów

```txt
FEATURE
BUG
IMPROVEMENT
TECH_DEBT
RESEARCH
```

## Statusy pomysłów

NEW
IN_REVIEW
BACKLOG
REJECTED

## Endpointy
GET    /api/ideas
POST   /api/ideas
GET    /api/ideas/{id}
PATCH  /api/ideas/{id}/status
GET /api/ideas?status=NEW&type=FEATURE

Nazwy danych
JSON używa camelCase, np. createdAt.
Endpointy używają rzeczowników w liczbie mnogiej, np. /ideas.
Typy i komponenty Reacta używają PascalCase, np. IdeaForm.
Stałe enumów używają SCREAMING_SNAKE_CASE, np. IN_REVIEW.