package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    public FootballCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public FootballCoach() {
        System.out.println(">> FootballCoach: inside the default constructor");
    }

    @Override
    public String getDailyWorkout() {
        System.out.println("Email: " + email);
        System.out.println("Team: " + team);
        return "Do sprints 1h a day.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
