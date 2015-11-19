package springed.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "vacancies")
public class Vacancy {

    @Id
    private String id;

    @Field("name")
    private String title;

    private String description;

    private String salary;

    @Field("area.name")
    private String city;

    private String country;

    @Field(value = "employer.name")
    private String employer;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmployer() {
        return employer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
