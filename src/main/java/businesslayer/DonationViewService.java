package businesslayer;

import dataaccesslayer.DonationViewDaoImpl;
import model.DonationView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class interacts with the DonationViewDao to perform operations
 * related to donations, such as retrieving all donation products.
 * It serves as the business layer for donation-related operations.
 * author Qirong Chen
 */
public class DonationViewService {

    // Instance of DonationViewDaoImpl to interact with the database
    private DonationViewDaoImpl donationServiceDao = null;

    /**
     * Constructor that initializes the DonationViewDaoImpl instance.
     */
    public DonationViewService() {
        donationServiceDao = new DonationViewDaoImpl();
    }

    /**
     * Retrieves a list of all donation products from the database.
     *
     * @return ArrayList<DonationView> - A list of DonationView objects representing all donation products.
     * @throws SQLException - If there is an error accessing the database.
     */
    public ArrayList<DonationView> getAllDonationProducts() throws SQLException {
        return donationServiceDao.getAllDonationProducts();
    }
}
