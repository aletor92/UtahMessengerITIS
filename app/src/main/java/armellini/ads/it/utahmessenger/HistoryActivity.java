package armellini.ads.it.utahmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        MyCustomAsyncTask myCustomAsyncTask = new MyCustomAsyncTask();

        try {
            String response = myCustomAsyncTask.execute().get();
            Log.d("debug", response);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }


}
