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

## Etapy Product Itemu

CONCEPT
BACKLOG
ROADMAP
ARCHIVED

## Endpointy
GET    /api/product-items
POST   /api/product-items
GET    /api/product-items/{id}
PATCH  /api/product-items/{id}/stage
GET    /api/product-items?stage=CONCEPT&type=FEATURE

Nazwy danych
JSON używa camelCase, np. createdAt.
Endpointy używają rzeczowników w liczbie mnogiej, np. /product-items.
Klasy, interfejsy i komponenty Angulara używają PascalCase, np. ProductItemFormComponent.
Stałe enumów używają SCREAMING_SNAKE_CASE, np. IN_REVIEW.
