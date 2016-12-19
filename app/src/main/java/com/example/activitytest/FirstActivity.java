package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item :
                Toast.makeText(this,"You cliked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item :
                Toast.makeText(this,"You cliked Remove",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button but1 = (Button) findViewById(R.id.button_1);
        Button btn1_1 = (Button) findViewById(R.id.button_1_1);
        Button btn1_2 = (Button) findViewById(R.id.button_1_2);
        Button btn1_3 = (Button) findViewById(R.id.button_1_3);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"You clicked Button1",Toast.LENGTH_SHORT).show();
                /*显示*/
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data","data");
                startActivity(intent);
                /*隐式*/
/*                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");

                startActivity(intent);*/
                //finish();
            }
        });

        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        btn1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String str = data.getStringExtra("extra_data");
                    Log.d(TAG, "onActivityResult: "+str);
                }
                break;
            default:
        }
    }
}
