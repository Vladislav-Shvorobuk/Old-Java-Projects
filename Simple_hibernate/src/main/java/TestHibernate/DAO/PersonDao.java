package TestHibernate.DAO;


import TestHibernate.DAO.entity.Person;
import java.util.List;

/**
 * Created by м on 17.02.2017.
 */
public interface PersonDao {

    public List<Person> findAll();
    public String findNameById(int Id);
}