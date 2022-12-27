package springdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    // define a default constructor (mainly for debugging)
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define the init method
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartUpStuff() method");
    }

    // define the destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff() method");
    }

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
//
//    public TennisCoach(String testingAnnotation) {
//
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(">> TennisCoach: inside destroy()");
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside setFortuneService() method");
//        this.fortuneService = fortuneService;
//    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println(">> TennisCoach: inside the doSomeCrazyStuff() method");
//        this.fortuneService = fortuneService;
//    }
}
