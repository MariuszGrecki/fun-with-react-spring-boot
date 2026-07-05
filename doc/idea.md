# Plan produktu: Product Planner

## 1. Czym jest Product Planner

**Product Planner** to aplikacja SaaS do planowania rozwoju produktu, priorytetyzacji pomysłów, zarządzania backlogiem, tworzenia roadmapy oraz organizowania pracy w lekkich sprintach.

Nie jest to klasyczny task manager ani kopia ClickUpa, Jiry czy Linear. Product Planner ma pomagać zespołom produktowym i founderom odpowiedzieć na najważniejsze pytanie:

**Co powinniśmy zbudować dalej i dlaczego?**

Aplikacja prowadzi użytkownika przez cały proces:

**pomysł → analiza → priorytet → roadmapa → sprint → realizacja → podsumowanie**

## 2. Główna obietnica produktu

**Product Planner pomaga małym zespołom SaaS i founderom zamieniać pomysły w jasny plan rozwoju produktu oraz konkretne sprinty do wykonania.**

Krótka wersja po angielsku:

**Prioritize product ideas, plan your roadmap, and turn decisions into focused sprints.**

Krótka wersja po polsku:

**Priorytetyzuj pomysły, planuj roadmapę i zamieniaj decyzje produktowe w konkretne sprinty.**

## 3. Dla kogo jest produkt

Product Planner jest skierowany do:

* indie founderów,
* małych zespołów SaaS,
* startupów,
* software house’ów,
* zespołów produktowo-technicznych,
* zespołów od 1 do 20 osób,
* osób, które mają chaos w Notion, Trello, Excelu, Slacku i mailach,
* firm, które nie chcą wdrażać ciężkiego systemu typu Jira, ClickUp czy Linear.

Najlepszy pierwszy klient:

**Founder albo mały zespół SaaS, który ma dużo pomysłów, feedbacku, bugów i planów, ale nie ma prostego systemu do podejmowania decyzji, co robić dalej.**

## 4. Główny problem

Małe zespoły często mają pomysły rozproszone w wielu miejscach:

* notatki,
* rozmowy z klientami,
* Slack,
* Discord,
* maile,
* arkusze,
* Trello,
* Notion,
* GitHub issues,
* prywatne listy founderów.

Problem nie polega tylko na tym, że nie mają listy zadań.

Prawdziwy problem brzmi:

**Nie wiedzą, które pomysły są naprawdę ważne, które powinny trafić do roadmapy i które warto wziąć do najbliższego sprintu.**

Product Planner ma rozwiązać właśnie ten problem.

## 5. Na jakim modelu polegamy

Product Planner działa jako **wewnętrzny system planowania produktu i organizowania pracy nad rozwojem aplikacji**.

Aplikacja jest źródłem prawdy dla:

* pomysłów produktowych,
* backlogu,
* priorytetów,
* roadmapy,
* sprintów,
* decyzji produktowych,
* statusów realizacji,
* specyfikacji funkcji,
* historii decyzji.

Nie jest to narzędzie do publicznego feedbacku. To narzędzie dla zespołu.

## 6. Najważniejsza różnica względem task managerów

Typowy task manager zaczyna od pytania:

**Jakie zadania mamy do zrobienia?**

Product Planner zaczyna od pytania:

**Dlaczego mamy to zrobić?**

Każde zadanie powinno mieć kontekst:

* jaki problem rozwiązuje,
* dla kogo jest ważne,
* jaki ma wpływ,
* ile kosztuje pracy,
* jak pasuje do celu produktu,
* dlaczego trafiło do roadmapy,
* dlaczego trafiło do sprintu.

Dzięki temu aplikacja nie jest tylko listą zadań, ale systemem podejmowania decyzji produktowych.

## 7. Główne moduły produktu

## 7.1 Product Inbox

Product Inbox to miejsce, gdzie trafiają wszystkie pomysły, problemy i potrzeby.

Typy wpisów:

* feature idea,
* bug,
* improvement,
* tech debt,
* research,
* internal idea,
* customer need,
* sales objection,
* UX problem,
* performance issue.

Każdy wpis może mieć:

