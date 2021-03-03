import entity.Address;
import entity.Employee;

import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        Address address = new Address();

        employee.setFirstName("Jan");
        employee.setLastName("Jankowski");
        employee.setSalary(1111.11);
        employee.setAddress(address);
        address.setLocality("Szczecin");
        address.setStreet("Sezamkowa");
        address.setStreetNumber(1);
        address.setZipCode("11-111");

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
