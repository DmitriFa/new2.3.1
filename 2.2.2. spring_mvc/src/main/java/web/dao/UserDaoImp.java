package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImp implements UserDao {
    public UserDaoImp() {
    }


    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public TransactionDefinition dropUsersTable() throws SQLException {
        return null;
    }

   /* @Autowired
   // EntityManagerFactory emf = Persistence.createEntityManagerFactory("jm.task.core.jdbc");
   // @PersistenceContext
   // EntityManager em = emf.createEntityManager();



   // User user = new User("Даннил", "Гранин", (byte) 38);
    @Override
    public void addUser(User user) throws HibernateException, SQLException {
        em.getTransaction().begin();
        em.persist(user);
        em.flush();

    }*/

    @Override
    public void saveUser(String name, String lastName, byte age) throws HibernateException {

    }

    @Override
    public void removeUserById(long id) throws HibernateException {
    }

    @Override
    public void updateUserById(long id) throws SQLException {

    }

   @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<User>();
        User user =new User("Igor","Brikotkin",(byte)78);
        User user1 =new User("Bogdan","Titomir",(byte)34);
        User user2 =new User("Вася","Пупкин",(byte)65);
        list.add(user);
        list.add(user1);
        list.add(user2);
       // EntityManager em = getEntityManager();
      // TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return list;
              //  query.getResultList();
    }


    @Override
    public void cleanUsersTable() throws SQLException {

    }
}

