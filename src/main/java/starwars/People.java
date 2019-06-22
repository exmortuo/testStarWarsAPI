package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class People {
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

    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;

    private String created;
    private String edited;
    private String url;


    public List<Film> getFilms() {
        ObjectDownloader object = new ObjectDownloader(films, new Film());
        return object.getObjectsListFromRepository();
    }



    public List<Species> getSpecies() {
        ObjectDownloader object = new ObjectDownloader(species, new Species());
        return object.getObjectsListFromRepository();
    }

    public List<Vehicle> getVehicles(){
        ObjectDownloader object = new ObjectDownloader(vehicles, new Vehicle());
        return object.getObjectsListFromRepository();
    }

    public List<Starship> getStarships() {
        ObjectDownloader object = new ObjectDownloader(starships, new Starship());
        return object.getObjectsListFromRepository();
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
