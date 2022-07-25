package ru.safonovroman.kata.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.safonovroman.kata.springcrud.dao.UserDao;
import ru.safonovroman.kata.springcrud.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public User getUser(Long id) {
      return userDao.getUser(id);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional
   public void update(User user) {
      userDao.update(user);
   }

   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }
}
