package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    /*@Override
    public void removeUser(User user) {
        userDao.removeUser(user);
    }*/

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void cleanTable() {
        userDao.cleanTable();
    }

}
