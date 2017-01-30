package armellini.ads.it.utahmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton btnContact = (ImageButton)findViewById(R.id.btnContact);
        ImageButton btnHistory = (ImageButton)findViewById(R.id.btnHistory);
        btnContact.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // mi prendo l' oggetto inflater per il menu
        MenuInflater inflater = getMenuInflater();

        // chiamo il metodo inflate che mi fa riprendere il file xml del menu
        inflater.inflate(R.menu.home_menu,menu);

        // si ritorna true perchè android vuole che il tipo di ritorno sia vero per la creazione del menu
        // ( vedi tipo di ritorno del metodo)
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_impostazioni:
                Log.d("ITEM", "IMPOSTAZIONI");
                Util.changeActivity(getApplicationContext(),Activity_Impostazioni.class);
                break;
            case R.id.test:
                Log.d("ITEM","TEST");
                break;
            case R.id.action_franco:
                Log.d("ITEM","Franco");
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnContact:
                Utils.openActivity(this,ContactsActivity.class);
                break;
            case R.id.btnHistory:
                Utils.openActivity(this,HistoryActivity.class);
        }
    }
}

