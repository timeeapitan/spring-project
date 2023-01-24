package hibernate.practice_activity;

import hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();

            // create and save students
            System.out.println("Saving employees...");
            Employee e1 = new Employee("Emily", "Rose", "CODEMART");
            Employee e2 = new Employee("Mark", "Louis", "MicroFocus");

//            session.save(e1);
//            session.save(e2);
            session.getTransaction().commit();

            // retrieve students
            session = factory.getCurrentSession();
            session.beginTransaction();

            int employeeId = 1;
            Employee myEmployee = session.get(Employee.class, employeeId);
            System.out.println("\n\nGetting employee with id " + employeeId + ": " + myEmployee);

            System.out.println("\n\nGetting employees that work at Codemart");
            List<Employee> companyEmployees = session.createQuery("from Employee e where e.company='Codemart'").list();
            displayEmployees(companyEmployees);

            session.getTransaction().commit();

            // update employee with lastName = "Pitan"
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee timeeaEmployee = session.get(Employee.class, employeeId);
            System.out.println("\n\nUpdate employee " + timeeaEmployee);
            timeeaEmployee.setFirstName("Timeea-Ioana");

            session.getTransaction().commit();

            // update all employees
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Employee set company='Codemart'").executeUpdate();
            session.getTransaction().commit();

            // delete employee by primary key
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee toDeleteEmployee = session.get(Employee.class, 3);
            session.delete(toDeleteEmployee);
            System.out.println("\n\nDeleting employee " + toDeleteEmployee);

            session.getTransaction().commit();

            System.out.println("DONE!");

        } finally {
            factory.close();
        }
    }

    private static void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
