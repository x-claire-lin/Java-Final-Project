package businesslayer;

import dataaccesslayer.ProductsDaoImpl;
import model.Products;

import java.sql.SQLException;
import java.util.List;

/**
 * This class interacts with the ProductsDao to perform operations
 * related to products, such as retrieving, adding, updating, and deleting products.
 * It serves as the business layer for product-related operations.
 * author Qirong Chen
 */
public class ProductService {
    // Instance of ProductsDaoImpl to interact with the database
    private ProductsDaoImpl productDao = null;

    /**
     * Constructor that initializes the ProductsDaoImpl instance.
     */
    public ProductService() {
        productDao = new ProductsDaoImpl();
    }

    /**
     * Retrieves a list of all products for a given user.
     *
     * @param userID - The ID of the user whose products are to be retrieved.
     * @return List<Products> - A list of Products objects representing the user's products.
     * @throws SQLException - If there is an error accessing the database.
     */
    public List<Products> getAllProducts(int userID) throws SQLException {
        return productDao.getAllProducts(userID);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId - The ID of the product to be retrieved.
     * @return Products - The Products object representing the retrieved product.
     * @throws SQLException - If there is an error accessing the database.
     */
    public Products getProductsById(int productId) throws SQLException {
        return productDao.getProductsById(productId);
    }

    /**
     * Retrieves a list of products based on specified conditions.
     *
     * @param type - A list of product types to filter by.
     * @param location - The location to filter by.
     * @return List<Products> - A list of Products objects representing the filtered products.
     * @throws SQLException - If there is an error accessing the database.
     */
    public List<Products> getAllProductsByCondition(List<String> type, String location) throws SQLException {
        return productDao.getAllProductsByCondition(type, location);
    }

    /**
     * Adds a new product to the database.
     *
     * @param product - The Products object containing details of the product to be added.
     */
    public void addProduct(Products product) {
        productDao.addProduct(product);
    }

    /**
     * Updates an existing product in the database.
     *
     * @param product - The Products object containing updated details of the product.
     */
    public void updateProduct(Products product) {
        productDao.updateProduct(product);
    }

    /**
     * Deletes a product from the database.
     *
     * @param product - The Products object representing the product to be deleted.
     */
    public void deleteProduct(Products product) {
        productDao.deleteProduct(product);
    }

    /**
     * Updates the donation amount for a product.
     *
     * @param id - The ID of the product to be updated.
     * @param amount - The new donation amount.
     */
    public void updateDonation(int id, double amount) {
        productDao.updateDonation(id, amount);
    }

    /**
     * Updates the discount amount for a product.
     *
     * @param id - The ID of the product to be updated.
     * @param amount - The new discount amount.
     */
    public void updateDiscount(int id, double amount) {
        productDao.updateDiscount(id, amount);
    }

    /**
     * Triggers the update of surplus products in the database.
     */
    public void updateSurplusProducts() {
        productDao.updateSurplusProducts();
    }
}
