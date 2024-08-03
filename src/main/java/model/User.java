/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Qi Cheng
 */
public class User {
    private int userID;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;
    private String userType;
    private String userCity;
    
    public User(){
        
    }
    
    public User(String userName, String userEmail, String userPhoneNumber, String userPassword, String userCity, String userType) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userCity = userCity;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
    
    public String getUserPhoneNumber(){
        return userPhoneNumber;
    }
            
    public String getUserPassword() {
        return userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhoneNumber(String userPhoneNumber){
        this.userPhoneNumber = userPhoneNumber;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
   
}