/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DiscountDaoImpl;
import model.DiscountView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dunxing Yu
 */
public class DiscountViewBusinessLogic {
    
    private DiscountDaoImpl discountViewDao = null;

    public DiscountViewBusinessLogic() {
        discountViewDao = new DiscountDaoImpl();
    }
    public ArrayList<DiscountView> getAllDiscountProducts() throws SQLException {
        return discountViewDao.getAllDiscountProducts();
    }
    
    
}