# JWTauthentication
This project is a backend implementation of a login and signup REST API with security and JWT tokens. It is built using Java, Spring Boot, Spring MVC, Spring Security and utilizes H2 database for data storage. The API endpoints provided below demonstrate the functionality of the application.

# Step 1
Clone the Repository using link https://github.com/Ayushoo07/JWTauthentication.git

## Pre-Requisites
-JDK(17) \n
-maven 
-Postman (testing of Api)

# Step 2
Run the project by fetching all the dependencies carefully
The application will start running on http://localhost:8080

# Step 3-Test Api
## Signup (Public Api -> anyone can access)
->Method: POST
->Path: http://localhost:808/Signup
->Description: Add a new user.
->Request Body: User data in the JSON format ( uname, email, password).

{
    "uname":"Ayush",
    "email":"Ayush@gmail",
    "password":"Ayush"

}
