package armellini.ads.it.utahmessenger;

import android.app.Activity;
import android.content.Intent;

import java.util.Map;
import java.util.Set;

public class Utils {

    /**
     * Metodo per aprire una activity specificando la classe dell'activity che si vuole aprire
     * senza passargli parametri
     */
    public static void openActivity(Activity context, Class activityClass){
        Intent intent = new Intent();
        intent.setClass(context, activityClass);
        context.startActivity(intent);
    }

    /**
     * Metodo per aprire una activity specificando la classe dell'activity che si vuole aprire
     * passandogli dei parametri stringa:stringa -> name:value come extras
     */
    public static void openActivity(Activity context, Class activityClass, Map<String,String> extras){
        Intent intent = new Intent();
        intent.setClass(context, activityClass);

        //recupero da una mappa java l'insieme delle chiavi
        Set<String> names = extras.keySet();

        //itero sull'insieme delle chiavi per ruceperare dalla mappa il valore associato
        // e inserisco nell'intent dell'activity un extra dove la chiave è il nome
        for (String name:names) {
            String value = extras.get(name);
            intent.putExtra(name, value);
        }

        context.startActivity(intent);
    }
}
