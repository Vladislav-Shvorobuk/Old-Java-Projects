package TestHibernate.service;


import TestHibernate.DAO.PersonDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by м on 17.02.2017.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        PersonDao personDao = context.getBean(PersonDao.class);
        List list = personDao.findAll();
        System.out.println(list);
    }
}
