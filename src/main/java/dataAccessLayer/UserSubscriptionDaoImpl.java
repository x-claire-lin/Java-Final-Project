package dataAccessLayer;

import model.UserSubscription;

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
public class UserSubscriptionDaoImpl {

    public UserSubscriptionDaoImpl() {
    }

    public ArrayList<UserSubscription> getAllUserSubscription() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM UserSubscription ORDER BY subscriptionID");
            resultSet = preparedStatement.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (resultSet.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(resultSet.getInt("subscriptionID"));
                userSubscription.setUserID(resultSet.getInt("userID"));
                userSubscription.setProductType(resultSet.getString("productType"));
                userSubscription.setCommunicationMethod(resultSet.getString("communicationMethod"));
                userSubscription.setUserEmail(resultSet.getString("userEmail"));
                userSubscription.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                userSubscription.setUserCity(resultSet.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public List<UserSubscription> getAllUserSubscriptionByPTCity(String productType, String userCity) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM UserSubscription WHERE productType = ? AND userCity = ? ORDER BY subscriptionID");
            preparedStatement.setString(1, productType);
            preparedStatement.setString(2, userCity);
            resultSet = preparedStatement.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (resultSet.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(resultSet.getInt("subscriptionID"));
                userSubscription.setUserID(resultSet.getInt("userID"));
                userSubscription.setProductType(resultSet.getString("productType"));
                userSubscription.setCommunicationMethod(resultSet.getString("communicationMethod"));
                userSubscription.setUserEmail(resultSet.getString("userEmail"));
                userSubscription.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                userSubscription.setUserCity(resultSet.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public List<UserSubscription> getAllUserSubscriptionByEmail(String productType, String userCity) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM UserSubscription WHERE productType = ? AND userCity = ? AND userEmail IS NOT NULL ORDER BY subscriptionID");
            preparedStatement.setString(1, productType);
            preparedStatement.setString(2, userCity);
            resultSet = preparedStatement.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (resultSet.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(resultSet.getInt("subscriptionID"));
                userSubscription.setUserID(resultSet.getInt("userID"));
                userSubscription.setProductType(resultSet.getString("productType"));
                userSubscription.setCommunicationMethod(resultSet.getString("communicationMethod"));
                userSubscription.setUserEmail(resultSet.getString("userEmail"));
                userSubscription.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                userSubscription.setUserCity(resultSet.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public List<UserSubscription> getAllUserSubscriptionByPhone(String productType, String userCity) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM UserSubscription WHERE productType = ? AND userCity = ? AND userPhoneNumber IS NOT NULL ORDER BY subscriptionID");
            preparedStatement.setString(1, productType);
            preparedStatement.setString(2, userCity);
            resultSet = preparedStatement.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (resultSet.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(resultSet.getInt("subscriptionID"));
                userSubscription.setUserID(resultSet.getInt("userID"));
                userSubscription.setProductType(resultSet.getString("productType"));
                userSubscription.setCommunicationMethod(resultSet.getString("communicationMethod"));
                userSubscription.setUserEmail(resultSet.getString("userEmail"));
                userSubscription.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                userSubscription.setUserCity(resultSet.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public ArrayList<UserSubscription> getUserSubscription(int userID) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UserSubscription> userSubscriptions = new ArrayList<UserSubscription>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM UserSubscription WHERE userID = ?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(resultSet.getInt("subscriptionID"));
                userSubscription.setUserID(resultSet.getInt("userID"));
                userSubscription.setProductType(resultSet.getString("productType"));
                userSubscription.setCommunicationMethod(resultSet.getString("communicationMethod"));
                userSubscription.setUserEmail(resultSet.getString("userEmail"));
                userSubscription.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                userSubscription.setUserCity(resultSet.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }
    public List<UserSubscription> getUserSubscriptionList(int userID, String location) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<UserSubscription> userSubscriptions = new ArrayList<UserSubscription>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "select * from usersubscription where userID = ? and userCity = ?");
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, location);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(resultSet.getInt("subscriptionID"));
                userSubscription.setUserID(resultSet.getInt("userID"));
                userSubscription.setProductType(resultSet.getString("productType"));
                userSubscription.setCommunicationMethod(resultSet.getString("communicationMethod"));
                userSubscription.setUserEmail(resultSet.getString("userEmail"));
                userSubscription.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                userSubscription.setUserCity(resultSet.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public void addUserSubscription(UserSubscription userSubscription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            // do not insert userID, it is generated by Database
            preparedStatement = connection.prepareStatement("INSERT INTO UserSubscription (userID, productType, communicationMethod, userEmail, userPhoneNumber, userCity) "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, userSubscription.getUserID());
            preparedStatement.setString(2, userSubscription.getProductType());
            preparedStatement.setString(3, userSubscription.getCommunicationMethod());
            preparedStatement.setString(4, userSubscription.getUserEmail());
            preparedStatement.setString(5, userSubscription.getUserPhoneNumber());
            preparedStatement.setString(6, userSubscription.getUserCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }

    public void updateUserSubscription(UserSubscription userSubscription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("Update UserSubscription set productType = ?, communicationMethod=?, userEmail = ?, userPhoneNumber = ?, "
                    + "userCity = ?  where userID = ?");
            preparedStatement.setString(1, userSubscription.getProductType());
            preparedStatement.setString(2, userSubscription.getCommunicationMethod());
            preparedStatement.setString(3, userSubscription.getUserEmail());
            preparedStatement.setString(4, userSubscription.getUserPhoneNumber());
            preparedStatement.setString(5, userSubscription.getUserCity());
            preparedStatement.setInt(6, userSubscription.getUserID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }

    public void deleteUserSubscription(UserSubscription userSubscription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("Delete form UserSubscription where subscriptionID = ?");
            preparedStatement.setInt(1, userSubscription.getUserID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }

    public void deleteUserSubscription(int ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM usersubscription WHERE subscriptionID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }

}
