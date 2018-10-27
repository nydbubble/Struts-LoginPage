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
        String result;
        LoginService loginService = new LoginService();

        result = loginService.login(user.getUsername(), user.getPassword());
        switch (result) {
            case "Unauthorized":
                addActionError("Wrong password.");
                break;
            case "UsernameNotFound":
                addActionError("Username not found.");
                break;
            case "LoginFail":
                //Inform that there's something wrong with the database connection
                addActionError("An error occured. Please try again later.");
                break;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
