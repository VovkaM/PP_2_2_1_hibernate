package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
   private static SessionFactory sessionFactory;


   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getlistUsers() {
      return userDao.getlistUsers();
   }



   @Transactional(readOnly = true)
   @Override
   public List<User> getUsers(String model,int series) {
      return userDao.getUsers(model,series);

   }
}