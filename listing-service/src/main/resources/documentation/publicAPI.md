# User API Documentation

## Overview
The User API allows for the management of Listing within the application.

### 1. Create Listing

- **POST** `/public-api/listings`
- **Description**: Create a new listing
- **Request Body**:
- POST /listings
  ```json
  {
      "listingType" : "str",
      "userId":"int",
      "price":"int"
  }
- **Example Response**
    ```json
   {
    "result": true,
    "listing": {
        "id": 1,
        "userId": 1,
        "listingType": "rent",
        "price": 6000,
        "createdAt": 1475820997000000,
        "updatedAt": 1475820997000000,
      }
    }
    ```  
### 2. Get All Listing
- **GET** `/public-api/listings`
- **Description**: Get all the exist Listing.
- **Request Body**:
    ```json
    { 
      "pageNum" : "int #default = 1", ,
      "pageSize" : "int #default = 10",
      "userId" : "optional"
    }
    ```
- **Example Response**
    ```json
    {
    "result": true,
    "listings": [
        {
            "id": 1,
            "listingType": "rent",
            "price": 6000,
            "createdAt": 1475820997000000,
            "updatedAt": 1475820997000000,
            "user": {
                "id": 1,
                "name": "Suresh Subramaniam",
                "createdAt": 1475820997000000,
                "updatedAt": 1475820997000000,
            },
        }
      ]
    }
    ```
### 3. Create User

- **POST** `/public-api//user`
- **Description**: Create a new user account.
- **Request Body**:
- POST /users

  ```json
  {
      "name": "str",
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

