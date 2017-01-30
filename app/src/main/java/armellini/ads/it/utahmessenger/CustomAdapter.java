package armellini.ads.it.utahmessenger;

import android.content.Context;
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

public class CustomAdapter extends BaseAdapter {

    private List<Contact> contact;
    private Context context;



    public CustomAdapter(Context context, ArrayList<Contact> contact) {
        this.context = context;
        this.contact = contact;
    }


    @Override
    public int getCount() {
        return contact.size();
    }

    @Override
    public Object getItem(int position) {
        return contact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_contact, null);
        }
        Contact singleContact = (Contact) getItem(position);
        TextView labelFullname = (TextView) convertView.findViewById(R.id.labelFullname);
        labelFullname.setText(singleContact.getFirstName() + " " + singleContact.getLastName());
        return convertView;
    }
}

