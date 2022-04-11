<table>
        <td><img width="270" height="250" src="https://github.com/Maye456/LionQ/blob/main/src/main/resources/static/img/lionqlogo.png"/></td>
        <td align="center"><h1>---- LionQ ----</h1></td>
    </tr>
</table>

#### Introduction
- What problem was I solving & why was I solving this problem?
   - I was trying to figure out how websites are able to implement a chat feature into their application. I found that using WebSocket was a great way to implement the chat feature and Spring Boot includes the WebSocket library
   - I also wanted to create a social-media web application that is more friendly and in the future I want to redesign the application to gear more towards education and healthcare. To allow people to help one another in their field, and give advice and feedback to others. 

## Software
- Spring Boot
- Thymeleaf
- WebSocket Library
- MySQL v5.7.24
- Java v11
- Bootstrap

I chose Spring Boot because it made it easier to utilize the MVC Framework, because it supports it and I chose Thymeleaf because it allowed me to create common layouts for the entire application such as a header, footer and common body. I used MySQL for the database because it is what I am more familiar with. For the Chat Client I did my research and WebSocket was the best route to take, because you can implement a chat feature with it, and it is include within Sprint Boot.

## Best Practices & DevOps Integration
- I commented all the methods I used in the project as well as utilizing the MVC Framework in Spring Boot. I also created a JavaDoc for most of the methods.
- This application is deployed on Microsoft Azure [here](https://lionqwebapp.azurewebsites.net/).
- I implemented a logging feature to log when a user enters and exits each method. This will allow for developers to track when and where an error happened if it were to occur.

## Challenges
### Solution to getting the user that's logged in
```
public UserModel getCurrentUser()
{
  return new UserModel(service.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
}
```
- Creating a post and displaying the username and date
   - Had troubles w/ Java & SQL dates
   - Had to get the current user and get their id
- Listing posts via UserID
   - Had to get the current user and based off that get their posts and list it
- Getting the layout I wanted with the Account Page
- Chat Feature
   - Learning how to utilize WebSocket
### WebSocket Dependency
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
```

## Risks/Issues
- I had to do a lot of research and learn client-side JavaScript, as well as how to implement WebSocket into my application. 
- No current issues at this time. :)
       
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

## Application Monitoring
<table>
        <td><img width="100" height="100" src="https://github.com/Maye456/LionQ/blob/main/documents/Images/newrelic.png"/></td>
        <td align="center"><h1>New Relic</h1></td>
    </tr>
</table>
- To monitor the success of users being able to access the website, I am using NewRelic. With NewRelic, I could also monitor the ping of the application and the success rate of data inputs.

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
             
[Back to Top](#introduction)
