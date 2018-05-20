## Wymagania i Budowanie

#### Basil - GUI

Do wybudowania wymagany jest [NodeJS & NPM](https://nodejs.org/en/download/) oraz [Angular CLI](https://github.com/angular/angular-cli) w wersji 1.7.0.

Instrukcja budowania:

- przechodzimy do katalogu ```spices/basil```
- instalujemy zależności poleceniem ```npm install```
- budujemy projekt poleceniem angular-cli ```ng build```

Projekt jest tak skonfigurowany (plik ```angular-cli.json```), że wybudowana strona znajdzie się w katalogu ```/spices/oregano/src/main/resources/static```

#### Oregano - Backend

Projekt używa [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html), ale ze względu na to, ze na dzień dzisiejszy 21.05.2018 nie wydano jeszcze wersji [Lombok](https://projectlombok.org/), kompatybilnej z JDK10, wymagane jest JDK8.

Instrukcja budowania:

- przechodzimy do katalogu ```spices/oregano```
- budujemy jar poleceniem ```./gradlew build```
- gotowy jar znajduje się w katalogu ```/spices/oregano/build/libs/oregano-0.0.1-SNAPSHOT.jar```
- można go uruchomić poleceniem ```java -jar oregano-0.0.1-SNAPSHOT.jar ```
- korzystając z dowolnej przegladarki internetowej (najlepiej nie Edge/IE) wchodzimy na adres: ```http://localhost:8080/```

#### Docker

Wybudowany jar możemy uruchomić korzystając z Dockera

Budowanie obrazu: ```docker build -t oregano .```

Uruchomienie: ``` docker run --name oregano -p 8080:8080 oregano```

## API

Aplikacja wystawia API administracyjne typu CRUD:

- /user
- /album
- /photo

Aplikacja posiada API z możliwością filtrowania zasobów:

- /api/user
- /api/album
- /api/photo

Api posiada dodatkowy argument ```search``` czyli ```/api/album?search=``` pozwalający na stworzenie query.
Query składa się zapytań:
- '>' - większe lub równe
- '<' - mniejsze lub równe
- ':' - takie samo

Przykład:

```/api/album?search=id>8,userId:1```

Zwraca odpowiedź:

```
[
    {
        "id": 8,
        "title": "qui fuga est a eum",
        "userId": 1
    },
    {
        "id": 9,
        "title": "saepe unde necessitatibus rem",
        "userId": 1
    },
    {
        "id": 10,
        "title": "distinctio laborum qui",
        "userId": 1
    }
]
```

Przykład 2:

```/api/user?search=address.city:Gwenborough```

Odpowiedź:

```
[
    {
        "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
            "street": "Kulas Light",
            "suite": "Apt. 556",
            "city": "Gwenborough",
            "zipcode": "92998-3874",
            "geo": {
                "lat": -37.3159,
                "lng": 81.1496
            }
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
            "name": "Romaguera-Crona",
            "catchPhrase": "Multi-layered client-server neural-net",
            "bs": "harness real-time e-markets"
        }
    }
]
```
