package springed.components;

/**
 * Created by v.pozdeev on 16.11.2015.
 */
public class SearchParameters {

    private String title;
    private String country;
    private Long id;

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
