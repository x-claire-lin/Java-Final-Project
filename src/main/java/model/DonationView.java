/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ydx22
 */
public class DonationView {
    private int userID;
    private int productID;
    private String productName;
    private double donationAmount;
    private String DonationCompany;

    public DonationView() {
    }

    public DonationView(int userID, int productID, String productName, double donationAmount, String DonationCompany) {
        this.userID = userID;
        this.productID = productID;
        this.productName = productName;
        this.donationAmount = donationAmount;
        this.DonationCompany = DonationCompany;
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

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getDonationCompany() {
        return DonationCompany;
    }

    public void setDonationCompany(String DonationCompany) {
        this.DonationCompany = DonationCompany;
    }

    @Override
    public String toString() {
        return "DonationView{" + "userID=" + userID + ", productID=" + productID + ", productName=" + productName + ", donationAmount=" + donationAmount + ", DonationCompany=" + DonationCompany + '}';
    }
    
}