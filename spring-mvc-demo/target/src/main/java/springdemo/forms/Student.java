package springdemo.forms;

import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;

    private String country;
    private final LinkedHashMap<String, String> countryOptions;
    private String favoriteLanguage;
    private final LinkedHashMap<String, String> favoriteLanguageOptions;

    private List<String> operatingSystems;

    public Student() {

        // populate country options: used ISO country code
        countryOptions = new LinkedHashMap<>();

        countryOptions.put("RO", "Romania");
        countryOptions.put("IT", "Italy");
        countryOptions.put("ES", "Spain");
        countryOptions.put("NL", "Netherlands");
        countryOptions.put("US", "United States");

        // populate favorite language options
        favoriteLanguageOptions = new LinkedHashMap<>();
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("JavaScript", "JavaScript");
        favoriteLanguageOptions.put("C++", "C++");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
