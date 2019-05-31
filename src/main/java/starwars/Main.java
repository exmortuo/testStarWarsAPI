package starwars;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static OkHttpClient client = new OkHttpClient();
    private static Request request;
    private static Response response;
    private static People people;

    private static ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String... args) {

        Scanner readFromConsole = new Scanner(System.in);

        System.out.print("Podaj proszę id osoby: ");

        int peopleId = readFromConsole.nextInt();

        String url = "https://swapi.co/api/people/" + peopleId;

        People people = new People();
        ObjectDownloader object = new ObjectDownloader(url, people);
        people = (People) object.getObjectFromRepository();


        List<Film> tmpFilmsList = new LinkedList();

        for (Film film : people.getFilms()) {

            object = new ObjectDownloader(film.getUrl(), film);
            film = (Film) object.getObjectFromRepository();
            tmpFilmsList.add(film);
        }

        people.setFilms(tmpFilmsList);

        System.out.println(people.toString());


        List<Vehicle> tmpVehicleList = new LinkedList();
        for(Vehicle vehicle: people.getVehicles())
        {
            object = new ObjectDownloader(vehicle.getUrl(), vehicle);
            vehicle = (Vehicle) object.getObjectFromRepository();
            tmpVehicleList.add(vehicle);
        }
        people.setVehicles(tmpVehicleList);


        tmpVehicleList = new LinkedList();
        for (Film film : people.getFilms()) {
            for (Vehicle vehicle : film.getVehicles()) {
                object = new ObjectDownloader(vehicle.getUrl(), vehicle);
                vehicle = (Vehicle) object.getObjectFromRepository();

                tmpVehicleList.add(vehicle);
            }
            film.setVehicles(tmpVehicleList);
            tmpVehicleList = new LinkedList();
        }

        System.out.println("\n\nMovies in which this actor played: \n");
        for (Film film: people.getFilms()) {
            System.out.println("\tMovie: " + film.getTitle());

            System.out.println("\n\t\tVehicles from this movie: ");
            for (Vehicle vehicle : film.getVehicles()) {
                System.out.println("\t\t\t"+vehicle.toString());
            }
            System.out.println("\n");
        }
    }

}
