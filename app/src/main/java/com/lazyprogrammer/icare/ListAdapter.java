package com.lazyprogrammer.icare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arif on 6/18/15.
 */
public class ListAdapter extends ArrayAdapter<Patient>{


    public ListAdapter(Context context, List<Patient> objects) {
        super(context, 0 , objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list,null);

            holder = new ViewHolder();
            holder.imageView = ((ImageView)convertView.findViewById(R.id.imgViewList));
            holder.txtListName = ((TextView)convertView.findViewById(R.id.txtListName));
            holder.txtListType = ((TextView)convertView.findViewById(R.id.txtListType));

            convertView.setTag(holder);

        }else {
            
            holder = (ViewHolder) convertView.getTag();
        }

        Patient patient = getItem(position);
        holder.imageView.setImageURI(patient.getPatientImage());
        holder.txtListName.setText(patient.getName());
        holder.txtListType.setText(patient.getPatientType());

        return convertView;
    }

    static class ViewHolder{

        public ImageView imageView;
        public TextView txtListName;
        public TextView txtListType;
    }
}
