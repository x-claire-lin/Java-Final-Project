package businesslayer;

import dataaccesslayer.DonationViewDaoImpl;
import model.DonationView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The class interacts with donationviewDao.
 * @author Qirong Chen
 */
public class DonationViewBusinessLogic {
    
    private DonationViewDaoImpl donationViewDao = null;

    public DonationViewBusinessLogic() {
        donationViewDao = new DonationViewDaoImpl();
    }
    public ArrayList<DonationView> getAllDonationProducts() throws SQLException {
        return donationViewDao.getAllDonationProducts();
    }  
}