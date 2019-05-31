package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class People {
    // almost all params is String because You can get from swapi data which type is number or string
    // in Your code You must (or not, if it's string) parse this params to number
    private long id;
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;

    private List<Film> films;
    private List<Species> species;
    private List<Vehicle> vehicles;
    private List<Starship> starships;

    private String created;
    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<Film> getFilms() {
        if(this.films == null) { ;
            return new LinkedList<Film>();
        }
        return films;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFilms(List<Film> films) {

        List<Film> tmpFilmsList = new LinkedList();
        ObjectDownloader object;

        for (Film film : films) {

            object = new ObjectDownloader(film.getUrl(), film);
            film = (Film) object.getObjectFromRepository();
            tmpFilmsList.add(film);
        }

        this.films = tmpFilmsList;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        //this.vehicles = vehicles;

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

    public String toString() {
        String returnValue = "name: " + getName()
                + "\nheight: " + getHeight()
                + "\nmass: " + getMass()
                + "\nhair color: " + getHair_color()
                + "\nskin color: " + getSkin_color()
                + "\neye color: " + getEye_color()
                + "\nbirth hear: " + getBirth_year()
                + "\ngender: " + getGender();

        return returnValue;
    }
}
