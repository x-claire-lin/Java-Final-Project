<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title> Food waste Reduction Platform </title>
    <link href="../css/platform_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="platform_login_wrap">
    
    <h1>Food waste Reduction Platform</h1>
   
    <div class="platform_login_border">
        <div class="platform_input">
            <form action="../LoginServlet" method="post">
                 <div>
                        <label for="email">Email</label>
                        <input type="text" name="email" placeholder="Please enter email" id="email" size="40" class="platform_input_style" />
                    </div>
                  
                    <div>
                        <label for="password">Password</label>
                        <input type="password" name="password" placeholder="Please enter password" id="password" size="40" class="platform_input_style" />
                    </div>
                
                    <div>
                        <input type="submit" style="margin-top: 15px"  value="Login" class="btn btn-primary" id="loginBtn"/>
                    </div>
                    <div>
                        <input type="button" style="margin-top: 15px"  value="Sign up" class="btn btn-primary" id="registerBtn"/>
                    </div>
                     <div>
                        <input type="reset" style="margin-top: 15px"  value="Clear" class="btn btn-primary" id="resetBtn"/>
                    </div>
            </form>
        </div>
    </div>
</div>
<script>
    // get the form and input
    const form = document.querySelector('form');
    const email = document.querySelector('#email');
    const password = document.querySelector('#password');

    // add event listener，check if the input is empty
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // prevent default behavior

        if (email.value === '') {
            alert('Email cannot be empty！');
        }else if(password.value === '') {
            alert('Password cannot be empty！');
        }else {
            form.submit(); // submit
        }
    });
    document.querySelector('#registerBtn').addEventListener('click', function() {
    window.location.href="register.jsp";});
    // add event listener，load register page
    

    var msg = 'testmessage';
    console.log(msg);
    if (msg !== '') {
        alert(msg);
    }
</script>
</body>
</html>