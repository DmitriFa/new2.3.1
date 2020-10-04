package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager em;

    public UserDaoImp() {
    }


    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public TransactionDefinition dropUsersTable() throws SQLException {
        return null;
    }


    @Override
    @Transactional
    public void addUser(User user) throws HibernateException, SQLException {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.flush();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws HibernateException {

    }

    @Override
    public void removeUserById(long id) throws HibernateException {
    }

    @Override
    public void updateUserById(long id) throws SQLException {

    }

    @Override
    @Transactional
    public List<User> getAllUsers() throws SQLException {
        String hql = "from User";
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        return users;

    }


    @Override
    public void cleanUsersTable() throws SQLException {

    }
}

