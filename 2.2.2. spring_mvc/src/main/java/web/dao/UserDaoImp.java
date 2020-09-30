package web.dao;

import org.hibernate.HibernateException;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Transactional
public class UserDaoImp implements UserDao {

    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public TransactionDefinition dropUsersTable() throws SQLException {
        return null;
    }

    // @Autowired
    // User user = new User("Даннил", "Гранин", (byte) 38);

    @Override
    @Transactional
    public void addUser(User user) throws HibernateException, SQLException {
        //  em= emf.createEntityManager();
        // em.getTransaction().begin();
        // em.persist(user);
        // em.getTransaction().commit();
        //em.flush();
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

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public List<User> getAllUsers() throws SQLException {
      /* List<User> list = new ArrayList<User>();
        User user =new User("Igor","Brikotkin",(byte)78);
        User user1 =new User("Bogdan","Titomir",(byte)34);
        User user2 =new User("Вася","Пупкин",(byte)65);
        list.add(user);
        list.add(user1);
        list.add(user2);
      // EntityManager em = emf.createEntityManager();*/
        //TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");

        TypedQuery<User> query =
                em.createQuery("SELECT * FROM userex", User.class);
        return query.getResultList(); //null;
        //list;
    }


    @Override
    public void cleanUsersTable() throws SQLException {

    }
}

