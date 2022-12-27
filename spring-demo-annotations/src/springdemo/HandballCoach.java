package springdemo;

public class HandballCoach implements Coach {

    private FortuneService fortuneService;

    public HandballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Throw at the goal in all possible ways.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
