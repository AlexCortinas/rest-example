package es.udc.lbd.asi.restexample.model.repository;

import java.util.List;

import es.udc.lbd.asi.restexample.model.domain.User;

public interface UserDao {
  List<User> findAll();

  User findById(Long id);

  User findByLogin(String login);

  void create(User user);
}
