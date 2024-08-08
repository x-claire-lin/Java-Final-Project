package businesslayer;

import dataaccesslayer.DiscountDaoImpl;
import model.DiscountView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class interacts with the DiscountDao to perform operations
 * related to discounts, such as retrieving all discount products.
 * It serves as the business layer for discount-related operations.
 *
 * @author  Qirong Chen
 */
public class DiscountService {

    // Instance of DiscountDaoImpl to interact with the database
    private DiscountDaoImpl discountServiceDao = null;

    /**
     * Constructor that initializes the DiscountDaoImpl instance.
     */
    public DiscountService() {
        discountServiceDao = new DiscountDaoImpl();
    }

    /**
     * Retrieves a list of all discount products from the database.
     *
     * @return ArrayList<DiscountView> - A list of DiscountView objects representing all discount products.
     * @throws SQLException - If there is an error accessing the database.
     */
    public ArrayList<DiscountView> getAllDiscountProducts() throws SQLException {
        return discountServiceDao.getAllDiscountProducts();
    }
}
