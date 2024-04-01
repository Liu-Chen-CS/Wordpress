### About
This project is a backend service based on the `Spring Boot` framework, aiming to provide management 
and operations for `articles` and related content. Here are the main features and characteristics of the project:

1. **Article Management**: I provide a `RESTful API` for easy management of articles such as creation, retrieving, and deletion of articles through `HTTP requests` using `SpringMVC`.

2. **Multimedia Content Support**: In addition to basic article information, this project supports the management of multimedia content, including `images` and `videos`. We can associate images and videos with articles and perform corresponding operations.

3. **Exception Handling Mechanism**: The project has a `built-in exception handling` mechanism to ensure timely capture and handling of exceptions that occur during operations, ensuring system stability and reliability.

4. More features such as user management (`Login Authentication` and `Authorization`) will be introduced in future updates.

### Project Structure
<img src="https://github.com/Liu-Chen-CS/Wordpress/assets/158779475/83cea00c-ecd1-42b8-83d7-3d8803b3ebdf" width="250" height="500">

   Its a standard `Spring Boot` application with a `controller`, `service`, `repository`, and `mapper`. 

### Features Deepdive
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
