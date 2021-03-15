package connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCaller {
    static String starWarsUrl = "https://swapi.dev/api/people/?page=";
    static HttpURLConnection connection = null;

    public static String getAllStarWarsCharactersFromPage(int pageNumber){
        try {
            String tempPg = starWarsUrl + String.valueOf(pageNumber);
            connection = (HttpURLConnection) new URL(tempPg).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();

            if(responseCode == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (connection.getInputStream())));

                String output;
                StringBuilder response = new StringBuilder();
                while ((output = br.readLine()) != null) {
                    response.append(output);
                }

                connection.disconnect();

                return response.toString();
            }else{
                return "";
            }

        } catch (Exception error) {
            System.out.println("Wasn't enable to establish connection with api");
        }

        return null;
    }
}
