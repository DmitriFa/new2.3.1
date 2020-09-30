package web.dao;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
@Repository
@Transactional
public class UserDaoImp implements UserDao {
    UserDaoImp(){
    }
   @PersistenceContext
    private EntityManager em;
   // @Autowired
   // private SessionFactory sessionFactory;


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
        // List<User> list = new ArrayList<User>();
        //   User user =new User("Igor","Brikotkin",(byte)78);
        //   User user1 =new User("Bogdan","Titomir",(byte)34);
        //   User user2 =new User("Вася","Пупкин",(byte)65);
        //   list.add(user);
        //   list.add(user1);
        //   list.add(user2);
        // // EntityManager em = emf.createEntityManager();
       // TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");

       TypedQuery<User> query = em.createQuery("SELECT * FROM userex ", User.class);
        return query.getResultList(); //null;
        //list;
    }


    @Override
    public void cleanUsersTable() throws SQLException {

    }
}

