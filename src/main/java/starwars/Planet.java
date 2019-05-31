package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Planet {
    private String planetUrl;

    public Planet(String planetUrl) {
        this.planetUrl = planetUrl;
    }

    public String getPlanetUrl() {
        return planetUrl;
    }

    public void setPlanetUrl(String planetUrl) {
        this.planetUrl = planetUrl;
    }
}
