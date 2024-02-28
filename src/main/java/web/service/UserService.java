package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void removeUser(User user);

    public List<User> getAllUsers();
}
