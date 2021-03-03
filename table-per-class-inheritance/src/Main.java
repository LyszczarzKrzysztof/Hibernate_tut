import entity.Person;
import entity.Professor;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Professor professor = new Professor();
        professor.setFirstName("Adam");
        professor.setLastName("Adamowski");
        professor.setSalary(7563.0);

        Student student = new Student();
        student.setFirstName("Marek");
        student.setLastName("Marecki");
        student.setAverageGrade(4.75);


        entityManager.getTransaction().begin();
        entityManager.persist(professor);
        entityManager.persist(student);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
