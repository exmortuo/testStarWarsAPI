package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Planet {
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
    private Integer planetId;

    public Planet() {
    }

    public Planet(String url) {
        this.url = url;
    }

    public List<People> getResidents() {
        ObjectDownloader object = new ObjectDownloader(residents, new People());
        return object.getObjectsListFromRepository();
    }

    public List<String> getResidentsUrls() {
        return residents;
    }

    public List<Film> getFilms() {
        ObjectDownloader object = new ObjectDownloader(films, new Film());
        return object.getObjectsListFromRepository();
    }

    public List<String> getFilmsUrls() {
        return films;
    }

    public void setPlanetId() {
        String[] splitedUrl = this.url.split("/");
        this.planetId = Integer.parseInt(splitedUrl[5]);
    }

    public void setUrl(String url) {
        this.url = url;
        setPlanetId();
    }

    public String toString(){
        return getPlanetId() + " - " + getName();
    }
}
