<%@page import="businesslayer.UserService" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../css/register.css" rel="stylesheet" type="text/css"/>
    <title>Register Page</title>
</head>
<body>
<div class="platform_login_wrap">
    <a href="login.jsp">Back</a>
    <h1>Sign up</h1>
    <div class="platform_login_border">
        <div class="platform_input">
            <form action="../RegisterServlet" method="post" onsubmit="return validate();">
                <div class="textfield">
                    <label for="username">Name</label>
                    <input type="text" name="username" placeholder="Please enter username" id="username"
                           class="platform_input_style"/>
                </div>
                <div class="textfield">
                    <label for="email">Email</label>
                    <input type="text" name="email" placeholder="Please enter email" id="email"
                           class="platform_input_style"/>
                </div>
                <div class="textfield">
                    <label for="phonenumber">Phone Number</label>
                    <input type="text" name="phonenumber" placeholder="Please enter phone number" id="phonenumber"
                           class="platform_input_style"/>
                </div>
                <div class="textfield">
                    <label for="password">Password</label>
                    <input type="password" name="password" placeholder="Please enter password" id="password"
                           class="platform_input_style"/>
                </div>
                <div class="textfield">
                    <label for="usercity">Location (City)</label>
                    <input type="text" name="usercity" placeholder="Please enter your location" id="usercity"
                           class="platform_input_style"/>
                </div>
                <div class="textfield">
                    <label for="role">Role</label>
                    <select name="role" id="role" class="select-control">
                        <option value="" selected> -</option>
                        <option value="retailer">Retailer</option>
                        <option value="charitable organization">Charitable Organization</option>
                        <option value="consumer">Consumer</option>
                    </select>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary" id="registerBtn">Register</button>
                </div>
                <div>
                    <button type="reset" class="btn btn-tertiary" id="resetBtn">Clear</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    let nameInput = document.querySelector("#username");
    let emailInput = document.querySelector("#email");
    let phoneInput = document.querySelector("#phonenumber");
    let passwordInput = document.querySelector("#password");
    let cityInput = document.querySelector("#usercity");

    let nameError = document.createElement('p');
    let emailError = document.createElement("p");
    let phoneError = document.createElement("p");
    let passwordError = document.createElement('p');
    let cityError = document.createElement('p');

    document.querySelectorAll(".textfield")[0].append(nameError);
    document.querySelectorAll(".textfield")[1].append(emailError);
    document.querySelectorAll(".textfield")[2].append(phoneError);
    document.querySelectorAll(".textfield")[3].append(passwordError);
    document.querySelectorAll(".textfield")[4].append(cityError);

    const emailErrorMsg = "Please enter a valid email address (e.g., example@domain.com).";
    const nameErrorMsg = "Username must be non-empty and under 30 characters.";
    const phoneErrorMsg = "Please enter a valid 10-digit phone number (e.g., 6137520369).";
    const passwordErrorMsg = "Password must be at least 8 characters long, including 1 uppercase and 1 lowercase letter.";
    const cityErrorMsg = "Please enter your city.";
    const defaultMSg = "";


    function validateName() {
        let name = nameInput.value;

        return name !== "" && name.length < 30 ? defaultMSg : nameErrorMsg;
    }

    function validateEmail() {
        let email = emailInput.value;
        let regexp = /\S+@\S+\.\S+/;

        return regexp.test(email) ? defaultMSg : emailErrorMsg;
    }

    function validatePhone() {
        let phone = phoneInput.value;

        return phone.match(/[0-9]/) !== null && phone.length === 10 ? defaultMSg : phoneErrorMsg;
    }

    function validatePassword() {
        let password = passwordInput.value;

        return password.match(/[A-Z]/) !== null && password.match(/[a-z]/) !== null && password.length >= 8
            ? defaultMSg : passwordErrorMsg;
    }

    function validateCity() {
        let city = cityInput.value;

        return city !== "" ? defaultMSg : cityErrorMsg;
    }

    function validate() {
        let valid = true;

        let emailValidation = validateEmail();
        if (emailValidation !== defaultMSg) {
            emailError.textContent = emailValidation;
            valid = false;
        }

        let nameValidation = validateName();
        if (nameValidation !== defaultMSg) {
            nameError.textContent = nameValidation;
            valid = false;
        }

        let phoneValidation = validatePhone();
        if (phoneValidation !== defaultMSg) {
            phoneError.textContent = phoneValidation;
            valid = false;
        }

        let passwordValidation = validatePassword();
        if (passwordValidation !== defaultMSg) {
            passwordError.textContent = passwordValidation;
            valid = false;
        }

        let cityValidation = validateCity();
        if (cityValidation !== defaultMSg) {
            cityError.textContent = cityValidation;
            valid = false;
        }
        return valid;
    };

    emailInput.addEventListener("blur", () => {
        if (validateEmail() === defaultMSg) {
            emailError.textContent = defaultMSg;
        }
    });

    nameInput.addEventListener("blur", () => {
        if (validateName() === defaultMSg) {
            nameError.textContent = defaultMSg;
        }
    });

    phoneInput.addEventListener("blur", () => {
        if (validatePhone() === defaultMSg) {
            phoneError.textContent = defaultMSg;
        }
    });

    passwordInput.addEventListener("blur", () => {
        if (validatePassword() === defaultMSg) {
            passwordError.textContent = defaultMSg;
        }
    });

    cityInput.addEventListener("blur", () => {
        if (validateCity() === defaultMSg) {
            cityError.textContent = defaultMSg;
        }
    });
</script>
</body>
</html>