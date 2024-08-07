package businesslayer;

import dataaccesslayer.SubscriptionMsgDaoImpl;
import model.SubscriptionMsg;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Qirong Chen
 */
public class SubscriptionMsgBusinessLogic {
    
    private SubscriptionMsgDaoImpl msgesDao=null;

    public SubscriptionMsgBusinessLogic() {
        msgesDao = new SubscriptionMsgDaoImpl();
    }

    public ArrayList<SubscriptionMsg> getAllSubscriptionMsgs(int recipientID) throws SQLException {
        return msgesDao.getAllSubscriptionMsgs(recipientID);
    }
    public void addSubscriptionMsg(SubscriptionMsg msg) {
        msgesDao.addSubscriptionMsg(msg);
    }
    public void deleteSubscriptionMsg(int id){
        msgesDao.deleteSubscriptionMsg(id);
    }
}