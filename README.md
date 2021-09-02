# Автоматизация тестирования формы "Путешествие дня - Марракеш".

# Документация

+ [План по автоматизации тестирования](https://github.com/Perepadin/MyDiplomQA/blob/master/documentation/TestPlan.md)

+ [Отчет по тестированию](https://github.com/Perepadin/MyDiplomQA/blob/master/documentation/Report.md)

+ [Отчет по автоматизации](https://github.com/Perepadin/MyDiplomQA/blob/master/documentation/Summary.md)
  
### Prerequisites
Для выполнения работы необходимо:

1. Установить [Google Chrome](https://www.google.ru/chrome/) (последней версии)
2. Установить [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/#section=windows)
3. Подключить в **IntelliJ IDEA** следующие компоненты:
   1. *Библиотека Lombok* ;
   2. *Библиотека JavaFaker*;
   3. *Фреймворк JUnit 5*;
   4. *Фреймворк Selenide*;
   5. *Фреймворк Allure*.
5. Установить [Github desktop](https://desktop.github.com)
6. Установить [Docker](https://www.docker.com)

## Подготовка и запуск теста
### Инструкция по запуску с поддержкой MySQL

1. Клонировать репозиторий выполнить команду:```git clone https://github.com/Perepadin/MyDiplomQA```
1. Запуск контейнеров Docker выполнить команду:
   ```docker-compose up```
1. **Запуск SUT с поддержкой MySQL:** выполнить команду:
```java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar```
1. Запуск тестов с MySQL выполнить команду:
```./gradlew "-Ddb.url=jdbc:mysql://localhost:3306/app" clean test```
1. Отчёт Allure выполнить команду:
```./gradlew allureReport```
```./gradlew allureServe```
1. Окончание тестов и остановка контейнеров

### Инструкция по запуску с поддержкой PostgreSQL
1. Клонировать репозиторий выполнить команду:
```git clone https://github.com/Perepadin/MyDiplomQA```
1. Запуск контейнеров Docker выполнить команду:
   ```docker-compose up -d```
1. Запуск SUT с поддержкой **Postgres** выполнить команду
```java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar```

1. Запуск тестов с Postgres выполнить команду:
```./gradlew "-Ddb.url=jdbc:postgresql://localhost:5432/app" clean test```
1. Отчёт Allure выполнить команду
```./gradlew allureReport```
```./gradlew allureServe```
1. Окончание тестов и остановка контейнеров

## Лицензия

1. Google Chrome - распространяется бесплатно;
1. IntelliJ IDEA Community Edition - бесплатный инструмент разработки;
1. Установить [Github desktop](https://desktop.github.com) - бесплатный инструмент разработки;
1. Установить [Docker](https://www.docker.com) - бесплатный инструмент разработки.




