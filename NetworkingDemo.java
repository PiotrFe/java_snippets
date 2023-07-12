import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkingDemo {
    public static void main(String[] args) {

        // InetAddress
        try {
            InetAddress Address = InetAddress.getLocalHost();
            System.out.println(Address);

            Address = InetAddress.getByName("www.HerbSchildt.com");
            System.out.println(Address);

            InetAddress[] NBA = InetAddress.getAllByName("www.nba.com");

            for (int i = 0; i < NBA.length; i++) {
                System.out.println(NBA[i]);
            }
        } catch (UnknownHostException e) {
            System.out.println(e);
        }

        // Socket

        try {
            int c;

            // Create asocket
            Socket socket = new Socket("whois.internic.net", 43);

            // Obtain input and output streams
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Construct a request string
            String str = "MHPProfessional.com";

            // Convert to bytes
            byte[] buf = str.getBytes();

            // Send request
            out.write(buf);

            // Read and display a response
            while((c = in.read()) != -1) {
                System.out.print((char) c);
            }

            socket.close();

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        // URL

        try {
            URL url = new URL("http://google.com:80/");
            HttpURLConnection urlC = (HttpURLConnection) url.openConnection();

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Port: " + url.getPort());
            System.out.println("Ext: " + url.toExternalForm());

            System.out.println("Connection date: " + urlC.getDate());
            System.out.println("Content-Type: " + urlC.getContentType());
            System.out.println("Last-Modified: " + urlC.getLastModified());
            System.out.println("Content-Length: " + urlC.getContentLengthLong());

            InputStream googleStream = urlC.getInputStream();

            int c;

            while ((c = googleStream.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
            System.out.println("Request method: " + urlC.getRequestMethod());
            System.out.println("Response code: " + urlC.getResponseCode());
            System.out.println("Response message: " + urlC.getResponseMessage());

            Map<String, List<String>> headerMap = urlC.getHeaderFields();
            Set<String> headerFields = headerMap.keySet();
        
            
            System.out.println("Headers:");
            for (String k : headerFields) {
                System.out.println("Key: " + k + ", val: " + headerMap.get(k));
            }

            
            googleStream.close();
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }


    }
}