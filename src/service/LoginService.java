package service;

import repository.LoginRepository;

public class LoginService {

    private LoginRepository loginRepository;

    public LoginService() {
        loginRepository = new LoginRepository();
    }

    public String login (String username, String password) {
        if (loginRepository != null) {
            boolean status = loginRepository.authenticate(username, password);
            if (!status) {
                System.out.println("Wrong username/password");
                return "Unauthorized";
            }
            else {
                return "LoginSuccess";
            }
        }
        //An error occured
        return "LoginFail";
    }
}
