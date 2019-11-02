# Scenario Quality Checker (SQC)


## Opis projektu
Dla analityków dokumentujących wymagania funkcjonalne za pomocą scenariuszy nasza aplikacja SQC dostarczy informacji ilościowych oraz umożliwi wykrywanie problemów w wymaganiach funkcjonalnych zapisanych w postaci scenariuszy. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

## Notacja scenariuszy

* Scenariusz zawiera nagłówek określający jego tytuł i aktorów (zewnętrznych oraz system)
* Scenariusz składa się z kroków (każdy krok zawiera tekst)
* Kroki mogą zawierać pod-scenariusze (dowolny poziom zagłębień)
* Kroki mogą się zaczynać od słów kluczowych: IF, ELSE, FOR EACH

Przykład:\
__Tytuł__: Dodanie książki\
__Aktorzy__:  Bibliotekarz\
__Aktor systemowy__: System

* Bibliotekarz wybiera opcje dodania nowej pozycji książkowej
* Wyświetla się formularz.
* Bibliotekarz podaje dane książki.
* __IF__: Bibliotekarz pragnie dodać egzemplarze książki

    * Bibliotekarz wybiera opcję definiowania egzemplarzy
    * System prezentuje zdefiniowane egzemplarze
    * __FOR EACH__ egzemplarz:

        * Bibliotekarz wybiera opcję dodania egzemplarza
        * System prosi o podanie danych egzemplarza
        * Bibliotekarz podaje dane egzemplarza i zatwierdza.
        * System informuje o poprawnym dodaniu egzemplarza i prezentuje zaktualizowaną listę egzemplarzy.

* Bibliotekarz zatwierdza dodanie książki.
* System informuje o poprawnym dodaniu książki.

