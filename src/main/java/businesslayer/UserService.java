package businesslayer;

import dataaccesslayer.UserDaoImpl;
import model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * The UserService class provides business logic operations for managing users.
 * It interacts with the UserDaoImpl class to perform CRUD (Create, Read, Update, Delete) operations on users.
 * author Qirong Chen
 */
public class UserService {

    // Instance of UserDaoImpl to interact with the database
    private UserDaoImpl userDao = null;

    /**
     * Constructs a new UserService instance and initializes the associated DAO.
     */
    public UserService() {
        userDao = new UserDaoImpl();
    }

    /**
     * Retrieves a list of all users from the database.
     *
     * @return List<User> - A list of User objects representing all users.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    /**
     * Retrieves a list of users by their user type.
     *
     * @param userType - The type of users to retrieve.
     * @return List<User> - A list of User objects representing users of the specified type.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public List<User> getAllUsersByUT(String userType) throws SQLException {
        return userDao.getAllUsersByUT(userType);
    }

    /**
     * Retrieves the ID of a user by their email.
     *
     * @param userEmail - The email of the user whose ID is to be retrieved.
     * @return int - The ID of the user.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public int getUserID(String userEmail) throws SQLException {
        return userDao.getUserID(userEmail);
    }

    /**
     * Retrieves a user by their email.
     *
     * @param userEmail - The email of the user to retrieve.
     * @return User - The User object representing the retrieved user.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public User getUserByEmail(String userEmail) throws SQLException {
        return userDao.getUserByEmail(userEmail);
    }

    /**
     * Adds a new user to the database.
     *
     * @param user - The User object containing details of the user to be added.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public void addUser(User user) throws SQLException {
        if (getUserByEmail(user.getUserEmail()) == null) {
            userDao.addUser(user);
        }
    }

    /**
     * Updates an existing user in the database.
     *
     * @param user - The User object containing updated details of the user.
     */
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * Updates the password of an existing user in the database.
     *
     * @param user - The User object containing the updated password of the user.
     */
    public void updateUserPass(User user) {
        userDao.updateUserPass(user);
    }

    /**
     * Deletes a user from the database by their email.
     *
     * @param email - The email of the user to be deleted.
     */
    public void deleteUser(String email) {
        userDao.deleteUser(email);
    }

    /**
     * Deletes a user from the database by their ID.
     *
     * @param id - The ID of the user to be deleted.
     */
    public void deleteUserByID(int id) {
        userDao.deleteUserByID(id);
    }
}