* tytuł,
* opis,
* typ,
* kategorię,
* tagi,
* źródło,
* priorytet,
* właściciela,
* status,
* komentarze zespołu,
* załączniki,
* linki,
* datę dodania.

Celem Product Inboxa nie jest natychmiastowe tworzenie zadań. Celem jest zebranie wszystkich sygnałów w jednym miejscu i późniejsze podjęcie decyzji, co z nimi zrobić.

## 7.2 AI Inbox Cleaner

AI pomaga porządkować chaos w Product Inboxie.

AI może:

* wykrywać podobne pomysły,
* sugerować duplikaty,
* proponować kategorię,
* dodawać tagi,
* skracać długie opisy,
* poprawiać niejasne zgłoszenia,
* wyciągać główny problem,
* zamieniać chaotyczną notatkę w czytelny opis.

Przykład:

Użytkownik wpisuje:

**„Klienci znowu pytają o PDF faktur, chyba trzeba dodać eksport, bo księgowość marudzi.”**

AI porządkuje to jako:

**Problem:** Użytkownicy potrzebują eksportu faktur do PDF, aby przekazywać dokumenty księgowości.
**Proponowana funkcja:** Eksport pojedynczej faktury oraz eksport zbiorczy.
**Typ:** Feature
**Kategoria:** Billing
**Sugerowany priorytet:** Medium / High

## 7.3 Backlog

Backlog to miejsce, gdzie trafiają pomysły zaakceptowane do dalszego rozważenia.

Statusy backlogu:

* New,
* Needs Review,
* Accepted,
* Rejected,
* Later,
* Ready for Planning.

Każdy backlog item może mieć:

* opis problemu,
* proponowane rozwiązanie,
* impact,
* effort,
* confidence,
* business value,
* strategic fit,
* owner,
* status,
* komentarze,
* linked tasks,
* linked roadmap item,
* linked sprint.

Backlog nie powinien być tylko listą zadań. Powinien pokazywać, dlaczego dana rzecz istnieje i czy warto się nią zajmować.

## 7.4 Priorytetyzacja

Product Planner powinien mieć prosty system scoringu.

Możliwe modele:

* ICE,
* RICE,
* Value vs Effort,
* custom score.

Na start najlepszy będzie prosty model:

| Kryterium      | Znaczenie                                                     |
| -------------- | ------------------------------------------------------------- |
| Impact         | Jak duży wpływ będzie miała funkcja                           |
| Effort         | Ile pracy wymaga                                              |
| Confidence     | Jak bardzo jesteśmy pewni decyzji                             |
| Business Value | Czy pomaga zarabiać, utrzymać klientów albo zmniejszyć koszty |
| Strategic Fit  | Czy pasuje do obecnego kierunku produktu                      |

Na podstawie tych danych aplikacja wylicza priorytet, ale ostateczna decyzja należy do zespołu.

## 7.5 AI Prioritization Assistant

AI pomaga zrozumieć, które pomysły warto rozważyć jako pierwsze.

AI może sugerować:

* szybkie wygrane,
* funkcje o dużym wpływie,
* rzeczy o niskim effort i wysokim impact,
* pomysły pasujące do obecnego celu produktu,
* pomysły, które warto odłożyć,
* pomysły, które wymagają lepszego researchu.

Przykład rekomendacji:

**„Eksport faktur do PDF wygląda na dobrego kandydata do najbliższego sprintu, ponieważ ma wysoki wpływ biznesowy, średni effort i bezpośrednio wspiera obszar billing.”**

AI nie podejmuje decyzji za zespół. AI tylko pomaga szybciej analizować dane.

## 7.6 Product Goals

Aplikacja powinna pozwalać definiować cele produktowe.

Przykładowe cele:

* poprawić onboarding,
* zwiększyć aktywację użytkowników,
* zmniejszyć churn,
* zwiększyć konwersję trial → paid,
* poprawić performance,
* rozbudować billing,
* przygotować funkcje enterprise,
* poprawić UX panelu administracyjnego.

Każdy pomysł, zadanie lub roadmap item może być powiązany z celem.

Dzięki temu zespół może ocenić:

**Czy to, co chcemy zrobić, naprawdę wspiera aktualny kierunek produktu?**

## 7.7 Roadmapa

Roadmapa pokazuje plan rozwoju produktu.

