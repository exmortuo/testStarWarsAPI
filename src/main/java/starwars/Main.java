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
    }

}
