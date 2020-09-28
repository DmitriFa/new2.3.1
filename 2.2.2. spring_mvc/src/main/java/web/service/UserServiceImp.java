package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImp implements UserService {


    UserDaoImp userDao = new UserDaoImp();
  @Autowired
  private UserDao userdao;

    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }


    public void saveUser(String name, String lastName, byte age)  {
        userDao.saveUser(name,lastName,age);
    }

   // public void addUser(User user) throws SQLException {
   //     userDao.addUser(user);
   // }


    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }
    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }


}