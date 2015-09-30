package mongodb.DAO;

public class VacancyDAO {

    private String title;
    private String description;
    private String salary;
    private String city;
    private String counrtry;
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

    public String getCounrtry() {
        return counrtry;
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

    public void setCounrtry(String counrtry) {
        this.counrtry = counrtry;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
}
