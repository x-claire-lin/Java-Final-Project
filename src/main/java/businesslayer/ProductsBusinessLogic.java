
package businesslayer;

import dataaccesslayer.ProductsDaoImpl;
import model.Products;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Qirong Chen
 */
public class ProductsBusinessLogic {
    private ProductsDaoImpl productsDao = null;

    public ProductsBusinessLogic() {
        productsDao = new ProductsDaoImpl();
    }

    public List<Products> getAllProducts(int userID) throws SQLException {
        return productsDao.getAllProducts(userID);
    }

    public Products getProductsById(int productId) throws SQLException {
        return productsDao.getProductsById(productId);
    }

    public List<Products> getAllProductsByCondition(List<String> type, String location) throws SQLException {
        return productsDao.getAllProductsByCondition(type, location);
    }

    public void addProduct(Products product) {
        productsDao.addProduct(product);
    }

    public void updateProduct(Products product) {
        productsDao.updateProduct(product);
    }

    public void deleteProduct(Products product) {
        productsDao.deleteProduct(product);
    }

    public void updateDonation(int id, double amount) {
        productsDao.updateDonation(id, amount);
    }

    public void updateDiscount(int id, double amount) {
        productsDao.updateDiscount(id, amount);
    }

    // Method to trigger the update of surplus products
    public void updateSurplusProducts() {
        productsDao.updateSurplusProducts();
    }
}

