package armellini.ads.it.utahmessenger;

import android.content.Context;
import android.content.Intent;

/**
 * Created by alex on 25/01/17.
 */

public class Util {

    public static void changeActivity(Context source,Class destination,String key,String string){
        Intent intent = new Intent(source,destination);
        intent.putExtra(key, string);
        source.startActivity(intent);
    }

    public static void changeActivity(Context source,Class destination){
        Intent intent = new Intent(source,destination);
        source.startActivity(intent);
    }
}
