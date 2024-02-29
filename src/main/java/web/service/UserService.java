package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void removeUser(Long id);

    void updateUser(User user);
}
