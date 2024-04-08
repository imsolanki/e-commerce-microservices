

# Mini-Amazon: Event-Driven Microservices Architecture

Welcome to Mini-Amazon, a miniature replica of Amazon built using event-driven architecture and synchronous communication patterns. This project demonstrates the implementation of industry-standard Spring Cloud methodologies in a microservices environment.

## Features

- **Event-Driven Communication**: Utilizes Kafka for asynchronous event handling, enabling seamless interactions between microservices.
  
- **Synchronous Communication**: Employs RESTful APIs and Feign clients for synchronous communication, ensuring immediate responses in critical workflows.

- **Microservices Design**: Designed as a collection of microservices for distinct business functionalities such as order management, inventory tracking, user authentication, and product catalog management.

- **Spring Cloud Components**: Utilizes Spring Cloud components like Eureka, Ribbon, and Hystrix for service discovery, load balancing, fault tolerance, and circuit breaking.

- **Security**: Implements JWT-based authentication and authorization mechanisms to secure API endpoints and ensure data privacy.

- **Database Integration**: Integrates with MySQL or MongoDB for persistent data storage, ensuring data consistency across services.

- **Containerization and Deployment**: Utilizes Docker for containerization and Kubernetes for orchestration, simplifying deployment and management in a distributed environment.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/imsolanki/e-commerce-micorservices.git
   cd e-commerce-micorservices
   ```

2. Set up Docker and Kubernetes for containerization and orchestration.

3. Configure environment variables and secrets for database credentials, Kafka settings, and JWT secrets.

4. Build and deploy microservices using Maven and Kubernetes commands.

5. Access the services through API endpoints and test the functionalities.

## Directory Structure

- `order-service`: Manages order-related functionalities.
- `inventory-service`: Handles inventory tracking and management.
- `auth-service`: Provides user authentication and authorization.
- `product-service`: Manages product catalog and details.
- `email-service`: Sends email notifications to customers.
- `gateway-service`: Acts as an API gateway for external client communication.
- `service-registry`: Acts as an registry for API gateway purpose using sping provided Eureka Server.

## Technologies Used

- Spring Boot
- Spring Cloud
- Kafka
- Docker
- Kubernetes
- MySQL or MongoDB
- JWT Authentication

## Contributing

We welcome contributions to Mini-Amazon! Fork the repository, make your changes, and submit a pull request. Please follow the coding standards and guidelines specified in the CONTRIBUTING.md file.

## License

This project is licensed under the copyright of mine.
