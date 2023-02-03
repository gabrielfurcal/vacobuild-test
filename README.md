# vacobuilt-test
Technical Test for Software Developer position at VacoBuilt

## Technology Stack Used
Java 17 with Spring Boot

## Architecture
For this project I took the approach of the MVC architecture without the View
* You can see that there are models representing each entity on the database
* Controllers were used to created the REST end-points for this exercise

## Design Patterns
Implemented for this project:
* Facade, to create the services to abstract the business logic and let the controllers clean
* Builder to facilitate object creation for models and DTOs
* DTOs to map data I only want to be manipulated from the client side

## Database Design
* This project was developed using Code First apporach with Spring Data JPA, using Hibernate as the ORM core
* MySQL was the DBMS used for this exercise
* Script file can be found in the resources folder

