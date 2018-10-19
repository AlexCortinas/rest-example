package es.udc.lbd.asi.restexample.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.udc.lbd.asi.restexample.model.domain.User;
import es.udc.lbd.asi.restexample.model.repository.util.GenericDAOHibernate;

@Repository
public class UserDAOHibernate extends GenericDAOHibernate implements UserDAO {

    @Override
    public List<User> findAll() {
        return getSession().createQuery("from User").list();
    }

    @Override
    public void save(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public User findByName(String name) {
        return (User) getSession().createQuery("from User where name = :name").setParameter("name", name).uniqueResult();
    }
}
