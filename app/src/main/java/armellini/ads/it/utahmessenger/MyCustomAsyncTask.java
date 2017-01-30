package armellini.ads.it.utahmessenger;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyCustomAsyncTask extends AsyncTask<String, Void, String> {

    String result = "";

    @Override
    protected String doInBackground(String... params) {

        // DEFINIZIONE URL
        String urlSelect = "http://maps.googleapis.com/maps/api/geocode/json?address=via%20del%20corso%20italia";

        try {
            URL url = new URL(urlSelect);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    result += (line + "\n");
                }
                br.close();

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}