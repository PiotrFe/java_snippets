import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class NetworkingHttpDemo {
    public static void main(String[] args)  {
        HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
        HttpRequest httpRequest = null;
        HttpResponse<InputStream> httpResponse = null;
        
        try {
            httpRequest = HttpRequest.newBuilder(new URI("http://google.com/")).build();
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
        } catch (URISyntaxException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        if (httpRequest == null || httpResponse == null) {
            return;
        }

        System.out.println("Response code: " + httpResponse.statusCode());
        System.out.println("Request method: " + httpRequest.method());
   
        HttpHeaders headers = httpResponse.headers();

        Map<String, List<String>> headerMap = headers.map();
        Set<String> headerFields = headerMap.keySet();

        for (String k : headerFields) {
            System.out.println("Key: " + k + ", val: " + headerMap.get(k));
        }

        System.out.println("Body: ");
        InputStream body = httpResponse.body();

        int c;

        try {
            while ((c = body.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

  
        
    }
}
