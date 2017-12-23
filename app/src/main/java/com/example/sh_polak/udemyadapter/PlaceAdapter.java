package com.example.sh_polak.udemyadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sh-polak on 16/08/2017.
 */

public class PlaceAdapter extends ArrayAdapter{
    Context mContext;
    int mLayoutResourceId;
    Games mdate[]=null;

    public PlaceAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Games[] objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mLayoutResourceId=resource;
        this.mdate=objects;
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        GameHolder gameHolder=null;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        row=inflater.inflate(mLayoutResourceId,parent,false);
        TextView nameView=(TextView) row.findViewById(R.id.text);
        TextView zipcode=(TextView) row.findViewById(R.id.zipcode);
        ImageView image=(ImageView) row.findViewById(R.id.imagees);
        Games game=mdate[position];
        nameView.setText(game.mNameOfPlace);
        zipcode.setText(String.valueOf(game.mZipCode));
       int resId= mContext.getResources().getIdentifier(game.getmNameOfImage,"drawable",mContext.getPackageName());
        image.setImageResource(resId);
        return row;
    }
   private static class GameHolder{
       TextView nameView;
       TextView zipView;
       ImageView imageView;
   }
}
