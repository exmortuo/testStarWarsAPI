package starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Vehicle {

    private String url;
    private String name;
    private Integer vehicleId;

    public Vehicle() {
    }

    public Vehicle(String url) {
        this.url = url;
    }

    public Integer getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId() {

        String[] splitedUrl = this.url.split("/");
        this.vehicleId = Integer.parseInt(splitedUrl[5]);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        setVehicleId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){

        return getVehicleId() + " - " + getName();
    }
}
