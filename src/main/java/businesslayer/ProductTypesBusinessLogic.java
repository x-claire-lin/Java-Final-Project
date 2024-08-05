package businesslayer;

import dataaccesslayer.ProductTypesDaoImpl;
import model.ProductTypes;

import java.sql.SQLException;
import java.util.ArrayList;

/**

 The ProductTypesBusinessLogic class provides business logic operations for managing product types.

 It interacts with the ProductTypesDaoImpl class to perform CRUD (Create, Read,Delete) operations on product types.

 @author Qirong Chen
 */
public class ProductTypesBusinessLogic {
    private ProductTypesDaoImpl productTypesDao = null;

    /**

     Constructs a new ProductTypesBusinessLogic instance and initializes the associated DAO.
     */
    public ProductTypesBusinessLogic() {

        productTypesDao = new ProductTypesDaoImpl();
    }
    /**

     Retrieves all product types from the database.
     @return An ArrayList containing all product types retrieved from the database.
     @throws SQLException If an SQL exception occurs while accessing the database.
     */
    public ArrayList<ProductTypes> getAllProductTypes() throws SQLException {
        return productTypesDao.getAllProductTypes();
    }



}