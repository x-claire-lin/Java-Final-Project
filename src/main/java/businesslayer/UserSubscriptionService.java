package businesslayer;

import dataaccesslayer.UserSubscriptionDaoImpl;
import model.UserSubscription;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The UserSubscriptionService class provides business logic operations for managing user subscriptions.
 * It interacts with the UserSubscriptionDaoImpl class to perform CRUD (Create, Read, Update, Delete) operations on user subscriptions.
 * author Qirong Chen
 */
public class UserSubscriptionService {

    // Instance of UserSubscriptionDaoImpl to interact with the database
    private UserSubscriptionDaoImpl userSubscriptionDao = null;

    /**
     * Constructs a new UserSubscriptionService instance and initializes the associated DAO.
     */
    public UserSubscriptionService() {
        userSubscriptionDao = new UserSubscriptionDaoImpl();
    }

    /**
     * Retrieves a list of all user subscriptions from the database.
     *
     * @return List<UserSubscription> - A list of UserSubscription objects representing all user subscriptions.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<UserSubscription> getAllUserSubscription() throws SQLException {
        return userSubscriptionDao.getAllUserSubscription();
    }

    /**
     * Retrieves a list of user subscriptions based on product type and user city.
     *
     * @param productType - The type of product to filter subscriptions by.
     * @param userCity - The city of the user to filter subscriptions by.
     * @return List<UserSubscription> - A list of UserSubscription objects matching the specified criteria.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<UserSubscription> getAllUserSubscriptionByPTCity(String productType, String userCity) throws SQLException {
        return userSubscriptionDao.getAllUserSubscriptionByPTCity(productType, userCity);
    }

    /**
     * Retrieves a list of user subscriptions based on product type and user city, filtered by email.
     *
     * @param productType - The type of product to filter subscriptions by.
     * @param userCity - The city of the user to filter subscriptions by.
     * @return List<UserSubscription> - A list of UserSubscription objects matching the specified criteria.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<UserSubscription> getAllUserSubscriptionByEmail(String productType, String userCity) throws SQLException {
        return userSubscriptionDao.getAllUserSubscriptionByEmail(productType, userCity);
    }

    /**
     * Retrieves a list of user subscriptions based on product type and user city, filtered by phone number.
     *
     * @param productType - The type of product to filter subscriptions by.
     * @param userCity - The city of the user to filter subscriptions by.
     * @return List<UserSubscription> - A list of UserSubscription objects matching the specified criteria.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<UserSubscription> getAllUserSubscriptionByPhone(String productType, String userCity) throws SQLException {
        return userSubscriptionDao.getAllUserSubscriptionByPhone(productType, userCity);
    }

    /**
     * Retrieves a list of user subscriptions for a specific user by user ID.
     *
     * @param userID - The ID of the user whose subscriptions are to be retrieved.
     * @return ArrayList<UserSubscription> - A list of UserSubscription objects for the specified user.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public ArrayList<UserSubscription> getUserSubscription(int userID) throws SQLException {
        return userSubscriptionDao.getUserSubscription(userID);
    }

    /**
     * Retrieves a list of user subscriptions for a specific user and location.
     *
     * @param userID - The ID of the user whose subscriptions are to be retrieved.
     * @param location - The location to filter subscriptions by.
     * @return List<UserSubscription> - A list of UserSubscription objects for the specified user and location.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<UserSubscription> getUserSubscriptionList(int userID, String location) throws SQLException {
        return userSubscriptionDao.getUserSubscriptionList(userID, location);
    }

    /**
     * Adds a new user subscription to the database.
     *
     * @param userSubscription - The UserSubscription object containing details of the subscription to be added.
     */
    public void addUserSubscription(UserSubscription userSubscription) {
        userSubscriptionDao.addUserSubscription(userSubscription);
    }

    /**
     * Updates an existing user subscription in the database.
     *
     * @param userSubscription - The UserSubscription object containing updated details of the subscription.
     */
    public void updateUserSubscription(UserSubscription userSubscription) {
        userSubscriptionDao.updateUserSubscription(userSubscription);
    }

    /**
     * Deletes a user subscription from the database.
     *
     * @param userSubscription - The UserSubscription object representing the subscription to be deleted.
     */
    public void deleteUserSubscription(UserSubscription userSubscription) {
        userSubscriptionDao.deleteUserSubscription(userSubscription);
    }

    /**
     * Deletes a user subscription from the database by its ID.
     *
     * @param sID - The ID of the subscription to be deleted.
     */
    public void deleteUserSubscription(int sID) {
        userSubscriptionDao.deleteUserSubscription(sID);
    }
}
