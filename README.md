# JWTauthentication
This project is a backend implementation of a login and signup REST API with security and JWT tokens. It is built using Java, Spring Boot, Spring MVC, Spring Security and utilizes H2 database for data storage. The API endpoints provided below demonstrate the functionality of the application.

# Step 1
Clone the Repository using link https://github.com/Ayushoo07/JWTauthentication.git

## Pre-Requisites
-JDK(17) </br>
-maven </br>
-Postman (testing of Api) </br>

# Step 2
Run the project by fetching all the dependencies carefully </br>
The application will start running on http://localhost:8080 </br>

# Step 3-Test Api
## Signup (Public Api -> anyone can access) </br>
->Method: POST</br>
->Path: http://localhost:808/Signup</br>
->Description: Add a new user.</br>
->Request Body: User data in the JSON format ( uname, email, password).</br>

{
    "uname":"Ayush",
    "email":"Ayush@gmail",
    "password":"Ayush"

} </br>

## Login (public Api -> anyone can access) </br>
->Method: POST</br>
->Path: http://localhost:808/Login</br>
->Description: Generates jwt token </br>
->Request Body: User data in the JSON format ( email, password).</br>
{
    "email":"Ayush@gmail",
    "password":"Ayush"

} </br>

-->OUTPUT </br>
{
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBeXVzaEBnbWFpbCIsImlhdCI6MTY4NzY5MDE2MCwiZXhwIjoxNjg3NzA4MTYwfQ.iwOxaUJYfR7zj5brvwFQBO52QnnQ6APLnrCzbmFnAAiV4f3ykQo8PTBoVhuF7S-pyluvvNRNgRSx9EiHMnOajw",
    "username": "Ayush@gmail"
} </br>
