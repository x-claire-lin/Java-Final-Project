package model;

/**
 *
 * @author Xihong
 */
public class Consumer implements UserInterface{
    private String name;
    private String email;
    private String password;

    public Consumer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public void performAction() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUserType() {
        return "Consumer";
    }

}
