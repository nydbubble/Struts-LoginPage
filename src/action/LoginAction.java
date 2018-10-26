package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import service.LoginService;

public class LoginAction extends ActionSupport{

    private User user;

    public String execute() {
        return "success";
    }

    public void validate() {
        String result = "";
        LoginService loginService = new LoginService();

        result = loginService.login(user.getUsername(), user.getPassword());
        if (result.equals("Unauthorized")) {
            addActionError("Invalid username/password.");
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
