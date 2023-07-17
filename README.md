# InstaBackend
>## Framework Used 
 * SpringBoot
>## Database Used 
 * Swagger
 * mysql workbench
>## Language Used
* Java
>## For Querying use these
* Crud Repository
* Custom Finder
* Custom Query
>## Data flow
In this project, we have four layers-
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.
>## Data Structure used in my project
*we created two entity classes, User and Post, with the following attributes:

* **User:**
private String firstName;
private String lastName;
private Integer age;
private String email;
private String phoneNumber;

* **Post:**
private Integer postId;
private Timestamp createdDate;
private Timestamp updatedDate;
private String postData;
 @ManyToOne(fetch = FetchType.LAZY)
private User user;
* **Authentication token**
private Long tokenId;
private String token;
private LocalDate tokenCreationDate;
 @OneToOne
private User user ;

>## project summery

*In the Post entity class, add a @ManyToOne annotation to the User attribute, to create a Many-to-one mapping between User and Post and we create three controller classes, UserController , TokenController and PostController, with the following methods to handle CRUD operations:
* **user controller**
sign in
sign up
update user details

* **Post Controller**
savePost
getPost
>## Application_properties
spring.datasource.url=jdbc:mysql://localhost:3306/InstagramDB
spring.datasource.username=root
spring.datasource.password=<password>
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
