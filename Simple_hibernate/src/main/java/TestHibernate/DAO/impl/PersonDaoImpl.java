package TestHibernate.DAO.impl;



import TestHibernate.DAO.PersonDao;
import TestHibernate.DAO.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by м on 17.02.2017.
 */
@Repository
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        List<Person> list = sessionFactory.getCurrentSession().createQuery("from Person").list();
        return list;
    }

    public String findNameById(int Id) {
        String name = sessionFactory.
                getCurrentSession().createQuery("from Person where Id= :Id").toString();
        return name;
    }
}
