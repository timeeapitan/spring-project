package springdemo;

public class PracticeFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a great day!";
    }
}
