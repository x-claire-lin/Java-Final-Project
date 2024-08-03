<%-- 
    Document   : register
    Created on : Apr 5, 2024, 4:48:53?p.m.
    Author     : 46297
--%>

<%@page import="businesslayer.UserBusinessLogic"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../css/platform_login.css" rel="stylesheet" type="text/css" />
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
                        <input type="text" name="username" placeholder="Please enter username" id="username" size="40"
                               class="platform_input_style"/>
                    </div>
                    <div class="textfield">
                        <label for="email">Email</label>
                        <input type="text" name="email" placeholder="Please enter email" id="email" size="40"
                               class="platform_input_style"/>
                    </div>
                    <div class="textfield">
                        <label for="phonenumber">Phone Number</label>
                        <input type="text" name="phonenumber" placeholder="Please enter phone number" id="phonenumber" size="40"
                               class="platform_input_style"/>
                    </div>                
                    <div class="textfield">
                        <label for="password">Password</label>
                        <input type="password" name="password" placeholder="Please enter password" id="password"
                               size="40" class="platform_input_style"/>
                    </div>
                    <div class="textfield">
                        <label for="usercity">Location(City)</label>
                        <input type="text" name="usercity" placeholder="Please enter your location" id="usercity" size="40"
                               class="platform_input_style"/>
                    </div>
                    <div>
                        <label for="role">Role</label>
                        <select name="role" id="role" class="select-control info-select">
                            <option value="" selected> - </option>
                            <option value="retailer">Retailer</option>
                            <option value="charitable organization">Charitable Organizations</option>
                            <option value="consumer">Consumer</option>
                        </select>
                    </div>
                    <div>
                        <button type="submit" style="margin-top: 15px"  class="btn btn-primary" id="registerBtn">Register</button>
                    </div>
                    <div>
                        <button type="reset" style="margin-top: 15px"  class="btn btn-primary" id="resetBtn">Clear</button>
                    </div>
                 </form>
            </div>
         </div>
       </div>
       <script>
             let nameInput=document.querySelector("#username");
             let emailInput=document.querySelector("#email");
             let phoneInput=document.querySelector("#phonenumber");
             let passwordInput=document.querySelector("#password");
             let cityInput=document.querySelector("#usercity");
             let nameError=document.createElement('p');
             let emailError=document.createElement("p");
             let phoneError=document.createElement("p");
             let passwordError=document.createElement('p');
             let cityError=document.createElement('p');
             document.querySelectorAll(".textfield")[0].append(nameError);
             document.querySelectorAll(".textfield")[1].append(emailError);
             document.querySelectorAll(".textfield")[2].append(phoneError);
             document.querySelectorAll(".textfield")[3].append(passwordError);
             document.querySelectorAll(".textfield")[4].append(cityError);
             let emailErrorMsg="Email address should be non-empty with the format xyx@xyz.xyz.";
             let nameErrorMsg="User name should be non-empty, and within 30 characters long.";
             let phoneErrorMsg="Phone Number shoud be non-empty, and with the format 6139999999.";
             let passwordErrorMsg="Password should be at least 8 characters: 1 uppercase, 1 lowercase.";
             let cityErrorMsg="The location should be non-empty.";
             let defaultMSg="";
             function vaildateName(){
                let name = nameInput.value; // access the value of the username

                if(name !=="" & name.length<30){ //check if the entered username matches the required
                    error1 = defaultMSg;}
                else {
                    error1 = nameErrorMsg;}
                return error1;      
            }
             function vaildateEmail(){
               let email = emailInput.value; // access the value of the email
               let regexp=/\S+@\S+\.\S+/; //reg. expression 

               if(regexp.test(email)){ //test is predefiend method to check if the entered email matches the regexp
                 error2 = defaultMSg;}
               else {
                 error2 = emailErrorMsg;}
               return error2;      
            }
            
            function vaildatePhone(){
                let phone = phoneInput.value; // access the value of the phone number

                if(phone.match(/[0-9]/)!==null & phone.length==10){ //check if the entered phone number matches the required
                    error3 = defaultMSg;}
                else {
                    error3 = phoneErrorMsg;}
                return error3;      
            }
             function vaildatePassword(){
                let password = passwordInput.value; // access the value of the password

                if(password.match(/[A-Z]/)!==null & password.match(/[a-z]/)!==null & password.length>=8){
                     //check if the entered password matches the required
                     error4 = defaultMSg;}
                else {
                     error4 = passwordErrorMsg;}
                return error4;      
            }

            function vaildateCity(){
                let city = cityInput.value; // access the value of the username

                if(city !==""){ //check if the entered usercity matches the required
                    error5 = defaultMSg;}
                else {
                    error5 = cityErrorMsg;}
                return error5;      
            }

            function validate(){
                let valid = true;//global validation 

                let emailValidation=vaildateEmail();
                if(emailValidation !==defaultMSg){ //means not match the required
                    emailError.textContent = emailValidation;  //assign the error message to the element
                    valid = false;
                }
                
                let nameValidation=vaildateName();
                if(nameValidation !==defaultMSg){ //means not match the required
                    nameError.textContent = nameValidation; //assign the error message to the element
                    valid = false;   
                }
                
                let phoneValidation=vaildatePhone();
                if(phoneValidation !==defaultMSg){ //means not match the required
                    phoneError.textContent = phoneValidation; //assign the error message to the element
                    valid = false;   
                }
    
                let passwordValidation=vaildatePassword();
                if(passwordValidation !==defaultMSg){ //means not match the required
                    passwordError.textContent = passwordValidation; //assign the error message to the element
                    valid = false;
                }
                
                let cityValidation=vaildateCity();
                if(cityValidation !==defaultMSg){ //means not match the required
                    cityError.textContent = cityValidation; //assign the error message to the element
                    valid = false;   
                }
             return valid;
            };
            
            emailInput.addEventListener("blur",()=>{ // arrow function
                let x=vaildateEmail();
                if(x == defaultMSg){
                    emailError.textContent = defaultMSg;
                }
            });
    
             // add event listner to the login if you entered correct username, the error paragraph will be empty
            nameInput.addEventListener("blur",()=>{ // arrow function
                let x=vaildateName();
                if(x == defaultMSg){
                     nameError.textContent = defaultMSg;
                }
            }); 
                
            phoneInput.addEventListener("blur",()=>{ // arrow function
                let x=vaildatePhone();
                if(x == defaultMSg){
                     phoneError.textContent = defaultMSg;
                }
            });    

            // add event listner to the pass if you entered correct password, the error paragraph will be empty 
            passwordInput.addEventListener("blur",()=>{ // arrow function
                let x=vaildatePassword();
                if(x == defaultMSg){
                    passwordError.textContent = defaultMSg;
                }
            }); 
            
            cityInput.addEventListener("blur",()=>{ // arrow function
                let x=vaildateCity();
                if(x == defaultMSg){
                    cityError.textContent = defaultMSg;
                }
            });   
             
       </script>   
    </body>
</html>