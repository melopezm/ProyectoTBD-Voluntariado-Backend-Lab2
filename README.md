# ProyectoTBD-Voluntariado
Backend TBD 2-2020

## Spring initializr
````
https://start.spring.io/
````

## sql2o Docs
````
https://github.com/aaberg/sql2o/wiki
````

## Base de datos
``````
1) En el directorio ProyectoTBD-Voluntariado-Backend/src/main/resources se encuentra el 
archivo application.properties.
En este se debe indicar la dirección de la base de datos (por defecto viene configurado 
para localhost o 127.0.0.1).

2) Dentro del directorio ProyectoTBD-Voluntariado-Backend/src/main/resources/db se 
encuentran 2 archivos:
  - schema.sql contiene el esquema de base de datos que fue utilizado para el ejemplo que 
fue grabado en video.
  - Voluntariado_backup_V3.backup contiene el backup hecho directamente desde pgadmin.
``````

## Como iniciar
````
Dirigirse al directorio _ProyectoTBD-Voluntariado-Backend_ y ejecutar:

$ mvn spring-boot:run

Esto iniciara el backend en el puerto 8081.
````

## PgAmdin
````
Abrir un "Query Tool" en pgadmin 4 y ejecutar la siguiente instrucción:

CREATE EXTENSION postgis