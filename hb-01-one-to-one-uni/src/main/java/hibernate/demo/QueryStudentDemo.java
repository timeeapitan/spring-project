package hibernate.demo;

import hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").list();

            // display the students
            displayStudents(students);

            // query students: lastName = 'Pitan'
            students = session.createQuery("from Student s where s.lastName='Pitan'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Pitan");
            displayStudents(students);

            // query students: lastName = 'Bodea' OR firstName = 'Daffy'
            students = session.createQuery("from Student s where s.lastName='Bodea' OR s.firstName='Daffy'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Bodea or first name of Daffy");
            displayStudents(students);

            // query students: email LIKE '%yahoo.com'
            students = session.createQuery("from Student s where s.email like '%yahoo.com'").list();

            // display the students
            System.out.println("\n\nStudents who have email like '%yahoo.com'");
            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
