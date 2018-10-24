package service;

import repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public String login (String username, String password) {
        if (userRepository != null) {
            if (!userRepository.authenticate(username, password)) {
                System.out.println("Wrong username/password");
                return "Unauthorized";
            }
            else if (userRepository.authenticate(username, password)) {
                return "LoginSuccess";
            }
        }
        //An error occured
        return "LoginFail";
    }
}
