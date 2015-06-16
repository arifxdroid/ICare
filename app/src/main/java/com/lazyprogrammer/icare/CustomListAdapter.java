package com.lazyprogrammer.icare;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arif on 6/10/15.
 */
public class CustomListAdapter extends BaseAdapter {

    private ArrayList<Patient> patient;
    Context context;
    private LayoutInflater inflater;

    public CustomListAdapter(Context c, ArrayList patient){

        this.patient = patient;
        this.context = c;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return patient.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout listLayout = (LinearLayout)inflater.inflate(R.layout.custom_list, parent, false);

        ImageView imgViewList = (ImageView)listLayout.findViewById(R.id.imgViewList);
        TextView txtListName = (TextView)listLayout.findViewById(R.id.txtListName);
        TextView txtListType = (TextView)listLayout.findViewById(R.id.txtListType);

        String name = patient.get(position).getName();
        String type = patient.get(position).getPatientType();
        Uri imgUri = patient.get(position).getPatientImage();

        imgViewList.setImageURI(imgUri);
        txtListName.setText(name);
        txtListType.setText(type);

        return listLayout;
    }
}
