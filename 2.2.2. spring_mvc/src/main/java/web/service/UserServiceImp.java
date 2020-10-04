package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImp;
import web.model.User;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService {

  //  UserDaoImp userDao = new UserDaoImp();


  private UserDaoImp userDao;
  public UserServiceImp(){

  }
    public UserServiceImp(UserDaoImp userDao){

    }
    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }


    public void saveUser(String name, String lastName, byte age)  {
        userDao.saveUser(name,lastName,age);
    }

    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }


    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }
  /*  private UserRepository repository;
    public UserServiceImp() {

    }

    @Autowired
    public UserServiceImp(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public List getAllUsers() {
        List list = new ArrayList();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }*/

    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }


}
