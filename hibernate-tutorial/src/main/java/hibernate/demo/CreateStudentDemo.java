package hibernate.demo;

import hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudentDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating a new student object...");

            String dateOfBirthStr = "29/01/1999";
            Date dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
            Student student = new Student("Timeea-Ioana", "Pitan", "timeea.pitan@gmail.com", dateOfBirth);

            System.out.println("\nSaving the student: " + student);

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            factory.close();
        }
    }
}
