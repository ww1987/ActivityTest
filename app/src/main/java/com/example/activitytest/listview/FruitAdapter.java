package com.example.activitytest.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.activitytest.R;

import java.util.List;

/**
 * Created by Wa on 2016/12/21.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private static final String TAG = "FruitAdapter";
    private int resourceId;
    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder holder ;
        if(convertView == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            holder.fruitImg = (ImageView) view.findViewById(R.id.fruit_img);
            holder.fruitName =  (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.fruitName.setText(fruit.getName());
        holder.fruitImg.setImageResource(fruit.getImageId());


        return view;
    }

    private class ViewHolder {
        ImageView fruitImg;
        TextView fruitName;
    }
}
