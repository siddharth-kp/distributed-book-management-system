
# Book management System

This project has 3 microservices
* Book
* Order
* User

When order is placed, it checks if the books are available in the inventory and places order accordingly.

Round robin load balancing is used here. Eureka+feign is used for interservice communication.


This is created using Java + Springboot.

Db used - Postgres.
