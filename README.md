### About
This project is a backend service based on the `Spring Boot` framework including `Spring MVC`, `Spring Data JPA`, `Spring Boot Test`, aiming to provide management 
and operations for `articles` and related content while using `MySQL` database. Here are the main features and characteristics of the project:

1. **Article Management**: I provide a `RESTful API` for easy management of articles such as creation, retrieving, and deletion of articles through `HTTP requests`.

2. **Multimedia Content Support**: In addition to basic article information, this project supports the management of multimedia content, including `images` and `videos`. We can associate images and videos with articles and perform corresponding operations.

3. **Exception Handling Mechanism**: The project has a `built-in exception handling` mechanism to ensure timely capture and handling of exceptions that occur during operations, ensuring system stability and reliability.

4. More features such as user management (`Login Authentication` and `Authorization`) will be introduced in future updates.

### I used:
- Java 21
- Maven 3.9
- Spring Boot 3.2.2

### Main Dependencies needed
- spring-boot-starter-parent
- spring-boot-starter-web
- spring-boot-starter-data-jpa

### Project Structure
<img src="https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/83cea00c-ecd1-42b8-83d7-3d8803b3ebdf" width="250" height="500">

   Its a standard `Spring Boot` application with:
   - `controllers`
   - `services`
   - `repositories`
   - `mappers`

### Exsisting Features Deepdive
#### Save - Update - Delete
| Features    | MySQL - JPA Persistence|
|----------|----------|
| `Saving` single article    | saveArticle(@RequestBody)  |
| `Updating` a single article   | saveArticle(specified Id)  |
| `Deleting` a single article  | deleteArticleById(specified Id) |
| `Deleting` a list of articles  | deleteArticleByIds(....Ids) |

#### Read
| Features    | MySQL - JPA Persistence|
|----------|----------|
| `Reading` a single article    | findArticleById(specified Id)  |
| `Reading` a list of articles   | findAll()  |

### Table Relationships
![schema drawio (1)](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/dd76cea4-152c-4fbe-b739-04882e4b2f63)

   **Article Table**:
   - Has `@OnetoMany` relationships with the `Image` table and the `Video` table, as one article can have multiple images and videos associated with it.
   - Has `@ManytoMany` relationship with `article_type`, as one article can be associated with more than one topics, and topics can be used in multiple articles.

### Frameworks Workflow
![schema drawio (2)](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/d406e465-67f7-4a81-9ecf-a9766621c291)

### HttpServletRequests Handling Process
![schema drawio (3)](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/b6d74195-3f12-44b0-bf6e-606960b8f4f5)
![schema drawio (6)](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/7a8da518-7faa-4816-b62f-e223a683d66e)

### Article Structure
![schema drawio (8)](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/c7cff747-4914-43f4-a5d6-0a7b9a24e1dd)
 - As `Article` extends `DBEntity`, Article then inherits all `attributes` and `methods` from `DBEntity`.
 - If `HashSet` was used to store `ArticleBlock` type of instances, both `hashCode()` and `equals()` need to be `overridden`.


### DTO Mapping Logics
- This diagram below shows a step-by-step approach to how to map an Article to An ArticleDto
  1. for each `Article`, I will create a `vArticleDto`.
  2. start mapping for `id`, `title`,`description`,`author`.
  3. create `ArrayList <ArticleBlockDto>` to store `sortIndex`.
  4. loop through HashSet, for each ArticleBlock type instance, I will create an ArticleBlockDto to store sortIndex.
  5. add `ArticleBlockDto` to the List
  6. when finishing iterating `HashSet`, sort `ArrayList <ArticleBlockDto>`.
     - The `subtraction` to compare two numerical value might lead to incorrect result, therefore it's better to use compareTo(), [more info on StackOverflow]( https://stackoverflow.com/questions/2728793/java-integer-compareto-why-use-comparison-vs-subtraction)
   
  8. then add `ArrayList <ArticleBlockDto>` to blocks.
  9. One `ArticleDto` has just been initialized.
 
![schema drawio (7)](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/31c0e054-78ad-49e6-a87e-e57b8399dcf7)


### Saving article

 -  `POST` http://localhost:8080/article

![Snipaste_2024-04-01_17-36-16](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/0687e7bc-6976-4323-85d7-6e0fab66d8b2)
![Snipaste_2024-04-01_17-37-28](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/385032ef-5c5f-4b39-baf7-472df63fd4bc)

### Find article by id
 - `GET` http://localhost:8080/article/{id}

![Snipaste_2024-04-01_17-41-52](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/6b3c3db7-0eee-415a-a7f6-1cb43e09c653)

### Find article by id that is not exists
 - `GET` http://localhost:8080/article/{id}

![Snipaste_2024-04-01_17-46-46](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/a114b577-fd80-4799-988e-daea59b96022)


### Find all articles
 - `GET` http://localhost:8080/article

![Snipaste_2024-04-01_17-44-01](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/9fa6a4aa-d7e0-428d-9da0-c5d9aabbb5fc)

### Delete article by id
 - `Delete` http://localhost:8080/article/resource/11

![Snipaste_2024-04-01_17-50-05](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/9906c146-b842-4f90-b6eb-fe20aafab3c1)

























