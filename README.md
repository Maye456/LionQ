<table border="0px">
        <td><img width="270" height="250" src="https://github.com/Maye456/LionQ/blob/main/src/main/resources/static/img/lionqlogo.png"/></td>
        <td align="center"><h1>---- LionQ ----</h1></td>
    </tr>
</table>

#### Introduction

       
## Features


## Portal Screenshots
View the [JavaDoc](https://htmlpreview.github.io/?https://github.com/Maye456/LionQ/blob/main/doc/index.html).
<table>
    <tr>
        <td align="center"><b>Login</b><br/><img src=""/></td>
        <td align="center"><b>Register</b><br/><img src=""/></td>
    </tr>
    <tr>
        <td align="center"><b>Posts</b><br/><img src=""/></td>
        <td align="center"><b>Admin</b><br/><img src=""/></td>
    </tr>
    <tr>
        <td align="center"><b>Account Page</b><br/><img src=""/></td>
        <td align="center"><b>Chat Client</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/chat.png"/></td>
    </tr>
</table>

## Software

## System Design
<table>
    <tr>
        <td align="center"><b>Logical Diagram</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/LogicalDiagram.png"/></td>
        <td align="center"><b>Physical Architecture</b><br/><img src="https://github.com/Maye456/LionQ/blob/main/documents/Images/PhysicalDiagram.png"/></td>
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
