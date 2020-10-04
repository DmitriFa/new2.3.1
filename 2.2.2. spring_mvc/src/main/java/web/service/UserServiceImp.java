package web.service;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    public UserServiceImp() {
    }

    public void createUsersTable() throws HibernateException, SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws HibernateException, SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age)throws HibernateException {
        userDao.saveUser(name, lastName, age);
    }

    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    public void removeUserById(long id) throws HibernateException, SQLException {
        userDao.removeUserById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws HibernateException, SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws HibernateException, SQLException {
        userDao.cleanUsersTable();
    }
}
