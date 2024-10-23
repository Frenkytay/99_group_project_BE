# User API Documentation

## Overview
The User API allows for the management of Listing within the application.

### 1. Create Listing

- **POST** `/listings`
- **Description**: Create a new listing 
- **Request Body**:
- POST /listing

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
- **GET** `/listings`
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
            "userId": 1,
            "listingType": "rent",
            "price": 6000,
            "createdAt": 1475820997000000,
            "updatedAt": 1475820997000000,
        }
     ] 
    }
    ```


