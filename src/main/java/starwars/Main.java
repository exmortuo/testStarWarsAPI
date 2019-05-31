package starwars;

import java.util.Scanner;


public class Main {
    public static void main(String... args) {

        Scanner readFromConsole = new Scanner(System.in);

        System.out.print("Podaj proszę id osoby: ");

        int peopleId = readFromConsole.nextInt();

        String url = "https://swapi.co/api/people/" + peopleId;

        People people = new People();
        ObjectDownloader object = new ObjectDownloader(url, people);
        people = (People) object.getObjectFromRepository();


        System.out.println(people.toString());


        System.out.println("\n\nMovies in which this actor played: \n");
        for (Film film: people.getFilms()) {
            System.out.println("\tMovie: " + film.getTitle());

            System.out.println("\n\t\tVehicles from this movie: ");
            for (Vehicle vehicle : film.getVehicles()) {
                System.out.println("\t\t\t"+vehicle.toString());
            }
            System.out.println("\n");
        }

        System.out.print("\n\nPodaj proszę ID filmu: ");
        int movieId = readFromConsole.nextInt();

        Film movie = new Film();
        object = new ObjectDownloader("https://swapi.co/api/films/"+movieId+"/", movie);
        movie = (Film) object.getObjectFromRepository();

        System.out.println("Movie title: " + movie.getTitle());
        System.out.println("\n\tVehicles from this movie: ");
        for(Vehicle vehicle: movie.getVehicles()) {
            System.out.println("\t\t"+vehicle.toString());
        }
    }

}
