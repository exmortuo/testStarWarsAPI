package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Species {
    private Integer speciesId;
    private String name;
    private String classification;
    private String designation;
    private Integer average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private Integer average_lifespan;
    private String homeworld;
    private String language;
    private List<String> people;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    public Species(){
    }

    public void setSpeciesId() {
        String[] splitedUrl = this.url.split("/");
        this.speciesId = Integer.parseInt(splitedUrl[5]);
    }

    public Species(String url) {
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
        setSpeciesId();
    }

    public List<People> getPeople() {
        ObjectDownloader object = new ObjectDownloader(people, new People());
        return object.getObjectsListFromRepository();
    }


    public List<Film> getFilms() {
        ObjectDownloader object = new ObjectDownloader(films, new Film());
        return object.getObjectsListFromRepository();
    }

}
