package web.service;



import org.hibernate.HibernateException;
import web.model.User;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    void createUsersTable() throws HibernateException, SQLException;

    void dropUsersTable() throws HibernateException, SQLException;

    void saveUser(String name, String lastName, byte age) throws HibernateException;

    void removeUserById(long id) throws HibernateException, SQLException;

    List<User> getAllUsers() throws HibernateException, SQLException;

    void cleanUsersTable() throws HibernateException, SQLException;

    void  addUser(User user) throws Exception;

}
