package businesslayer;

import dataaccesslayer.SubscriptionMsgDaoImpl;
import model.SubscriptionMsg;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The SubscriptionMsgService class provides business logic operations for managing subscription messages.
 * It interacts with the SubscriptionMsgDaoImpl class to perform CRUD (Create, Read, Delete) operations on subscription messages.

 * author Qirong Chen
 */
public class SubscriptionMsgService {

    // Instance of SubscriptionMsgDaoImpl to interact with the database
    private SubscriptionMsgDaoImpl msgesDao = null;

    /**
     * Constructs a new SubscriptionMsgService instance and initializes the associated DAO.
     */
    public SubscriptionMsgService() {
        msgesDao = new SubscriptionMsgDaoImpl();
    }

    /**
     * Retrieves all subscription messages for a given recipient from the database.
     *
     * @param recipientID - The ID of the recipient whose subscription messages are to be retrieved.
     * @return An ArrayList containing all subscription messages retrieved for the recipient.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public ArrayList<SubscriptionMsg> getAllSubscriptionMsgs(int recipientID) throws SQLException {
        return msgesDao.getAllSubscriptionMsgs(recipientID);
    }

    /**
     * Adds a new subscription message to the database.
     *
     * @param msg - The SubscriptionMsg object containing details of the message to be added.
     */
    public void addSubscriptionMsg(SubscriptionMsg msg) {
        msgesDao.addSubscriptionMsg(msg);
    }

    /**
     * Deletes a subscription message from the database by its ID.
     *
     * @param id - The ID of the subscription message to be deleted.
     */
    public void deleteSubscriptionMsg(int id) {
        msgesDao.deleteSubscriptionMsg(id);
    }
}
