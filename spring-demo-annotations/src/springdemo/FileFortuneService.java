package springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private List<String> fortunes;
    private Random random = new Random();

    @PostConstruct
    public void readFortunesFromFile() {
        fortunes = new ArrayList<>();

        File file = new File("D:\\UDEMY\\Spring & Hibernate for Beginners\\spring-demo-annotations\\src\\springdemo\\fortunes.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String tempLine;

            while ((tempLine = br.readLine()) != null) {
                fortunes.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
