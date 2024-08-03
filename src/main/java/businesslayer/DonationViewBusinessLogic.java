/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DonationViewDaoImpl;
import model.DonationView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dunxing Yu
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