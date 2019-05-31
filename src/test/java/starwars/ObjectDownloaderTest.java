package starwars;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ObjectDownloaderTest {

    @Test
    public void getObjectFromRepository() {

        People people = new People();
        ObjectDownloader object = new ObjectDownloader("https://swapi.co/api/people/11/",people);
        people = (People) object.getObjectFromRepository();


        List<Film> filmy = new LinkedList();
        List<Film> tmpFilmsList = new LinkedList();

        for (Film film: people.getFilms()) {

            object = new ObjectDownloader(film.getUrl(), film);
            film = (Film) object.getObjectFromRepository();
            tmpFilmsList.add(film);
        }

        people.setFilms(tmpFilmsList);

        int t=1;
    }
}