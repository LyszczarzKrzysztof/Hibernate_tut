import entity.Employee;
import entity.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class Fetch {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 1L);

        List<Phone> phones = employee.getPhones();
        System.out.println(phones);

        entityManager.close();
        entityManagerFactory.close();
    }


}
