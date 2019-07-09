package TestHibernate.DAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by м on 17.02.2017.
 */
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "Id")
    private int Id;
    @Column(name = "name")
    private String name;
}