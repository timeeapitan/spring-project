package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

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
