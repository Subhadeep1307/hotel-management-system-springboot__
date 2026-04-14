Hotel Management System (Spring Boot)

Project Overview

This project is a backend-based **Hotel Management System** built using **Spring Boot**.
The idea behind this project was to simulate how real hotel booking systems work, where users can register, browse hotels and rooms, and make bookings.

I focused on keeping the design clean and simple while still following proper backend practices like layered architecture, validation, and exception handling.


Features

Core Functionalities

* Users can register and manage their details
* Hotels can be added and viewed
* Rooms are linked with hotels
* Users can book rooms for specific dates

Additional Highlights

* Used **DTOs** to keep API requests clean and simple
* Added **validation** to prevent incorrect data
* Implemented **global exception handling** for better error messages
* Added **business logic validation** (like check-out date must be after check-in)
* Integrated **Swagger UI** for easy API testing

Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Lombok
* Validation API
* Postman & Swagger

Architecture

The project follows a simple layered structure:

Controller → Service → Repository → Database

This helps in keeping the code organized and easy to maintain.

 Project Structure

com.hotel
│
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── config


 API Endpoints
 User APIs

* Register user → POST /users/register
* Get all users → GET /users
* Get user by ID → GET /users/{id}
* Update user → PUT /users/{id}
* Delete user → DELETE /users/{id}

---

### 🏨 Hotel APIs

* Add hotel → POST /hotels
* Get all hotels → GET /hotels
* Get hotel by ID → GET /hotels/{id}
* Update hotel → PUT /hotels/{id}
* Delete hotel → DELETE /hotels/{id}

Room APIs

* Add room → `POST /rooms
* Get all rooms → GET /rooms
* Get room by ID → GET /rooms/{id}
* Get rooms by hotel → GET /rooms/hotel/{hotelId}

 Booking APIs

* Create booking → POST /bookings
* Get booking by ID → GET /bookings/{id}
* Get bookings by user → GET /bookings/user/{userId}
* Delete booking → DELETE /bookings/{id}

 Sample Booking Request

json
{
  "checkIn": "2026-04-20",
  "checkOut": "2026-04-22",
  "userId": 1,
  "roomId": 1
}

 Validations Implemented

* Name and phone cannot be empty
* Email must be valid
* Check-out date must be after check-in
* Check-in date cannot be in the past (optional logic)

 How to Run

1. Clone the repository
2. Open it in IntelliJ or any IDE
3. Configure PostgreSQL in "application.properties"
4. Run the application
5. Use Postman or Swagger to test APIs

 
 👨‍💻 Author

Subhadeep Jana

⭐ If you found this project useful, feel free to star the repo!
