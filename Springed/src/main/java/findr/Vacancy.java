package findr;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import static java.util.Arrays.asList;

/**
 * Created by v.pozdeev on 28.10.2015.
 */
public class Vacancy {

    private final Long id;
    private final String title;
    private final String description;
    private final String salary;
    private final String city;
    private final String country;
    private final String employer;

    public Vacancy(String title, String country) {
        this(title, "", "", "", country, "");
    }

    public Vacancy(String title, String description, String salary, String city, String country, String employer) {
        this.id = null;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.city = city;
        this.country = country;
        this.employer = employer;
    }

    public Long getId() {
        return id;
    }

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

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, asList("id"));
    }

    @Override
    public boolean equals(Object obj) {

        return EqualsBuilder.reflectionEquals(this, obj, asList("id"));
    }
}