Na start najlepszy układ:

* Now,
* Next,
* Later,
* Done.

Opcjonalnie później:

* miesięczna roadmapa,
* kwartalna roadmapa,
* roadmapa per product area,
* roadmapa per cel produktowy,
* widok timeline.

Każdy element roadmapy powinien mieć:

* tytuł,
* opis,
* status,
* ownera,
* priorytet,
* powiązany cel,
* scoring,
* planowany termin,
* powiązane zadania,
* powiązany sprint,
* notatki decyzyjne.

## 7.8 Decision Notes

To ważny moduł, który może wyróżnić produkt.

Przy każdym większym pomyśle zespół może zapisać:

* dlaczego to robimy,
* dlaczego teraz,
* jakie były alternatywy,
* dlaczego coś odrzucamy,
* jakie ryzyka widzimy,
* jaki efekt chcemy osiągnąć.

Przykład:

**Decyzja:** Dodajemy eksport faktur do PDF w następnym sprincie.
**Powód:** Funkcja wspiera billing, zmniejsza ręczną pracę użytkowników i jest stosunkowo szybka do wdrożenia.
**Alternatywa:** Eksport CSV został odłożony na później.
**Ryzyko:** Różne formaty faktur mogą zwiększyć zakres prac.

To buduje pamięć produktu. Po kilku miesiącach zespół wie, dlaczego podjął daną decyzję.

## 7.9 Spec Builder / PRD

Z wybranego pomysłu można stworzyć prostą specyfikację.

Specyfikacja może zawierać:

* problem,
* cel,
* dla kogo to budujemy,
* user stories,
* acceptance criteria,
* scope v1,
* out of scope,
* edge cases,
* metrykę sukcesu,
* ryzyka,
* zależności,
* pytania otwarte.

Spec Builder pomaga przejść od luźnego pomysłu do konkretnego zadania dla developmentu.

## 7.10 AI Spec Writer

AI może generować pierwszą wersję specyfikacji na podstawie:

* opisu pomysłu,
* notatek,
* celu produktowego,
* komentarzy zespołu,
* scoringu,
* założeń technicznych.

Przykład:

Admin klika:

**Generate spec**

AI tworzy:

**Problem**
Użytkownicy potrzebują sposobu na eksport faktur do PDF.

**User story**
Jako użytkownik chcę pobrać fakturę jako PDF, aby przesłać ją do księgowości.

**Acceptance criteria**

* użytkownik może pobrać pojedynczą fakturę,
* plik PDF zawiera dane firmy, numer faktury, pozycje i kwoty,
* eksport działa dla faktur opłaconych i nieopłaconych,
* akcja jest dostępna z widoku szczegółów faktury.

**Out of scope**

* eksport zbiorczy,
* personalizacja szablonu faktury,
* wysyłka PDF mailem.

## 7.11 Sprint Planning

Product Planner powinien mieć lekkie sprinty.

Nie chodzi o kopiowanie Jiry. Sprinty powinny być proste i szybkie.

Sprint może mieć:

* nazwę,
* datę startu,
* datę końca,
* cel sprintu,
* listę zadań,
* ownerów,
* statusy,
* capacity,
* story points albo prosty effort,
* podsumowanie po zakończeniu.

Podstawowy flow:

1. Zespół wybiera elementy z roadmapy lub backlogu.
2. Dodaje je do sprintu.
3. Ustala cel sprintu.
4. Przesuwa zadania po boardzie.
5. Po zakończeniu robi podsumowanie.

## 7.12 Sprint Board

Sprint Board powinien być prosty.

Statusy:

* To Do,
* In Progress,
* Review,
* Done.

Opcjonalnie:

* Blocked,
* QA,
* Ready to Release.

Funkcje:

* drag & drop,
* przypisywanie ownera,
* zmiana statusu,
* komentarze,
* checklisty,
* subtaski,
* priorytety,
* deadline,
* załączniki.

Najważniejsze: board ma być szybki i lekki, a nie przeładowany jak enterprise task manager.

## 7.13 AI Sprint Planner

AI może pomóc zaplanować sprint.

Na podstawie backlogu, priorytetów, effortu i celu produktu AI może zaproponować:

