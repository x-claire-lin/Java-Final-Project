/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
/**
 *
 * @author Dunxing Yu
 */
public class Products {
   private Integer productID;
   private String productName;
   private double salePrice;
   private double discountPrice;
   private double inventoryAmount;
   private double discountAmount;
   private double donationAmount;
   private String productType;
   private String surplusFlage;
   private String userCity;
   private int userID;
   private Date expiryDate;
   
   public Products(){}

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public Products(String productName, double salePrice, double discountPrice,
                    double inventoryAmount, double discountAmount, double donationAmount,
                    String productType, String surplusFlage, int userID, Date expiryDate, String userCity, Integer productId) {
        this.productName = productName;
        this.salePrice = salePrice;
        this.discountPrice = discountPrice;
        this.inventoryAmount = inventoryAmount;
        this.discountAmount = discountAmount;
        this.donationAmount = donationAmount;
        this.productType = productType;
        this.surplusFlage = surplusFlage;
        this.userID = userID;
        this.expiryDate = expiryDate;
        this.userCity = userCity;
        this.productID = productId;
    }
  
    public String getProductName() {
        return productName;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public double getInventoryAmount() {
        return inventoryAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public String getProductType() {
        return productType;
    }

    public String getSurplusFlag() {
        return surplusFlage;
    }

    public int getUserID() {
        return userID;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setInventoryAmount(double inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setSurplusFlage(String surplusFlage) {
        this.surplusFlage = surplusFlage;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
   @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", discountPrice='" + discountPrice + '\'' +
                ", inventoryAmount='" + inventoryAmount + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", donationAmount='" + donationAmount + '\'' +  
                ", productType='" + productType + '\'' +
                ", surplusFlage='" + surplusFlage + '\'' +
                ", userID='" + userID + '\'' +            
                ", expiryDate=" + expiryDate +                
                '}';
        
    }
    
}