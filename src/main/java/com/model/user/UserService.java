package com.model.user;

import java.util.List;

public interface UserService {

    void insert(User user);

    User selectByEmail(String email);

    boolean login(String email, String password);

    List<User> selectByName(String name);

    User getCurrentUser();
}
