package dataAccessLayer;

import model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cheng Zhang
 */
public class SurplusProductIdentifier {

    public List<Products> identifySurplusProducts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Products> surplusProducts = new ArrayList<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM products WHERE expiryDate <= DATE_ADD(CURDATE(), INTERVAL 7 DAY) AND inventoryAmount > 200");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Products product = new Products();
                product.setProductID(resultSet.getInt("productID"));
                product.setProductName(resultSet.getString("productName"));
                product.setSalePrice(resultSet.getDouble("salePrice"));
                product.setDiscountPrice(resultSet.getDouble("discountPrice"));
                product.setInventoryAmount(resultSet.getDouble("inventoryAmount"));
                product.setDiscountAmount(resultSet.getDouble("discountAmount"));
                product.setDonationAmount(resultSet.getDouble("donationAmount"));
                product.setProductType(resultSet.getString("productType"));
                product.setSurplusFlage(resultSet.getString("surplusFlage"));
                product.setUserID(resultSet.getInt("userID"));
                product.setExpiryDate(resultSet.getDate("expiryDate"));
                surplusProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return surplusProducts;
    }

    public List<Products> filterIdentifySurplusProducts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Products> surplusProducts = new ArrayList<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM products WHERE expiryDate >= CURDATE() AND (discountAmount IS NOT NULL OR donationAmount IS NOT NULL)");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Products product = new Products();
                product.setProductID(resultSet.getInt("productID"));
                product.setProductName(resultSet.getString("productName"));
                product.setSalePrice(resultSet.getDouble("salePrice"));
                product.setDiscountPrice(resultSet.getDouble("discountPrice"));
                product.setInventoryAmount(resultSet.getDouble("inventoryAmount"));
                product.setDiscountAmount(resultSet.getDouble("discountAmount"));
                product.setDonationAmount(resultSet.getDouble("donationAmount"));
                product.setProductType(resultSet.getString("productType"));
                product.setSurplusFlage(resultSet.getString("surplusFlage"));
                product.setUserID(resultSet.getInt("userID"));
                product.setExpiryDate(resultSet.getDate("expiryDate"));
                surplusProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return surplusProducts;
    }

    public List<Products> filterProductsByUserId(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Products> surplusProducts = new ArrayList<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE userID = ?");
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Products product = new Products();
                product.setProductID(resultSet.getInt("productID"));
                product.setProductName(resultSet.getString("productName"));
                product.setSalePrice(resultSet.getDouble("salePrice"));
                product.setDiscountPrice(resultSet.getDouble("discountPrice"));
                product.setInventoryAmount(resultSet.getDouble("inventoryAmount"));
                product.setDiscountAmount(resultSet.getDouble("discountAmount"));
                product.setDonationAmount(resultSet.getDouble("donationAmount"));
                product.setProductType(resultSet.getString("productType"));
                product.setSurplusFlage(resultSet.getString("surplusFlage"));
                product.setUserID(resultSet.getInt("userID"));
                product.setExpiryDate(resultSet.getDate("expiryDate"));
                surplusProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return surplusProducts;
    }
}
