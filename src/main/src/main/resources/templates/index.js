

function validateForm() {
    // window.location.href = "google.com";

  
    // console.log(baseurl)
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        if(password != "@Password1234")
        {
            alert("Wrong password");
            return false;
        }

        if(username == "jeannamaye2022")
        {
            localStorage.setItem("userId", 3);
        }
        else if(username == "janedoe2022")
        {
            localStorage.setItem("userId", 1);
        }
        else
        {
            alert("Wrong password");
            return false;
        }

        window.location.href = "chat-app.html";

        return false;
}

