package dataAccessLayer;

import model.User;

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
public class UserDaoImpl {

    public UserDaoImpl() {
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Users ORDER BY userID");
            resultSet = preparedStatement.executeQuery();
            users = new ArrayList<User>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserEmail(resultSet.getString("userEmail"));
                user.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setUserCity(resultSet.getString("userCity"));
                user.setUserType(resultSet.getString("userType"));
                users.add(user);
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
        return users;
    }

    public List<User> getAllUsersByUT(String userType) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Users where userType=? ORDER BY userID");
            preparedStatement.setString(1, userType);
            resultSet = preparedStatement.executeQuery();
            users = new ArrayList<User>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserEmail(resultSet.getString("userEmail"));
                user.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setUserCity(resultSet.getString("userCity"));
                user.setUserType(resultSet.getString("userType"));
                users.add(user);
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
        return users;
    }

    public int getUserID(String userEmail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int userIDGet = 0;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Users where userEmail = ?");
            preparedStatement.setString(1, userEmail);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userIDGet = resultSet.getInt("userID");
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
        return userIDGet;
    }

    public User getUserByEmail(String userEmail) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Users where userEmail = ?");
            preparedStatement.setString(1, userEmail);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserEmail(resultSet.getString("userEmail"));
                user.setUserPhoneNumber(resultSet.getString("userPhoneNumber"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setUserCity(resultSet.getString("userCity"));
                user.setUserType(resultSet.getString("userType"));
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
        return user;
    }

    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            // do not insert userID, it is generated by Database
            preparedStatement = connection.prepareStatement("INSERT INTO Users (userName, userEmail, userPhoneNumber, userPassword, userCity, userType) "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserEmail());
            preparedStatement.setString(3, user.getUserPhoneNumber());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setString(5, user.getUserCity());
            preparedStatement.setString(6, user.getUserType());
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

    public void updateUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("UPDATE Users SET userName = ?, userPhoneNumber = ?, "
                    + "userPassword = ?, userCity = ?, userType = ? WHERE userEmail = ?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPhoneNumber());
            preparedStatement.setString(3, user.getUserPassword());
            preparedStatement.setString(4, user.getUserCity());
            preparedStatement.setString(5, user.getUserType());
            preparedStatement.setString(6, user.getUserEmail());
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

    public void updateUserPass(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("UPDATE Users SET userPassword = ? WHERE userEmail = ?");
            preparedStatement.setString(1, user.getUserPassword());
            preparedStatement.setString(2, user.getUserEmail());
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
    public void deleteUser(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE userEmail = ?");
            preparedStatement.setString(1, email);
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

    public void deleteUserByID(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.createConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE userID = ?;");
            preparedStatement.setInt(1, id);
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
