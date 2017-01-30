package armellini.ads.it.utahmessenger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alex on 25/01/17.
 */

public class Activity_Impostazioni extends AppCompatActivity{

    String prefsName = "Name";
    SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        final EditText editTextName = (EditText)findViewById(R.id.editTextNome);
        Button btnSave = (Button)findViewById(R.id.btnSave);


        // 0 corrisponde a modalità privata
        prefs = getSharedPreferences("Name", 0);
        String name = prefs.getString(prefsName, null);
        if(name != null){
            editTextName.setText(name);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName(prefsName,editTextName.getText().toString());
            }
        });
    }


    public void saveName(String key,String value){

        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

}
