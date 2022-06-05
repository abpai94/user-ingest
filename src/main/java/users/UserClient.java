package users;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

public class UserClient {

    private List<User> aUserList;

    public UserClient() {
        this.aUserList = new ArrayList<>();
    }

    /**
     * Creates a {@link HttpClient}, send a {@link HttpRequest} and obtain a {@link HttpResponse}.
     * Convert {@link JSONObject} object to {@link User} object.
     *
     * @return List of Users from the {@link HttpResponse}
     */
    public List<User> request() {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder().GET().uri(new URI("https://reqres.in/api/users")).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray arrayOfUsers = (JSONArray) jsonObject.get("data");
        Iterator<Object> iterator = arrayOfUsers.iterator();
        while (iterator.hasNext()) {
            JSONObject userObject = (JSONObject) iterator.next();
            Map<String, Object> user = userObject.toMap();
            User aUser = new User();
            aUser.setId(String.valueOf((Integer) user.get("id")));
            aUser.setEmail((String) user.get("email"));
            aUser.setFirstName((String) user.get("first_name"));
            aUser.setLastName((String) user.get("last_name"));
            aUserList.add(aUser);
        }
        return aUserList;
    }

    /**
     * Initialize {@link UserClient} object and make a request to obtain {@link User} objects.
     *
     * @param args
     */
    public static void main(String[] args) {
        UserClient aClient = new UserClient();
        aClient.request().stream().forEach(i -> System.out.println(i.getFirstName() + " " + i.getLastName()));
    }
}
