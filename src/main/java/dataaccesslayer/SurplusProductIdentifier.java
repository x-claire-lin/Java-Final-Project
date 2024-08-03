/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cuini
 */
package dataaccesslayer;
    /**
         Yanan Wu
    */

import model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurplusProductIdentifier {

    public List<Products> identifySurplusProducts() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Products> surplusProducts = new ArrayList<>();
        
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM products WHERE expiryDate <= DATE_ADD(CURDATE(), INTERVAL 7 DAY) AND inventoryAmount > 200");
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryDate"));
                surplusProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return surplusProducts;
    }

    public List<Products> filterIdentifySurplusProducts() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Products> surplusProducts = new ArrayList<>();

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM products WHERE expiryDate >= CURDATE() and ( discountAmount is not null or donationAmount is not null)");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryDate"));
                surplusProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return surplusProducts;
    }

    public List<Products> filterProductsByUserId(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Products> surplusProducts = new ArrayList<>();

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT * FROM products WHERE userId = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Products product = new Products();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setInventoryAmount(rs.getDouble("inventoryAmount"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setProductType(rs.getString("productType"));
                product.setSurplusFlage(rs.getString("surplusFlage"));
                product.setUserID(rs.getInt("userID"));
                product.setExpiryDate(rs.getDate("expiryDate"));
                surplusProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return surplusProducts;
    }
}
