package model;

/**
 *
 * @author Xihong
 */
public class UserFactory {
    public static UserInterface createUser(String userType, String name, String email, String password) {
        switch (userType.toLowerCase()) {
            case "retailer":
                return new Retailer(name, email, password);
            case "charitable organization":
                return new CharitableOrganization(name, email, password);
            case "consumer":
                return new Consumer(name, email, password);
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
