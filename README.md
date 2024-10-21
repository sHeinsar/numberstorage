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
POST endpoint /numbers accepts an array of integers in request body
{
  "numbers": [1, 2, 3, 4, 5]
}



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

---
