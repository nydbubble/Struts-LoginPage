package service;

import repository.LoginRepository;

public class LoginService {

    private LoginRepository loginRepository;

    public LoginService() {
        loginRepository = new LoginRepository();
    }

    public String login (String username, String password) {
        if (loginRepository != null) {
            String correctPassword = loginRepository.getPassword(username);
            System.out.println(correctPassword);
            if (correctPassword.equals("errorUsernameNotFound")) {
                System.out.println("Username not found!");
                return "UsernameNotFound";
            }
            else if (correctPassword.equals("errorWhatHappened")) {
                System.out.println("Database may not be connected");
                return "LoginFail";
            }
            else if (!correctPassword.equals(password)) {
                System.out.println("Wrong password");
                return "Unauthorized";
            }
            else {
                System.out.println("Authentication success");
                return "LoginSuccess";
            }
        }
        //An error occured
        return "LoginFail";
    }
}
