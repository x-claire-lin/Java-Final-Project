<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Waste Reduction Platform</title>
    <link href="../static/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login-container">
    <h1>Food Waste Reduction Platform</h1>

    <div class="login-form-wrapper">
        <div class="login-form">
            <form action="../LoginServlet" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" placeholder="Please enter email" id="email" size="40" class="input-field" />
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" placeholder="Please enter password" id="password" size="40" class="input-field" />
                </div>

                <div class="form-group">
                    <input type="submit" value="Login" class="btn btn-primary" id="loginBtn"/>
                </div>
                <div class="form-group">
                    <input type="button" value="Sign up" class="btn btn-secondary" id="registerBtn"/>
                </div>
                <div class="form-group">
                    <input type="reset" value="Reset" class="btn btn-tertiary" id="resetBtn"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    // Get the form and input elements
    const form = document.querySelector('form');
    const email = document.querySelector('#email');
    const password = document.querySelector('#password');

    // Add event listener to check if the input is empty
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent default behavior

        if (email.value === '') {
            alert('Email cannot be empty!');
        } else if (password.value === '') {
            alert('Password cannot be empty!');
        } else {
            form.submit(); // Submit the form
        }
    });

    // Add event listener to load register page
    document.querySelector('#registerBtn').addEventListener('click', function() {
        window.location.href = "register.jsp";
    });

    // Display message if there is any
    var msg = '${msg}';
    console.log(msg);
    if (msg !== '') {
        alert(msg);
    }
</script>
</body>
</html>