package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
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
    @Transactional
    public void addUser(User user) throws HibernateException {
       Session session = em.unwrap(Session.class);
       session.save(user);
    }


    @Override
    @Transactional
    public void removeUser(User user) throws HibernateException {
        Session session = em.unwrap(Session.class);
        session.delete(user);
    }

    @Override
    @Transactional
    public   void updateUser(User user){
        Session session = em.unwrap(Session.class);
        session.update(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() throws HibernateException {
        Session session = em.unwrap(Session.class);
       return session.createQuery("from User").list();
    }
   @Override
   @Transactional
   public User getUserById(int id){
     // Session session = em.unwrap(Session.class);
      // return session.get(User.class, id);
       return (User) em.find(User.class, id);
   }
    @Override
    @Transactional
    public boolean checkLastName(String lastName) {
        Session session = em.unwrap(Session.class);
        Query query;
        query = session.createQuery("from User where lastName = :lastName");
        query.setParameter("title", lastName);
        return query.list().isEmpty();
    }
}

