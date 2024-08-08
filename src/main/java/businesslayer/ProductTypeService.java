package businesslayer;

import dataaccesslayer.ProductTypesDaoImpl;
import model.ProductTypes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The ProductTypeService class provides business logic operations for managing product types.
 * It interacts with the ProductTypesDaoImpl class to perform CRUD (Create, Read, Delete) operations on product types.

 * author Qirong Chen
 */
public class ProductTypeService {
    // Instance of ProductTypesDaoImpl to interact with the database
    private ProductTypesDaoImpl productTypeDao = null;

    /**
     * Constructs a new ProductTypeService instance and initializes the associated DAO.
     */
    public ProductTypeService() {
        productTypeDao = new ProductTypesDaoImpl();
    }

    /**
     * Retrieves all product types from the database.
     *
     * @return An ArrayList containing all product types retrieved from the database.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public ArrayList<ProductTypes> getAllProductTypes() throws SQLException {
        return productTypeDao.getAllProductTypes();
    }
}
