package hibernate.demo;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 4;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println("The instructor detail: " + instructorDetail);

            // print the associated instructor
            System.out.println("The associated instructor: " + instructorDetail.getInstructor());

            // now let's delete the instructor detail
            System.out.println("Deleting instructor detail: " + instructorDetail);

            // remove the associated object reference
            // break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }
    }
}
