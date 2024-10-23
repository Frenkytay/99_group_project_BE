# User API Documentation

## Overview
The User API allows for the management of user accounts within the application. This documentation covers the endpoints available for user-related operations.

### 1. Create User

- **POST** `/user`
- **Description**: Create a new user account.
- **Request Body**:
- POST /users

  ```json
  {
      "name": "string",
  }
- **Example Response**
    ```json
    {
      "result": true,
      "user": {
        "id": 1,
        "name": "Suresh Subramaniam",
        "createdAt": 1475820997000000,
        "updatedAt": 1475820997000000,
      }
    }
    ```  
### 2. Get All User
- **GET** `/user`
- **Description**: Get all the exist user.
- **Request Body**:
    ```json
    { 
      "pageNum" : int #default = 1, 
      "pageSize" : int #default = 10
    }
    ```
- **Example Response**
    ```json
    {
        "result": true,
        "users": [
            {
                "id": 1,
                "name": "Suresh Subramaniam",
                "createdAt": 1475820997000000,
                "updatedAt": 1475820997000000,
            }
        ]
    }
    ```

### 2. Get User by Id
- **GET** `/user/id`
- **Description**: Get all the exist user.
- **Request Body**:
- **URL:** **GET** `/user/2`

    ```json
    {
      "result": true,
      "user": {
        "id": 2,
        "name": "Suresh Subramaniam",
        "createdAt": 1475820997000000,
        "updatedAt": 1475820997000000,
      }
    }
    ```
