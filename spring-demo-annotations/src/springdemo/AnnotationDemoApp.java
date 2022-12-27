package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        Coach runningCoach = context.getBean("runningCoach", Coach.class);
        Coach footballCoach = context.getBean("footballCoach", Coach.class);

        // call a method on the bean
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(runningCoach.getDailyWorkout());
        System.out.println(footballCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(tennisCoach.getDailyFortune());
        System.out.println(runningCoach.getDailyFortune());
        System.out.println(footballCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
