package dataAccessLayer;

import model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
/**
 *
 * @author Cheng Zhang
 */
public class ProductsDaoImpl {

    public ProductsDaoImpl() {
    }

    public Products getProductsById(int productId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Products> products = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * from products where productId = ?");
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();
            products = new ArrayList<>();
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
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
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
                System.out.println(ex.getMessage());
            }
        }
        return products.get(0);
    }

    public List<Products> getAllProducts(int userID) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Products> products = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * from products where userID = ? ORDER BY productID");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            products = new ArrayList<>();
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
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
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
                System.out.println(ex.getMessage());
            }
        }
        return products;
    }

    public List<Products> getAllProductsByCondition(List<String> type, String location) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Products> products = null;
        StringJoiner joiner = new StringJoiner(",");
        for (String str : type) {
            joiner.add(str);
        }
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * from products p where p.discountAmount is not null and FIND_IN_SET(productType,?)  ORDER BY productID");
            preparedStatement.setString(1, joiner.toString());
            resultSet = preparedStatement.executeQuery();
            products = new ArrayList<>();
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
                product.setUserCity(resultSet.getString("userCity"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
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
                System.out.println(ex.getMessage());
            }
        }
        return products;
    }

    public void addProduct(Products product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String query = "INSERT INTO products "
                    + "(productName, salePrice, inventoryAmount, productType,"
                    + " surplusFlage, userID, expiryDate,"
                    + "discountAmount, discountPrice, donationAmount, userCity) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getSalePrice());
            preparedStatement.setDouble(3, product.getInventoryAmount());
            preparedStatement.setString(4, product.getProductType());
            preparedStatement.setString(5, product.getSurplusFlag());
            preparedStatement.setInt(6, product.getUserID());
            preparedStatement.setDate(7, product.getExpiryDate());
            preparedStatement.setDouble(8, product.getDiscountAmount());
            preparedStatement.setDouble(9, product.getDiscountPrice());
            preparedStatement.setDouble(10, product.getDonationAmount());
            preparedStatement.setString(11, product.getUserCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateProduct(Products product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String query = "UPDATE products SET "
                    + "productName=?, "
                    + "salePrice=?, "
                    + "inventoryAmount=?, "
                    + "productType=?, "
                    + "surplusFlage=?, "
                    + "expiryDate=?, "
                    + "discountAmount=?, "
                    + "discountPrice=?, "
                    + "donationAmount=? "
                    + "WHERE productID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getSalePrice());
            preparedStatement.setDouble(3, product.getInventoryAmount());
            preparedStatement.setString(4, product.getProductType());
            preparedStatement.setString(5, product.getSurplusFlag());
            preparedStatement.setDate(6, product.getExpiryDate());
            preparedStatement.setDouble(7, product.getDiscountAmount());
            preparedStatement.setDouble(8, product.getDiscountPrice());
            preparedStatement.setDouble(9, product.getDonationAmount());
            preparedStatement.setInt(10, product.getProductID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void deleteProduct(Products product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String query = "DELETE FROM products WHERE productID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, product.getProductID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void updateDonation(int id, double amount) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String query = "UPDATE products SET donationAmount=? WHERE productID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateDiscount(int id, double amount) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String query = "UPDATE products SET discountAmount=? WHERE productID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateSurplusProducts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String selectSurplusQuery = "SELECT * FROM products WHERE expiryDate <= DATE_ADD(CURDATE(), INTERVAL 7 DAY) AND inventoryAmount > 200";
            preparedStatement = connection.prepareStatement(selectSurplusQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("productID");
                double newSalePrice = resultSet.getDouble("salePrice") * 0.9; // Example: applying a 10% discount
                updateSalePrice(productId, newSalePrice); // Assuming a method to update the sale price
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

    private void updateSalePrice(int productId, double newSalePrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            String updateSalePriceQuery = "UPDATE products SET salePrice = ? WHERE productID = ?";
            preparedStatement = connection.prepareStatement(updateSalePriceQuery);
            preparedStatement.setDouble(1, newSalePrice);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
    }

}
