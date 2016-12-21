package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.activitytest.listview.Fruit;
import com.example.activitytest.listview.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList  = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initFruit();
        ListView listView = (ListView) findViewById(R.id.lv_listview);
        FruitAdapter aa = new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(ListViewActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        for(int i=0;i<10;i++){
            Fruit apple = new Fruit("Apple",R.mipmap.ic_launcher);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.mipmap.ic_launcher);
            fruitList.add(banana);
        }
    }
}
