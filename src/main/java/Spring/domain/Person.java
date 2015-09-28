package Spring.domain;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;


    @Column(name = "FIRST_NAME")
    private String firstName;


    @Column(name = "LAST_NAME")
    private String lastName;


    @Column(name = "MONEY")
    private Double money;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setMoney(Double money) {
        this.money = money;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public Double getMoney() {
        return money;
    }
}