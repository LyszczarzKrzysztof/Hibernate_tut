import entity.Employee;
import entity.Phone;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setFirstName("Jan");
        employee.setLastName("Kochanowski");
        employee.setSalary(3559.2);
        Phone phone1 = new Phone();
        phone1.setType("home");
        phone1.setNumber("172555555");
        Phone phone2  = new Phone();
        phone2.setType("mobile");
        phone2.setNumber("888999222");
        employee.setPhones(Arrays.asList(phone1, phone2));

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }


}
