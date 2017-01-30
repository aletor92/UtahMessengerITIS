package armellini.ads.it.utahmessenger;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        String contactName = getIntent().getExtras().getString("contactName");
        Toast.makeText(getApplicationContext(),contactName,Toast.LENGTH_SHORT).show();

        final ListView listViewMessages = (ListView)findViewById(R.id.listViewMessages);
        Button btnSend = (Button)findViewById(R.id.btnSend);
        final EditText editTextMessage = (EditText)findViewById(R.id.editTextMessage);


        File sdcard = Environment.getExternalStorageDirectory();
        File storagePath = new File(sdcard.getAbsolutePath() + "/utahMessenger");

        storagePath.mkdirs();

        final File chat = new File(storagePath + "/" + contactName);
        if(!chat.exists()){
            try {
                chat.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList rowChat = new ArrayList();
        FileReader fileReader = null;
        BufferedReader bufferedReader= null;
        try {
            fileReader = new FileReader(chat);
            bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                rowChat.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (Exception e) {

            }
        }

        final MessageAdapter customAdapter = new MessageAdapter(getApplicationContext(),rowChat);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileWriter fileWriter = null;
                if(!chat.exists()){
                    try {
                        chat.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileWriter = new FileWriter(chat,true);
                    fileWriter.write(editTextMessage.getText().toString()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try{
                        fileWriter.close();
                    }catch(Exception e){

                    }

                }
            }
        });
        listViewMessages.setAdapter(customAdapter);

    }
}
