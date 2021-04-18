# REST-API-JPA
REST with Java(JAX-RS) using Jersey. 


## Technologies and building tools
* Java 8
* Jersey 
* JPA (Hibernate)
* MySQL
* Maven

### Database Prerequisites
You should create MySQL user and database url (or schema) appropriate to *persistence.xml* file. In order to do it run sql scripts below:
1) For creating user:
```
CREATE USER 'library-rest-crud'@'localhost' IDENTIFIED BY 'restcrud';

GRANT ALL PRIVILEGES ON * . * TO 'library-rest-crud'@'localhost';
```
2) For creating database:
```
CREATE DATABASE IF NOT EXISTS my_library;
```

