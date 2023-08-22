# Spring-Boot-HATEOAS
It is a sample spring boot application to demonstrate the concept and implementation of HATEOAS

### Prerequisites for running the application:

---
Please make sure to have an active instance of MySQL DB running on your system before starting the application.

In case, if you don't have MySQL installed on your system then you could also simply run a container from the mysql image (taken from DockerHub) using the following command:

```docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql```

Once the container is in running state (which you could verify either using docker desktop app or using the command ```docker ps```), you can make use of MySQL Workbench to validate the connection with your running container on port **3306**.

The password specified for mysql DB **root** acoount is **password** :)

---
Once we are done with validating the connection, we need to create the target database as pracDB (the name of the database which I am using in my application).

We can do it either by using MySQL Workbench or by executing the following command in console

```docker exec -it mysqldb mysql -u root -p```

This command prompts for the root password which we specified at the time of running the container. After entering the correct credentials, we get the access to the mysql client where we can execute the SQL query as ```create database pracDB```

We could also create the database with some other name but make sure to change the **spring.datasource.url** property accordingly in application.yaml file.

---
In this method, we have explicitly defined a datasource and a corresponding JdbcTemplate object to perform the setup by referring to the properties defined in the application.yaml file.

The configuration are done within the file J**DBCConfig.java**

---

Before running the application, please locate the **USER.sql** file present in the root directory and execute the command either on your mysql client ar directly onto the MySQL workbench (the steps for accessing which are already present above)

### Prequisites for running the application:

---
Please make sure to have an active instance of MySQL DB running on your system before starting the application.

In case, if you don't have MySQL installed on your system then you could also simply run a container from the mysql image (taken from DockerHub) using the following command:

```docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql```

Once the container is in running state (which you could verify either using docker desktop app or using the command ```docker ps```), you can make use of MySQL Workbench to validate the connection with your running container on port **3306**.

The password specified for mysql DB **root** acoount is **password** :)

---
Once we are done with validating the connection, we need to create the target database as pracDB (the name of the database which I am using in my application).

We can do it either by using MySQL Workbench or by executing the following command in console

```docker exec -it mysqldb mysql -u root -p```

This command prompts for the root password which we specified at the time of running the container. After entering the correct credentials, we get the access to the mysql client where we can execute the SQL query as ```create database pracDB```

We could also create the database with some other name but make sure to change the **spring.datasource.url** property accordingly in application.yaml file.

---
In this method, we have explicitly defined a datasource and a corresponding JdbcTemplate object to perform the setup by referring to the properties defined in the application.yaml file.

The configuration are done within the file J**DBCConfig.java**

---

Before running the application, please locate the **USER.sql** file present in the root directory and execute the command either on your mysql client ar directly onto the MySQL workbench (the steps for accessing which are already present above)


---
### HATEOAS Overview

**HATEOAS**, which stands for **Hypermedia as the Engine of Application State**, is a constraint of the REST architectural style. It aims to **provide information about the available actions (links) that a client can take on a resource representation**. 

In other words, _**it allows a server to include hyperlinks in the response of an API, enabling clients to navigate through the API by following those links without prior knowledge of the API's structure**_.

There are two important classes provided by Spring HATEOAS that are commonly used:
1. ```RepresentationModel```: It is a class provided by Spring HATEOAS that serves as a **base class for models that represent resources**. It contains methods to add links and related resources to the representation. It's used to add HATEOAS capabilities to a resource representation.


2. ```EntityModel```: It is a subclass of RepresentationModel provided by Spring HATEOAS. It's specifically used to wrap domain objects and provide a representation that includes links. It's often used to represent a single resource instance along with its associated links.


Using both of these classes, we simply need to extend them in the resource class. For example,
```
public class User extends RepresentationModel<User> {
    // body
}
```

Further, we can create a link and add it directly to the resource class
```
User user = userService.getUserById(userRequest.getId());
Link selfLink = linkTo(methodOn(UserController.class).getUserById(userRequest)).withSelfRel();
user.add(selfLink);
```