* które zadania wziąć do sprintu,
* które odłożyć,
* gdzie może być za dużo pracy,
* czy sprint jest realistyczny,
* co pasuje do celu sprintu.

Przykład:

**„Ten sprint zawiera za dużo zadań o wysokim effort. Rozważ przeniesienie eksportu zbiorczego do kolejnego sprintu i zostawienie tylko eksportu pojedynczej faktury jako v1.”**

## 7.14 Sprint Review

Po zakończeniu sprintu aplikacja powinna pomóc zrobić krótkie podsumowanie.

Sprint Review może zawierać:

* co zostało zrobione,
* co nie zostało zrobione,
* co zostało przesunięte,
* jakie były blokery,
* jakie decyzje podjęto,
* jakie zadania przechodzą dalej,
* jakie wnioski warto zapamiętać.

## 7.15 AI Sprint Summary

AI może automatycznie wygenerować podsumowanie sprintu.

Na podstawie zadań i komentarzy AI tworzy:

* krótkie podsumowanie,
* listę ukończonych rzeczy,
* listę przesuniętych rzeczy,
* potencjalne ryzyka,
* rekomendacje na kolejny sprint.

To może być bardzo przydatne dla małych zespołów, które nie chcą pisać raportów ręcznie.

## 7.16 Activity Timeline

Każdy ważny element powinien mieć historię aktywności:

* zmiana statusu,
* zmiana priorytetu,
* dodanie komentarza,
* przypisanie ownera,
* dodanie do roadmapy,
* dodanie do sprintu,
* zakończenie zadania,
* zmiana scoringu.

Dzięki temu zespół widzi, jak pomysł przechodził przez proces.

## 7.17 Dashboard

Dashboard powinien pokazywać najważniejsze informacje:

* aktywne sprinty,
* zadania w toku,
* zadania zablokowane,
* najważniejsze pomysły,
* top priorytety,
* roadmapę Now / Next,
* postęp sprintu,
* zakończone funkcje,
* rzeczy wymagające decyzji.

Dashboard nie powinien być przeładowany. Ma odpowiadać na pytanie:

**Na czym powinniśmy się teraz skupić?**

## 8. Funkcje AI w produkcie

AI powinno pomagać tam, gdzie oszczędza czas i porządkuje chaos.

Najważniejsze funkcje AI:

1. **AI Inbox Cleaner**
   Porządkowanie chaotycznych pomysłów i notatek.

2. **AI Duplicate Detection**
   Wykrywanie podobnych pomysłów i duplikatów.

3. **AI Prioritization Assistant**
   Pomoc w wyborze najważniejszych rzeczy.

4. **AI Spec Writer**
   Generowanie specyfikacji i acceptance criteria.

5. **AI Sprint Planner**
   Propozycja realistycznego sprintu na podstawie priorytetów i effortu.

6. **AI Sprint Summary**
   Automatyczne podsumowanie zakończonego sprintu.

7. **AI Decision Summary**
   Streszczanie, dlaczego zespół podjął daną decyzję.

8. **AI Risk Detection**
   Wykrywanie potencjalnych ryzyk, np. zbyt dużego zakresu, braku ownera, braku acceptance criteria.

## 9. MVP

Pierwsza wersja produktu powinna być mała, ale kompletna.

MVP powinno zawierać:

1. Rejestrację organizacji.
2. Workspace.
3. Projekty.
4. Product Inbox.
5. Dodawanie pomysłów.
6. Backlog.
7. Prosty scoring: Impact / Effort / Confidence.
8. Roadmapę Now / Next / Later / Done.
9. Sprinty.
10. Sprint Board: To Do / In Progress / Review / Done.
11. Drag & drop zadań.
12. Prosty Spec Builder.
13. Komentarze.
14. Ownerzy zadań.
15. Activity Timeline.
16. Dashboard.
17. AI Inbox Cleaner.
18. AI Spec Writer.
19. AI Sprint Summary.

To MVP powinno już dawać realną wartość, bo pozwala przejść od pomysłu do sprintu.

## 10. Funkcje po MVP

Po MVP można dodać:

