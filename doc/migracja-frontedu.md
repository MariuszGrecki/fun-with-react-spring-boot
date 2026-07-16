# Plan migracji frontendu

## Cel

Przejść z React JavaScript na React + TypeScript + Mantine,
bez psucia działającego połączenia z backendem Spring Boot.

## Etapy

1. Dodać obsługę TypeScript w Vite.
2. Zmienić pliki `.jsx` i `.js` na `.tsx` oraz `.ts`.
3. Dodać typy danych API: `Topic` i `TopicStatus`.
4. Podzielić `App` na komponenty funkcjonalne.
5. Dodać Mantine Provider oraz zastąpić podstawowe elementy UI komponentami Mantine.

## Zasada bezpieczeństwa

Po każdym etapie aplikacja ma się budować i nadal pobierać dane
z endpointu `GET /api/topics`.

## Struktura docelowa

src/
  app/
  api/
  features/inbox/
  shared/