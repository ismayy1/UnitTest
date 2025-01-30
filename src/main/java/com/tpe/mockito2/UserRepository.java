package com.tpe.mockito2;

public class UserRepository {

    public String getUserName(int userId) {
        if (userId == 1) {
            return "bobSmith";
        } else if (userId == 2) {
            return "mikeOlsen";
        } else if (userId == 3) {
            return "jackJackson";
        } else {
            return null;
        }
    }
}
