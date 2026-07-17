# Plan migracji frontendu na Angular

## Cel

Zastąpić frontend React aplikacją Angular, bez psucia połączenia z backendem Spring Boot.

## Zasada bezpieczeństwa

Najpierw tworzymy niezależny szkielet Angulara, a dopiero po jego pomyślnym uruchomieniu usuwamy kod Reacta. Po każdym etapie sprawdzamy build oraz połączenie z backendem.

## Etapy

1. Utworzyć aplikację Angular ze standalone components i routingiem.
2. Skonfigurować adres API w środowisku oraz `HttpClient`.
3. Dodać `ProductItemsApiService` i typowane DTO dla `/api/product-items`.
4. Zbudować pierwszy widok Product Inbox z loadingiem, błędem i pustym stanem.
5. Dodać Reactive Form do tworzenia Product Itemu.
6. Dodać Angular Material: layout, pola formularza, tabelę, dialog i powiadomienia.
7. Dopiero po potwierdzeniu działania usunąć zależności i pliki Reacta.

## Kryterium ukończenia

Frontend buduje się poleceniem `npm run build`, uruchamia przez Docker Compose i poprawnie pobiera dane z backendowego endpointu `/api/product-items`.
