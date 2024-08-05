package dataAccessLayer;

import model.DiscountView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cheng Zhang
 */
public class DiscountDaoImpl {

    public DiscountDaoImpl() {
    }

    public ArrayList<DiscountView> getAllDiscountProducts() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DiscountView> discounts = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * from DiscountView ORDER BY productID");

            resultSet = preparedStatement.executeQuery();
            discounts = new ArrayList<DiscountView>();
            while (resultSet.next()) {
                DiscountView product = new DiscountView();
                product.setProductID(resultSet.getInt("productID"));
                product.setProductName(resultSet.getString("productName"));
                product.setDiscountPrice(resultSet.getDouble("discountPrice"));
                product.setDiscountAmount(resultSet.getDouble("discountAmount"));
                product.setDiscountPrice(resultSet.getDouble("discountPrice"));
                product.setUserID(resultSet.getInt("uID"));
                product.setDicountCompany("DiscountCompany");
                discounts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return discounts;
    }
}
