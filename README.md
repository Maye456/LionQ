# LionQ

## Project Overview & Features
- A social-media web application utilizing Spring Boot, Thymeleaf, & MySQL
- Implementing basic CRUD operations for posts and users (EDIT/DELETE/LIST/SEARCH/CREATE)
- Implementing a chat client with WebSocket Library
- An account page which allows users to edit their profile and see the posts they created

### WebSocket Dependency
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
```

### Solution to getting the user that's logged in
```
public UserModel getCurrentUser()
{
  return new UserModel(service.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
}
```

### Logical Solution Diagram
![LogicalDiagram](https://user-images.githubusercontent.com/54680474/162790600-a3d39e31-a021-47b4-9de0-95c67b305050.png)


### Physical Solution Diagram
![PhysicalDiagram](https://user-images.githubusercontent.com/54680474/162790648-aa9c2c10-be09-4791-a8b7-0aa76ed8273a.png)

### Chat Client Preview
![chat](https://user-images.githubusercontent.com/54680474/162792065-b6285f58-f239-4716-ba43-3aa045cc4165.png)
