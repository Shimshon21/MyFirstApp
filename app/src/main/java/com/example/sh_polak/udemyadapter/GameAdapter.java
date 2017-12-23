package com.example.sh_polak.udemyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by sh-polak on 17/08/2017.
 */

public class GameAdapter extends BaseAdapter {
    private final String[] data;
    private final Context context;

    GameAdapter(String[]data, Context context){
        this.data=data;
        this.context=context;

    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public String getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        ((TextView)view).setText(getItem(i));
        return view;
    }

}
