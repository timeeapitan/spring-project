package springdemo;

public class HandballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Throw the ball in different corners of the handball gate";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
