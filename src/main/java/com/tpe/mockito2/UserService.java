package com.tpe.mockito2;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser(int id) {
        String userName = userRepository.getUserName(id);

        if (userName == null) {
            throw new RuntimeException("No User found with given ID: " + id);
        }

//        return "Dear " + userName;
        return "Dear " + userRepository.getUserName(id);
    }
}
