package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RunningCoach implements Coach {

    @Autowired
    @Qualifier("databaseFortuneService")
    private FortuneService fortuneService;

    public RunningCoach() {
        System.out.println(">> RunningCoach: inside the default constructor");
    }

    //    @Autowired
    public RunningCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run 10k 3 times a week.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> RunningCoach: inside the setFortuneService() method");
        this.fortuneService = fortuneService;
    }
}
