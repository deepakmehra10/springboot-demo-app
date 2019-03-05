
# sprintboot-demo-app
### Spring boot application with CRUD operations in Cassandra.

#### How to run the application?

    mvn spring-boot:run

Application runs on port 5000 by default and that can be changed to desired port from application.properties in resources.

 **1. Create User**
 

    Route(Method - POST) : localhost:5000/user
**Request Body**

    {
    	"id":1000,
    	"address":"Delhi",
    	"name":"Deepak",
    	"salary":6000
    }

 **2. Get All Users**
 

    Route(Method - GET) : localhost:5000/users
  

 **3. Get User**
 

    Route(Method - GET) : localhost:5000/users/{id}

 **4. Delete User**
 

    Route(Method - GET) localhost:5000/deleteUser/{id}

 **5. Update User**
 

    localhost:5000/user/{id}
**RequestBody**

    {
    	"id":1,
    	"address":"Gurgaon",
    	"name":"Deepak",
    	"salary":60000
    }
