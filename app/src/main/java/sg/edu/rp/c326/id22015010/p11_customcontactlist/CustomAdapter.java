package sg.edu.rp.c326.id22015010.p11_customcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Contact> {
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(String.valueOf(currentItem.getPhoneNum()));

        // Set gender icon based on gender value ('M' for male, 'F' for female)
        if (currentItem.getGender() == 'M') {
            ivGender.setImageResource(R.drawable.male);
            ivGender.setVisibility(View.VISIBLE); // Show the ImageView for male
        } else if (currentItem.getGender() == 'F') {
            ivGender.setImageResource(R.drawable.female);
            ivGender.setVisibility(View.VISIBLE); // Show the ImageView for female
        } else {
            ivGender.setVisibility(View.GONE); // Hide the ImageView for unknown gender
        }

        return rowView;
    }
}
