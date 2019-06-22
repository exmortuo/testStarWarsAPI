package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Starship {
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    private String MGLT;
    private String starship_class;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
    private Integer starshipId;

    public Starship() {
    }

    public Starship(String url) {
        this.url = url;
    }

    public void setPlanetId() {
        String[] splitedUrl = this.url.split("/");
        this.starshipId = Integer.parseInt(splitedUrl[5]);
    }

    public void setUrl(String url) {
        this.url = url;
        setPlanetId();
    }

    public List<People> getPilots() {
        ObjectDownloader object = new ObjectDownloader(pilots, new People());
        return object.getObjectsListFromRepository();
    }

    public List<Film> getFilms() {
        ObjectDownloader object = new ObjectDownloader(films, new Film());
        return object.getObjectsListFromRepository();
    }

    public String toString() {
        return getStarshipId() + " - " + getName();
    }
}
