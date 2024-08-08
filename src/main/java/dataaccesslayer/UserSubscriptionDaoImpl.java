package dataaccesslayer;

import model.UserSubscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSubscriptionDaoImpl {
    
    public UserSubscriptionDaoImpl() {
    }
    
      public ArrayList<UserSubscription> getAllUserSubscription() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription ORDER BY subscriptionID");
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }
      
    public List<UserSubscription> getAllUserSubscriptionByPTCity(String productType, String userCity) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where productType = ? and userCity = ? and ORDER BY subscriptionID");
            pstmt.setString(1, productType);
            pstmt.setString(2, userCity);
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }
    
     public List<UserSubscription> getAllUserSubscriptionByEmail(String productType, String userCity) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where productType = ? and userCity = ? and userEmail IS NOT NULL ORDER BY subscriptionID");
            pstmt.setString(1, productType);
            pstmt.setString(2, userCity);
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }
    
     public List<UserSubscription> getAllUserSubscriptionByPhone(String productType, String userCity) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM UserSubscription where productType = ? and userCity = ? and userPhoneNumber IS NOT NULL ORDER BY subscriptionID");
            pstmt.setString(1, productType);
            pstmt.setString(2, userCity);
            rs = pstmt.executeQuery();
            userSubscriptions = new ArrayList<UserSubscription>();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("usersubscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }
     
    public ArrayList<UserSubscription> getUserSubscription(int userID) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UserSubscription> userSubscriptions = new ArrayList<UserSubscription>();
        
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "select * from usersubscription where userID = ?");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("subscriptionID"));
                userSubscription.setUserID(rs.getInt("userID")); 
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public List<UserSubscription> getUserSubscriptionList(int userID, String location) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<UserSubscription> userSubscriptions = new ArrayList<UserSubscription>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement(
                    "select * from usersubscription where userID = ? and userCity = ?");
            pstmt.setInt(1, userID);
            pstmt.setString(2, location);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserSubscription userSubscription = new UserSubscription();
                userSubscription.setSubscriptionID(rs.getInt("subscriptionID"));
                userSubscription.setUserID(rs.getInt("userID"));
                userSubscription.setProductType(rs.getString("productType"));
                userSubscription.setCommunicationMethod(rs.getString("communicationMethod"));
                userSubscription.setUserEmail(rs.getString("userEmail"));
                userSubscription.setUserPhoneNumber(rs.getString("userPhoneNumber"));
                userSubscription.setUserCity(rs.getString("userCity"));
                userSubscriptions.add(userSubscription);
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
        return userSubscriptions;
    }

    public void addUserSubscription(UserSubscription userSubscription) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            // do not insert userID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO UserSubscription (userID, productType, communicationMethod, userEmail, userPhoneNumber, userCity) "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, userSubscription.getUserID());
            pstmt.setString(2, userSubscription.getProductType());
            pstmt.setString(3, userSubscription.getCommunicationMethod());
            pstmt.setString(4, userSubscription.getUserEmail());
            pstmt.setString(5, userSubscription.getUserPhoneNumber());
            pstmt.setString(6, userSubscription.getUserCity());
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
    
    public void updateUserSubscription(UserSubscription userSubscription) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("Update UserSubscription set productType = ?, communicationMethod=?, userEmail = ?, userPhoneNumber = ?, "
                    + "userCity = ?  where userID = ?");
            pstmt.setString(1, userSubscription.getProductType());
            pstmt.setString(2, userSubscription.getCommunicationMethod());
            pstmt.setString(3, userSubscription.getUserEmail());
            pstmt.setString(4, userSubscription.getUserPhoneNumber());
            pstmt.setString(5, userSubscription.getUserCity());
            pstmt.setInt(6, userSubscription.getUserID());
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
    
    public void deleteUserSubscription(UserSubscription userSubscription) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("Delete form UserSubscription where subscriptionID = ?" );             
            pstmt.setInt(1, userSubscription.getUserID());
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
    public void deleteUserSubscription(int ID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            con = databaseConnection.createConnection();
            pstmt = con.prepareStatement("DELETE  from usersubscription WHERE subscriptionID = ?" );             
            pstmt.setInt(1, ID);
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