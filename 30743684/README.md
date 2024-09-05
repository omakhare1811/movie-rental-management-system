# Movie Rental Management System

## Project Overview

The **Movie Rental Management System** is a menu-based console application developed in Core Java, utilizing MySQL and JDBC. This application simulates a movie rental management system, allowing users to manage movies, customers, and rentals efficiently.

## Functionalities

### 1. Movie Management
- **Add a new movie**: Allows users to add a movie to the system.
- **View movie details**: Enables users to retrieve and display details of a specific movie.
- **Update movie information**: Facilitates updating the details of an existing movie.
- **Delete a movie**: Permits the removal of a movie from the system.

### 2. Customer Management
- **Register a new customer**: Allows users to add a new customer to the system.
- **View customer details**: Retrieves and displays details of a specific customer.
- **Update customer information**: Facilitates updating the details of an existing customer.
- **Delete a customer**: Permits the removal of a customer from the system.

### 3. Rental Management
- **Rent a movie to a customer**: Allows a movie to be rented out to a customer, updating the movie's availability status.
- **Return a rented movie**: Facilitates the return of a rented movie, updating its availability status.
- **View rental details**: Retrieves and displays details of a specific rental transaction.
- **Calculate rental charges**: Calculates the total rental charge based on the rental duration and movie price.

## Database Schema

### Movie Table
- `movie_id` (Primary Key)
- `title`
- `genre`
- `release_year`
- `rental_price`

### Customer Table
- `customer_id` (Primary Key)
- `name`
- `email`
- `phone_number`
- `address`

### Rental Table
- `rental_id` (Primary Key)
- `movie_id` (Foreign Key references Movie Table)
- `customer_id` (Foreign Key references Customer Table)
- `rental_start_date`
- `rental_end_date`
- `total_charge`

## Setup Instructions

1. **Clone the Repository**:  
