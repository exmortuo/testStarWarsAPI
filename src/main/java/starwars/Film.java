package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Film {
    private String url;
    private String title;
    private Integer movieId;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;

    public Film() {

    }

    public Film(String url) {
        this.url = url;
    }

    public void setMovieId() {

        String[] splitedUrl = this.url.split("/");
        this.movieId = Integer.parseInt(splitedUrl[5]);
    }


    public void setUrl(String url) {
        this.url = url;
        setMovieId();
    }


    public List<Vehicle> getVehicles(){
        ObjectDownloader object = new ObjectDownloader(vehicles, new Vehicle());
        return object.getObjectsListFromRepository();
    }

    public List<People> getCharacters() {
        ObjectDownloader object = new ObjectDownloader(characters, new People());
        return object.getObjectsListFromRepository();
    }

    public List<Planet> getPlanets() {
        ObjectDownloader object = new ObjectDownloader(planets, new Planet());
        return object.getObjectsListFromRepository();
    }

    public List<Starship> getStarships() {
        ObjectDownloader object = new ObjectDownloader(starships, new Starship());
        return object.getObjectsListFromRepository();
    }

    public List<Species> getSpecies() {
        ObjectDownloader object = new ObjectDownloader(species, new Species());
        return object.getObjectsListFromRepository();
    }

    public String toString() {
        return getMovieId() + " - " + getTitle();
    }
}
