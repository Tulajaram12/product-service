# Product Service

Product microservice for the E-Commerce application.

## Technology

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker
- Jenkins
- Kubernetes
- Amazon EKS

## APIs

### Create Product

POST /api/products

Request:

{
    "name": "Dell Laptop",
    "description": "Dell Inspiron laptop",
    "price": 65000,
    "quantity": 10
}

### Get All Products

GET /api/products

### Get Product

GET /api/products/{id}

### Update Product

PUT /api/products/{id}

### Delete Product

DELETE /api/products/{id}

## Run Locally

mvn spring-boot:run

Application:

http://localhost:8082

## Docker

Build:

docker build -t product-service:1.0 .

Run:

docker run -p 8082:8082 product-service:1.0
