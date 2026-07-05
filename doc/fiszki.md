
```
Na podstawie naszej kowersacji i plikóœ które przerabialiśmy, stwórz 1 pytanie do aplikacji do nauki. Pytania mogą być typu MCQ (wielokrotny wybór), OPEN (otwarte) lub DESCRIPTIVE (opisowe). Pytania nie powinny się odnosić konkretnie do programu który piszemy. Pytania powinny być bardziej "frameworkowe".

Format odpowiedzi - zwróć TYLKO JSON (bez dodatkowego tekstu) w następującym formacie:

[
  {
    "type": "MCQ",
    "text": "Treść pytania",
    "explanation": "Wyjaśnienie odpowiedzi (opcjonalne dla MCQ, wymagane dla DESCRIPTIVE)",
    "choices": [
      { "letter": "A", "text": "Odpowiedź A", "isCorrect": true },
      { "letter": "B", "text": "Odpowiedź B", "isCorrect": false },
      { "letter": "C", "text": "Odpowiedź C", "isCorrect": false },
      { "letter": "D", "text": "Odpowiedź D", "isCorrect": false }
    ],
    "bookName": null,
    "bookAuthor": null
  },
  {
    "type": "OPEN",
    "text": "Treść pytania otwartego",
    "modelAnswer": "Wzorcowa odpowiedź na pytanie otwarte",
    "bookName": null,
    "bookAuthor": null
  },
  {
    "type": "DESCRIPTIVE",
    "text": "Treść pytania opisowego",
    "explanation": "Szczegółowe wyjaśnienie/opis",
    "bookName": null,
    "bookAuthor": null
  }
]

Zasady:
- Dla MCQ: zawsze 4 odpowiedzi (A, B, C, D), dokładnie jedna poprawna (isCorrect: true)
- Dla OPEN: wymagane pole "modelAnswer" ze wzorcową odpowiedzią
- Dla DESCRIPTIVE: wymagane pole "explanation" z wyjaśnieniem
- Pola bookName i bookAuthor pozostaw jako null (lub puste stringi) jeśli pytanie nie pochodzi z książki
- Zwróć TYLKO JSON, bez dodatkowych komentarzy

WAŻNE - Formatowanie tekstu:
- **Listy numerowane**: używaj formatu "1) Pierwszy punkt\n2) Drugi punkt\n3) Trzeci punkt" lub "1. Pierwszy punkt\n2. Drugi punkt\n3. Trzeci punkt"
- **Bloki kodu**: używaj potrójnych backticków ```kod``` dla bloków kodu
- **Inline kod**: używaj pojedynczych backticków `kod` dla krótkich fragmentów kodu w tekście
- Przykład z kodem:
  ```json
  {
    "explanation": "Aby użyć tego podejścia:\n1) Zainstaluj zależności\n2) Skonfiguruj plik\n3) Uruchom komendę\n\nPrzykład kodu:\n```java\npublic class Example {\n    // kod\n}\n```"
  }
```