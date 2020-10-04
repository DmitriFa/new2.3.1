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
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager em;

    public UserDaoImp() {
    }


    @Override
    public void createUsersTable() throws HibernateException {

    }

    @Override
    public TransactionDefinition dropUsersTable() throws HibernateException {
        return null;
    }

    @Override
    @Transactional
    public void addUser(User user) throws HibernateException {
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
    public void updateUserById(long id) throws HibernateException {
    }

    @Override
    @Transactional
    public List<User> getAllUsers() throws HibernateException {
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery("from User");
        List <User>users = query.list();
        return users;
    }


    @Override
    public void cleanUsersTable() throws HibernateException {

    }
}

