package dataAccessLayer;



import model.DonationView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cheng Zhang
 */
public class DonationViewDaoImpl {

    public ArrayList<DonationView> getAllDonationProducts() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DonationView> donations = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * from DonationView ORDER BY productID");

            resultSet = preparedStatement.executeQuery();
            donations = new ArrayList<DonationView>();
            while (resultSet.next()) {
                DonationView product = new DonationView();
                product.setProductID(resultSet.getInt("productID"));
                product.setProductName(resultSet.getString("productName"));
                product.setDonationAmount(resultSet.getDouble("donationAmount"));
                product.setUserID(resultSet.getInt("uID"));
                product.setDonationCompany(resultSet.getString("DonationCompany"));
                donations.add(product);
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
        return donations;
    }
}
