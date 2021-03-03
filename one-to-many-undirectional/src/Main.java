import entity.Employee;
import entity.Phone;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(1000.0);

        phone1.setNumber("17-222-22-22");
        phone1.setType("home");

        phone2.setNumber("999-999-999");
        phone2.setType("mobile");

        List<Phone> phoneList = new ArrayList<>();
        phoneList.addAll(Arrays.asList(phone1, phone2));

        employee.setPhoneList(phoneList);



        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
