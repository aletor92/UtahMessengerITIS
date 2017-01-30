package armellini.ads.it.utahmessenger;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 24/01/17.
 */

public class MessageAdapter extends BaseAdapter {

    private List messages;
    private Context context;



    public MessageAdapter(Context context, ArrayList messages) {
        this.context = context;
        this.messages = messages;
    }


    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_message, null);
        }
        TextView labelFullname = (TextView) convertView.findViewById(R.id.textViewMessage);
        Log.d("DEBUG",messages.get(position).toString());

        labelFullname.setText(messages.get(position).toString());
        return convertView;
    }
}

