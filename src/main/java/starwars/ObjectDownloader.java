package starwars;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

public class ObjectDownloader<T> {

    private Class<T> objectClass;
    private String url;
    private List<String> urlList;

    private static OkHttpClient client = new OkHttpClient();
    private static Request request;
    private static Response response;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public ObjectDownloader(String url, T objectToGet) {
        this.url = url;
        this.objectClass = (Class<T>) objectToGet.getClass();
    }


    public ObjectDownloader(List<String> urlList, T objectToGet) {
        this.urlList = urlList;
        this.objectClass = (Class<T>) objectToGet.getClass();
    }

    public T getObjectFromRepository() {
        T objectFromStarWarsDatabase;

        request = new Request.Builder().url(url).build();

        try {
            response = client.newCall(request).execute();
            objectFromStarWarsDatabase = objectMapper.readValue(response.body().string(), objectClass);

            if (response.code() == 404) {
                return objectClass.newInstance();
            }
            return objectFromStarWarsDatabase;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        objectFromStarWarsDatabase = null;
        return objectFromStarWarsDatabase;
    }

    public List<T> getObjectsListFromRepository() {
        T objectFromStarWarsDatabase;
        List<T> objectsList = new LinkedList<T>();

        for (String url: urlList) {

            request = new Request.Builder().url(url).build();

            try {
                response = client.newCall(request).execute();

                objectFromStarWarsDatabase = objectMapper.readValue(response.body().string(), objectClass);

                if (response.code() == 404) {
                    return objectsList;
                }

                objectsList.add(objectFromStarWarsDatabase);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return objectsList;
    }
}
