package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Film {
    private String url;
    private String title;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;
    private List<Planet> planets;
    private List<Starship> starships;
    private List<Vehicle> vehicles;
    private List<Species> species;
    private String created;
    private String edited;

    public Film() {

    }

    public Film(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    public List<Vehicle> getVehicles() {
        if(this.vehicles == null){
            return new LinkedList<Vehicle>();
        }
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;

        List<Vehicle> tmpvehicleList = new LinkedList();
        ObjectDownloader object;

        for (Vehicle vehicle : vehicles) {

            object = new ObjectDownloader(vehicle.getUrl(), vehicle);
            vehicle = (Vehicle) object.getObjectFromRepository();
            tmpvehicleList.add(vehicle);
        }

        this.vehicles = tmpvehicleList;
    }

    public List<Starship> getStarships() {
        return starships;
    }

    public void setStarships(List<Starship> starships) {
        this.starships = starships;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public String getFilm() {
        return url;
    }

    public void setFilm(String filmUrl) {
        this.url = filmUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String toString() {
        return title;
    }
}
