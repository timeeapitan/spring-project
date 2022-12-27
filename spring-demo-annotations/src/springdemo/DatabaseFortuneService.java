package springdemo;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class DatabaseFortuneService implements FortuneService {
    private List<String> fortunes;
    private Random random = new Random();

    public DatabaseFortuneService() {
        try {
            File file = new File("D:\\UDEMY\\Spring & Hibernate for Beginners\\spring-demo-annotations\\src\\springdemo\\fortunes.txt");
            Scanner scanner = new Scanner(file);
            fortunes = new ArrayList<>();

            int i = 0;
            while (scanner.hasNextLine()) {
                fortunes.add(scanner.nextLine());
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
