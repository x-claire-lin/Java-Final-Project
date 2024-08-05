package dataAccessLayer;

import model.ProductTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cheng Zhang
 */
public class ProductTypesDaoImpl {

    public ProductTypesDaoImpl() {
    }

    public ArrayList<ProductTypes> getAllProductTypes() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<ProductTypes> types = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ProductTypes");

            resultSet = preparedStatement.executeQuery();
            types = new ArrayList<ProductTypes>();
            while (resultSet.next()) {
                ProductTypes type = new ProductTypes();

                type.setType(resultSet.getString("productType"));
                types.add(type);
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
        return types;
    }
}
