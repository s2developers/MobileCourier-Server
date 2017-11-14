# Mobile Courier
Repozytorium dla aplikacji serwerowej projektu *MobileCourier*.

### REST API
Cześć napisana w Javie z wykorzystaniem Springa. Wymagana baza danych PostgreSQL.
Do podłączenia bazy danych stwórz plik 
```java 
application.properties      // NIE DODAWAJ GO DO GITA!

spring.datasource.url=jdbc:postgresql://host:port/nazwa_bazy
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=create
```

### FRONTEND
Panel administracyjy napisany jest w Vue.js. Aby działało trzeba zainstalować Vue.js na własnej maszynie.