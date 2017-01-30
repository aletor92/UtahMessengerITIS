package armellini.ads.it.utahmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    ArrayList<Contact> listContact;
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
        setContentView(R.layout.activity_contacts);

        ListView listViewContacts = (ListView)findViewById(R.id.listViewContacts);


        listContact = new ArrayList<Contact>();
        try {
            JSONArray jsonResponse = new JSONArray(responseFromServer);
            for(int i =0; i< jsonResponse.length();i++){
                JSONObject singleObject = jsonResponse.getJSONObject(i);
                Contact singleContact = new Contact();
                singleContact.setFirstName(singleObject.getString("nome"));
                singleContact.setLastName(singleObject.getString("cognome"));
                singleContact.setEmail(singleObject.getString("email"));
                listContact.add(singleContact);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter myCustomAdapter = new CustomAdapter(this,listContact);
        listViewContacts.setAdapter(myCustomAdapter);
        listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact clickedContact = (Contact) listContact.get(position);
                Toast.makeText(getApplicationContext(),clickedContact.getEmail(),Toast.LENGTH_SHORT).show();
                Util.changeActivity(getApplicationContext(),ChatActivity.class,"contactName",clickedContact.getFirstName() + clickedContact.getLastName());
            }
        });

    }
}
