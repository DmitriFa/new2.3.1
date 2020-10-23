package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImp() {
    }

    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    public void removeUser(User user) throws Exception {
        userDao.removeUser(user);
    }

    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws Exception {
        return userDao.getAllUsers();
    }

    public User getUserById(int id) throws Exception {
      // return getAllUsers().get(id);
       return userDao.getUserById(id);
    }
    @Override
    @Transactional
    public boolean checkLastName(String lastName) throws Exception {
        return userDao.checkLastName(lastName);
    }
}
