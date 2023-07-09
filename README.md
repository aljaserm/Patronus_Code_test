# Patronus Project

This is a demo project built with Spring Boot showcasing the usage of RESTful APIs for managing users and devices.

## Prerequisites

- Java 17 or later
- Maven

**Note:** Due to limitations on my personal laptop, I am unable to install Java or Maven at the moment. Therefore, I am unable to run the project on my local machine. The purpose of sharing this code is to demonstrate my coding abilities. Under better circumstances, the code would work as intended.

## Getting Started

1. Clone the repository:

   ```shell
   git clone https://github.com/aljaserm/Patronus_Code_test
   ```

2. Navigate to the project directory:

   ```shell
   cd demo
   ```

3. Build the project:

   ```shell
   mvn clean install
   ```

4. Run the application:

   ```shell
   mvn spring-boot:run
   ```

5. The application will start running on `http://localhost:8080`.

## API Endpoints

### User Endpoints

- `POST /users`: Create a new user by providing the user details in the request body.

- `GET /users`: Retrieve a list of all users.

### Device Endpoints

- `POST /devices`: Create a new device by providing the device details in the request body.

- `PUT /devices/{deviceId}/assign/{userId}`: Assign a device to a user by providing the device ID and user ID in the URL path.

- `GET /devices`: Retrieve a list of all devices.

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database
- Kotlin
- JUnit 5
- MockMvc

## Limitations

Please note that due to the limitations on my personal laptop, I am unable to run the project and provide real-time results. However, I have written the code to the best of my ability based on the requirements and specifications provided. Given the opportunity, I am confident that the code would work as intended under normal circumstances.