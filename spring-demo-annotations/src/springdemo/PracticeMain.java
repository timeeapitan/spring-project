package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeConfig.class);

        Coach coach = context.getBean("handballCoach", Coach.class);

        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}
