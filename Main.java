import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
//import org.json.JSONObject;



class CLIStockRetriever {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to the CLI Stock Retriever");

        while (true){
            Scanner ticker = new Scanner(System.in);
            System.out.print("What ticker would like info on? (Enter 'EXIT' to stop): ");
            String info = ticker.nextLine();
            if(info.equals("EXIT")){
                System.out.print("Goodbye!");
                System.exit(0);
            }

            String url = String.format("https://alpha-vantage.p.rapidapi.com/query?interval=5min&function=TIME_SERIES_INTRADAY&symbol=%s&datatype=json&output_size=compact", info);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("X-RapidAPI-Key", "2ccc7188camsh18158cd983ad020p1002b0jsn75cd7c208eab")
                    .header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            //Could not get the Json.JSONOBEJECT to import so I could not get the JSON file to parse properly. The code below is if it did.
            //JSONObject obj = new JSONObject(str);
            //String firstItem = obj.getJSONObject("Time Series (5min)").getJSONObject(0);
            //System.out.println(firstItem);
        }
        }
}
