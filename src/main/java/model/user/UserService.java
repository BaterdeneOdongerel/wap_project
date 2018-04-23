package model.user;

import java.util.List;

public interface UserService {

    void insert(User user);

    User selectById(int id);

    List<User> selectAll();

    void delete(int id);

    void update(User user, int id);
    
    boolean login(String email, String password);
}
