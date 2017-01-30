package armellini.ads.it.utahmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

public class ParseActivity extends AppCompatActivity {

    private String responseFromServer = "[\n" +
            "    {\n" +
            "        \"nome\":\"Pippo\",\n" +
            "        \"cognome\":\"Pappa\",\n" +
            "        \"email\":\"pippo.pappa@itis.it\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"nome\":\"Ciccio\",\n" +
            "        \"cognome\":\"Pasticcio\",\n" +
            "        \"email\":\"ciccio.pasticcio@itis.it\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"nome\":\"Franco\",\n" +
            "        \"cognome\":\"franchi\",\n" +
            "        \"email\":\"franco.franchi@itis.it\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"nome\":\"Michele\",\n" +
            "        \"cognome\":\"de michele\",\n" +
            "        \"email\":\"michele.michela@itis.it\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"nome\":\"Giorgio\",\n" +
            "        \"cognome\":\"de Giorgis\",\n" +
            "        \"email\":\"giorgio.degiorgis@itis.it\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"nome\":\"Alessandro\",\n" +
            "        \"cognome\":\"Alessi\",\n" +
            "        \"email\":\"alessandro.alessi@itis.it\"\n" +
            "    }\n" +
            " ]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse);
        try {
            JSONArray me = new JSONArray(responseFromServer);
           for(int i = 0;i < me.length(); i++){
               String nome = me.getJSONObject(i).getString("nome");
               Toast.makeText(getApplicationContext(),nome,Toast.LENGTH_LONG).show();
           }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
