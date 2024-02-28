package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);

    public void removeUser(User user);

    public List<User> getAllUsers();

}