* AI Sprint Planner,
* AI Prioritization Assistant,
* Evidence Score,
* Decision Notes,
* Product Goals,
* zaawansowane role i uprawnienia,
* private projects,
* custom workflows,
* integracje z GitHubem,
* integracje z GitLabem,
* integracje ze Slackiem,
* integracje z Discordem,
* integracje z kalendarzem,
* eksport danych,
* publiczne API,
* webhooki,
* timeline roadmapy,
* dependency tracking,
* release planning,
* capacity planning,
* time estimates,
* automatyczne raporty tygodniowe.

## 11. Czego nie robić na początku

Na start nie warto budować:

* pełnego klona ClickUpa,
* rozbudowanego Gantta,
* time trackingu,
* enterprise permissions,
* SSO,
* automatyzacji workflow typu Zapier,
* dziesiątek widoków,
* dokumentów jak Notion,
* whiteboardów,
* czatu zespołowego,
* bardzo złożonych zależności między zadaniami.

Produkt powinien być prosty i mocno skupiony na planowaniu produktu.

## 12. Przykładowy flow

1. Founder dodaje pomysł do Product Inboxa.
2. AI porządkuje opis i sugeruje kategorię.
3. Pomysł trafia do Backlogu.
4. Zespół ocenia Impact, Effort i Confidence.
5. Pomysł trafia do Roadmapy jako Next.
6. Zespół generuje specyfikację przez AI Spec Writer.
7. Pomysł zostaje rozbity na zadania.
8. Zadania trafiają do sprintu.
9. Zespół przesuwa zadania na Sprint Boardzie.
10. Po zakończeniu sprintu AI tworzy podsumowanie.
11. Zespół podejmuje decyzje na kolejny sprint.

## 13. Pricing

Proponowany pricing:

### Free

Dla solo founderów.

* 1 workspace,
* 1 projekt,
* limit pomysłów,
* prosty backlog,
* prosta roadmapa,
* branding produktu.

### Starter — $9–19/mies.

Dla indie founderów i małych projektów.

* więcej projektów,
* backlog,
* roadmapa,
* sprinty,
* sprint board,
* podstawowe AI,
* podstawowy dashboard.

### Pro — $29–59/mies.

Dla małych zespołów SaaS.

* więcej użytkowników,
* AI Spec Writer,
* AI Sprint Summary,
* Product Goals,
* Decision Notes,
* zaawansowany dashboard,
* eksport danych,
* integracje podstawowe.

### Team — $79–149/mies.

Dla zespołów produktowych.

* role i uprawnienia,
* AI Prioritization Assistant,
* AI Sprint Planner,
* zaawansowane sprinty,
* webhooki,
* integracje,
* private projects,
* custom workflows.

## 14. Rekomendowany stack

Rekomendowany stack:

* Frontend: React + TypeScript,
* Backend: Spring Boot,
* Baza danych: PostgreSQL,
* Cache: Redis,
* Queue / background jobs: Redis albo RabbitMQ,
* Pliki: S3-compatible storage,
* AI: osobny moduł w backendzie lub oddzielny serwis,
* API: REST,
* Realtime później: WebSocket,
* Auth: JWT albo session-based auth,
* Frontend charts: Recharts albo ECharts.

Najbardziej sensowny stack:

**React + Spring Boot + PostgreSQL + Redis**

Ten stack pasuje do produktu, który ma być stabilny, szybki i bardziej złożony od prostego feedback boarda.

## 15. Najważniejsze wyróżniki produktu

Product Planner powinien wyróżniać się tym, że nie jest zwykłym task managerem.

Najważniejsze wyróżniki:

1. Start od pomysłu i problemu, nie od zadania.
2. Priorytetyzacja przed wykonaniem.
3. Roadmapa połączona ze sprintami.
4. Decision Notes, czyli pamięć decyzji produktowych.
5. AI do porządkowania pomysłów.
6. AI do generowania specyfikacji.
7. AI do planowania i podsumowania sprintów.
8. Lekkość względem Jiry i ClickUpa.
9. Prosty workflow od pomysłu do realizacji.
10. Skupienie na małych zespołach SaaS.

## 16. Najważniejsze zdanie produktowe

**Product Planner to lekkie narzędzie do planowania rozwoju produktu, które pomaga małym zespołom zdecydować, co budować dalej, zamienić pomysły w roadmapę i realizować je w skupionych sprintach.**
