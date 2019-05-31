package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Starship {

    private String starship;

    public Starship(String starship) {
        this.starship = starship;
    }

    public String getStarship() {
        return starship;
    }

    public void setStarship(String starship) {
        this.starship = starship;
    }
}
