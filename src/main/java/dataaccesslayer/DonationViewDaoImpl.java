package dataaccesslayer;

import model.DonationView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Cheng
 */
public class DonationViewDaoImpl {
    
    public ArrayList<DonationView> getAllDonationProducts() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<DonationView> donations = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * from DonationView ORDER BY productID");
           
            rs = pstmt.executeQuery();
            donations = new ArrayList<DonationView>();
            while (rs.next()) {
                DonationView product = new DonationView();                
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setDonationAmount(rs.getDouble("donationAmount"));
                product.setUserID(rs.getInt("uID"));
                product.setDonationCompany(rs.getString("DonationCompany"));
                donations.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return donations;
    }
}