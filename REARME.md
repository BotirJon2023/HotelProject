HotelApp

This project is a Hotel Management Application created using Spring Boot, Spring Security, Hibernate, and MySQL database. The project consists of 6 entities: Customer, Event, Payment, Registration, Room, and Service. Each entity has its own repository, service interface, service implementation, and rest controller.

## Entities
- Customer
- Event
- Payment
- Registration
- Room
- Service

## Controllers
- CustomerController
- EventController
- PaymentController
- RegistrationController
- RoomController
- ServiceController

Each controller contains methods for handling GET, POST, PUT, and DELETE requests related to its entity.

## Service Interfaces
- CustomerService
- EventService
- PaymentService
- RegistrationService
- RoomService
- ServiceService

## Service Implementations
- CustomerServiceImpl
- EventServiceImpl
- PaymentServiceImpl
- RegistrationServiceImpl
- RoomServiceImpl
- ServiceServiceImpl

## Repositories
- CustomerRepository
- EventRepository
- PaymentRepository
- RegistrationRepository
- RoomRepository
- ServiceRepository

## Tests
There are tests written for all of the controllers to ensure that they are functioning correctly.

### Setup Instructions
1. Clone the repository from GitHub.
2. Import the project into your IDE.
3. Configure the application.properties file with your MySQL database details.
4. Run the application and access the endpoints using a tool like Postman.

### Endpoints
- /customers
- /events
- /payments
- /registrations
- /rooms
- /services

Feel free to explore and use this HotelApp for your own purposes. If you encounter any issues or have any suggestions for improvements, please feel free to create a GitHub issue. Thank you for using HotelApp!