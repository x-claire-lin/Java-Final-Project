
package businesslayer;

import dataaccesslayer.UserDaoImpl;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBusinessLogic {

    private UserDaoImpl userDao = null;

    public UserBusinessLogic() {
        userDao = new UserDaoImpl();
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUesrs();
    }

    public List<User> getAllUsersByUT(String userType) throws SQLException {
        return userDao.getAllUesrsByUT(userType);
    }

    public int getUesrID(String userEmail) throws SQLException {
        return userDao.getUesrID(userEmail);
    }

    public User getUesrByEmail(String userEmail) throws SQLException {
        return userDao.getUesrByEmail(userEmail);
    }

    public void addUser(User user) throws SQLException {
        if(getUesrByEmail(user.getUserEmail())==null){
            userDao.addUser(user);
        }
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void updateUserPass(User user) {
        userDao.updateUserPass(user);
    }

    public void deleteUser(String email){
        userDao.deleteUser(email);
    }
    public void deleteUserByID(int id){
        userDao.deleteUserByID(id);
    }

}