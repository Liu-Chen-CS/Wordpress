### About
This project is a backend service based on the `Spring Boot` framework including `Spring MVC`, `Spring Data JPA`, `Spring Boot Test`, aiming to provide management 
and operations for `articles` and related content. Here are the main features and characteristics of the project:

1. **Article Management**: I provide a `RESTful API` for easy management of articles such as creation, retrieving, and deletion of articles through `HTTP requests` using `SpringMVC`.

2. **Multimedia Content Support**: In addition to basic article information, this project supports the management of multimedia content, including `images` and `videos`. We can associate images and videos with articles and perform corresponding operations.

3. **Exception Handling Mechanism**: The project has a `built-in exception handling` mechanism to ensure timely capture and handling of exceptions that occur during operations, ensuring system stability and reliability.

4. More features such as user management (`Login Authentication` and `Authorization`) will be introduced in future updates.

### Project Structure
<img src="https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/83cea00c-ecd1-42b8-83d7-3d8803b3ebdf" width="250" height="500">

   Its a standard `Spring Boot` application with a `controller`, `service`, `repository`, and `mapper`. 

### Current Features Deepdive
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

### Schema Relationships
![schema drawio](https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/4f938e8a-a88f-4c0c-9e8b-6f4b65a7a611)

   **Article Table**:
   - Has `@OnetoMany` relationships with the `Image` table and the `Video` table, as one article can have multiple images and videos associated with it.
   - Has `@ManytoMany` relationship with `article_type`, as one article can be associated with more than one topics, and topics can be used in multiple articles.














