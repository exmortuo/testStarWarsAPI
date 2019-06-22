package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Vehicle {

    private String url;
    private String name;
    private Integer vehicleId;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;


    public Vehicle() {
    }

    public Vehicle(String url) {
        this.url = url;
    }

    public void setVehicleId() {

        String[] splitedUrl = this.url.split("/");
        this.vehicleId = Integer.parseInt(splitedUrl[5]);
    }

    public List<People> getPilots() {
        ObjectDownloader object = new ObjectDownloader(pilots, new People());
        return object.getObjectsListFromRepository();
    }

    public List<Film> getFilms() {
        ObjectDownloader object = new ObjectDownloader(films, new Film());
        return object.getObjectsListFromRepository();
    }

    public void setUrl(String url) {
        this.url = url;
        setVehicleId();
    }

    public String toString() {

        return getVehicleId() + " - " + getName();
    }
}
