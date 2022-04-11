<table border="0px">
        <td><img width="270" height="250" src="https://github.com/Maye456/LionQ/blob/main/src/main/resources/static/img/lionqlogo.png"/></td>
        <td align="center"><h1>---- LionQ ----</h1></td>
    </tr>
</table>

#### Introduction
- What problem was I solving & why was I solving this problem?
   - I was trying to figure out how websites are able to implement a chat feature into their application. I found that using WebSocket was a great way to implement the chat feature and Spring Boot includes the WebSocket library
   - I also wanted to create a social-media web application that is more friendly and in the future I want to redesign the application to gear more towards education and healthcare. To allow people to help one another in their field, and give advice and feedback to others. 
- What are the high-level functional and non-functional requirements that I supported in the project?
   - The chat feature was a high-level functional requirement and I was able to utitlize the websocket library to implement it into my project
   - To monitor the 
- What technologies did I choose and why? What industry best practices were supported in my design and implementation? Is my application deployed in the Cloud? How were DeevOps principles applied?
- Did I learn any new technologies for this project? If so, what were they and why did I choose to learn these new technologies?
- What technical approach did I take? Include design diagrams, class diagrams, etc.
- What risks and challenges did I have? How did I overcome them and what resources did I use? What risk management approaches did I take?
- What outstanding issues do I have?
       
## Features
- User-Friendly UI Design (easy to navigate)
- Login & Register an account
- Basic Security for each page
- Allow users to create/edit/delete/search/list posts
- Admin page to list/delete users w/ pagination
   - Organize table by firstname, lastname, username A-Z
- Chat Client to connect w/ other users
   - Re-enter username to enter chat client
- Account page
   - Edit profile, See the posts you've created, and edit/delete those posts

## Software
- Spring Boot
- Thymeleaf
- WebSocket Library
- MySQL v5.7.24
- Java v11
- Bootstrap

## Technical Approach
<table>
    <tr>
        <td align="center"><b>Logical Diagram</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/LogicalDiagram.png"/></td>
        <td align="center"><b>Physical Architecture</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/PhysicalDiagram.png"/></td>
    </tr>
</table>

## WebApp Screenshots
View the [JavaDoc](https://htmlpreview.github.io/?https://github.com/Maye456/LionQ/blob/main/doc/index.html).
<table>
    <tr>
        <td align="center"><b>Login</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/login.png"/></td>
        <td align="center"><b>Register</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/register.png"/></td>
    </tr>
    <tr>
        <td align="center"><b>Posts</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/posts.png"/></td>
        <td align="center"><b>Admin</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/admin.png"/></td>
    </tr>
    <tr>
        <td align="center"><b>Account Page</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/accountpage.png"/></td>
        <td align="center"><b>Chat Client</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/chat.png"/></td>
    </tr>
</table>

## Code Snippets
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
             
[Back to Top](#introduction)
