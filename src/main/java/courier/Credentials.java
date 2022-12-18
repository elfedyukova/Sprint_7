package courier;

public class Credentials {
    private String login;
    private String password;


    public Credentials (){

    }

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;

    }
    public static Credentials loginfrom(Courier courier){
        return new Credentials(courier.getLogin(), courier.getPassword());
    }

    public String getLogin() { return login; }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}