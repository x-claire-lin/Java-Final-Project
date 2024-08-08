
package businesslayer;

import dataaccesslayer.DiscountDaoImpl;
import model.DiscountView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The class interacts with discountdao.
 * @author Qirong Chen
 */
public class DiscountService {

    private DiscountDaoImpl discountViewDao = null;

    public DiscountService() {
        discountViewDao = new DiscountDaoImpl();
    }
    public ArrayList<DiscountView> getAllDiscountProducts() throws SQLException {
        return discountViewDao.getAllDiscountProducts();
    }


}