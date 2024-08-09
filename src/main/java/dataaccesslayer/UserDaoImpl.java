package dataaccesslayer;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cheng
 */
public class UserDaoImpl {

    public UserDaoImpl() {
    }
    
      public List<User> getAllUsers() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> users = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM Users ORDER BY userID");
            rs = pstmt.executeQuery();
            users = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserCity(rs.getString("userCity"));
                user.setUserType(rs.getString("userType"));
                users.add(user);
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
        return users;
    }
      
    public List<User> getAllUsersByUT(String userType) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> users = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM Users where userType=? ORDER BY userID");
            pstmt.setString(1, userType);
            rs = pstmt.executeQuery();
            users = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserCity(rs.getString("userCity"));
                user.setUserType(rs.getString("userType"));
                users.add(user);
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
        return users;
    }

    public int getUserID(String userEmail) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int userIDGet=0;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM Users where userEmail = ?");
            pstmt.setString(1, userEmail);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                userIDGet=rs.getInt("userID");
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
        return userIDGet;
    }
    
   public User getUserByEmail(String userEmail) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM Users where userEmail = ?");
            pstmt.setString(1, userEmail);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserCity(rs.getString("userCity"));
                user.setUserType(rs.getString("userType"));
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
        return user;
    } 
   
    public void addUser(User user) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            // do not insert userID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO Users (userName, userEmail, userPhoneNumber, userPassword, userCity, userType) "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserEmail());
            pstmt.setString(3, user.getUserPhoneNumber());
            pstmt.setString(4, user.getUserPassword());
            pstmt.setString(5, user.getUserCity());
            pstmt.setString(6, user.getUserType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }
    
    public void updateUser(User user) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("Update Users set userName = ?, userPhoneNumber = ?, "
                    + "userPassword = ?, userCity = ? userType = ? where userEmail = ?");
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPhoneNumber());
            pstmt.setString(3, user.getUserPassword());
            pstmt.setString(4, user.getUserCity());
            pstmt.setString(5, user.getUserType());
            pstmt.setString(6, user.getUserEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }
    
    public void updateUserPass(User user) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("Update Users set userPassword = ? where userEmail = ?");
            pstmt.setString(1, user.getUserPassword());
            pstmt.setString(2, user.getUserEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }
    
    public void deleteUser(String email) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("Delete from Users where userEmail = ?;" );
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }
    
    public void deleteUserByID(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("Delete from Users where userID = ?;" );             
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }
}