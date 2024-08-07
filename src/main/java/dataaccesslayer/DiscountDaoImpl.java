package dataaccesslayer;

import model.DiscountView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Cheng
 */
public class DiscountDaoImpl {

    public DiscountDaoImpl() {
    }
    public ArrayList<DiscountView> getAllDiscountProducts() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<DiscountView> discounts = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * from DiscountView ORDER BY productID");
           
            rs = pstmt.executeQuery();
            discounts = new ArrayList<DiscountView>();
            while (rs.next()) {
                DiscountView product = new DiscountView();                
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setDiscountAmount(rs.getDouble("discountAmount"));
                product.setDiscountPrice(rs.getDouble("discountPrice"));
                product.setUserID(rs.getInt("uID"));
                product.setDicountCompany("DiscountCompany");
                discounts.add(product);
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
        return discounts;
    }

    
}