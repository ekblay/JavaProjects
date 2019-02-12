import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;



/**
 This program demonstrates how to use a URL connection
 to communicate with a web server. Supply the URL on the
 command line, for example
 java URLGet http://horstmann.com/index.html
 */
public class HttpReader
{
    String mUrlString;
    URLConnection mConnection;
    public  HttpReader(String address) throws IOException {
        mUrlString = address;
        //String urlString = "http://jservice.io/api/categories?count=1&offset=312";
        createConnection();
    }

    public void createConnection() throws IOException {
        // Open connection

        URL u = new URL(mUrlString);
        mConnection = u.openConnection();

        // Check if response code is HTTP_OK (200)

        HttpURLConnection httpConnection
                = (HttpURLConnection) mConnection;
        int code = httpConnection.getResponseCode();
        String message = httpConnection.getResponseMessage();
        //   System.out.println(code + " " + message);
        if (code != HttpURLConnection.HTTP_OK) {
            return;
        }
    }

        // Read server response
        public String getLine() throws IOException {
        InputStream instream = mConnection.getInputStream();
        Scanner in = new Scanner(instream);
            String input = "";
            while (in.hasNextLine())
            {input = input + in.nextLine(); }

            return  input;
    }

}


