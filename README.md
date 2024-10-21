# NumberStorage Project

## Overview
The NumberStorage project allows you to create and retrieve numbers stored in a database.

## Features
- Add numbers to the database.
- Retrieve all stored numbers.

## Getting Started

### Prerequisites
- **Java SDK**
- **Maven**
- **MOCKITO**
- **H2**

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/numberstorage.git
   cd numberstorage
   ```

2. Set up your database connection in `application.properties`.

3. Build the project:
   ```bash
   mvn clean install
   ```


### Running the Application
To start the application, run:
```bash
mvn spring-boot:run
```
or
```bash
Run the application from Application.Java
```


## Usage

### Adding Numbers
POST endpoint /numbers accepts an array of integers in request body,
![image](https://github.com/user-attachments/assets/7ec3575f-2604-4e29-b751-33b149813c05)

![image](https://github.com/user-attachments/assets/446f3dda-93aa-4b05-a98f-586a84cb52cd)



### Fetching Numbers
endpoint /numbers shows current list of numbers

## Testing
Run tests with:
```bash
mvn test
```
or
```bash
Run the tests from your IDE
```
![image](https://github.com/user-attachments/assets/acd22ef5-8fbd-45d1-8a88-52c09f795efb)

---
