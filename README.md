# Cake Studio E-Commerce Project

Welcome to Cake Studio, an E-Commerce project built using Java, Spring Boot, Spring MVC pattern, Spring Data JPA, Spring Security, Google Authentication, and an in-memory H2 database. This project simulates an online cake store with user and admin functionalities. This README provides an overview of the project, installation instructions, and usage guidelines.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- - [Prerequisites](#prerequisites)
- - [Installation](#installation)
- [Usage](#usage)
- - [Admin Page](#admin-page)
- - [User Interface](#user-interface)
- [Contributing](#contributing)
- [License](#license)

## Features

- User registration and authentication using Spring Security.
- Google Authentication for simplified user login.
- Admin-only section to manage products and categories.
- Admin dashboard with CRUD operations for managing products and categories.
- In-memory H2 database for storing cake and category information.
- User-friendly interface developed with HTML, Thymeleaf, and CSS.
- Shopping cart functionality with options to view items, add to cart, and checkout.

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### Prerequisites

- Java Development Kit (JDK) 11 or higher.
- Maven (for building and managing dependencies).
- Internet connection (for Google Authentication).
- Web browser for accessing the user interface.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/cake-studio-ecommerce.git
   cd cake-studio-ecommerce
Usage
Admin Page

1.
  java -jar target/cake-studio-ecommerce-0.0.1-SNAPSHOT.jar
2. Access the admin dashboard:

Open your web browser and navigate to http://localhost:8080/admin. Log in using admin credentials.

3. Manage products and categories:

Use the admin dashboard to perform CRUD operations on products and categories.

User Interface
  1. Access the user interface:

Open your web browser and navigate to http://localhost:8080.

2. Explore the functionality:

Browse through cake products, add items to the cart, view the cart, and proceed to checkout.

Contributing

Contributions are welcome! If you find any issues or want to enhance the project, feel free to create a pull request.

1. Fork the project.
2. Create a new branch (git checkout -b feature/your-feature).
3. Make your changes and commit them (git commit -m 'Add some feature').
4. Push the changes to your branch (git push origin feature/your-feature).
5. Open a pull request.

Happy shopping! 🍰🛒
