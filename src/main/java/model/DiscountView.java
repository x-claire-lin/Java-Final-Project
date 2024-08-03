/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dunxing Yu
 */
public class DiscountView {
    private int userID;
    private int productID;
    private String productName;
    private double discountAmount;
    private double discountPrice;
    private String dicountCompany;
    
    public DiscountView() {
    }

    public DiscountView(int userID, int productID, String productName, double discountAmount, double discountPrice, String dicountCompany) {
        this.userID = userID;
        this.productID = productID;
        this.productName = productName;
        this.discountAmount = discountAmount;
        this.discountPrice = discountPrice;
        this.dicountCompany = dicountCompany;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDicountCompany() {
        return dicountCompany;
    }

    public void setDicountCompany(String dicountCompany) {
        this.dicountCompany = dicountCompany;
    }

    @Override
    public String toString() {
        return "DiscountView{" + "userID=" + userID + ", productID=" + productID + ", productName=" + productName + ", discountAmount=" + discountAmount + ", discountPrice=" + discountPrice + ", dicountCompany=" + dicountCompany + '}';
    }

    
   
}