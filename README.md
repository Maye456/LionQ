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
- I implemented a logging feature to log when a user enters and exits each method. This will allow for developers to track when and where an error happened if it were to occur.

## Cloud
- Deployed a Spring Boot Application
- Hosted on Microsoft Azure [here](https://lionqwebapp.azurewebsites.net/).
- Web Servers: Apache
- Web Stacks: Java 11, Apache Tomcat 8.5
- Database: MySQL

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

## Documentation (Project Proposal, Project Designs, etc.)
- Project Proposal [here](https://github.com/Maye456/LionQ/blob/main/documents/Project%20Proposal.docx).
- Project Requirements [here](https://github.com/Maye456/LionQ/blob/main/documents/Project%20Requirements.docx).
- Project Design [here](https://github.com/Maye456/LionQ/blob/main/documents/Project%20Design.docx).
- Functional Requirements [here](https://github.com/Maye456/LionQ/blob/main/documents/Functional%20Requirements.xlsx).
- Test Cases [here](https://github.com/Maye456/LionQ/blob/main/documents/Test%20Cases.xlsx).
- Traceability Matrix [here](https://github.com/Maye456/LionQ/blob/main/documents/Traceability%20Matrix.xlsx).

## Technical Approach
<table>
    <tr>
        <td align="center"><b>Logical Diagram</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/LogicalDiagram.png"/></td>
        <td align="center"><p>Java Spring Boot provides many libraries such as web development, thymeleaf, and more. We will manually add the websocket, sockjs, and stomp client dependencies into the application. It also provides an MVC (Model-View-Controller) framework that helps tremendously when building this application. We are able to divide the work of the application and the developed code will be easier to read for other developers that will be doing the project. There will also be a database that will be provided by MySQL to store data that is being registered or requested from the user.</p></td>
    </tr>
    <tr>
        <td align="center"><b>Physical Architecture</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/PhysicalDiagram.png"/></td>
        <td align="center"><p>The Azure Cloud Services will be able to store the data and have the application running through the Azure Spring Cloud Service. The Azure Spring Cloud service provides an easier way for the Spring Boot application to be installed. The user will be able to request data, which happens at the front-end of the application, using Thymeleaf for the design, and it then goes to the back-end of the application where the Spring MVC framework lies. From the Spring MVC framework, it will request data from the MySQL database, and it will respond to the back-end and then to the front-end, where the data will be outputted with the results or an error page. New Relic is what will monitor the front-end of the application, and the application itself will all be going into the Azure Cloud.</p></td>
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
