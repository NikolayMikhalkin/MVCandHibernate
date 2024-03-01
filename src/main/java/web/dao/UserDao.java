package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void add(User user);

    public void removeUser(Long id);

    public void updateUser(User user);

    void cleanTable();

}