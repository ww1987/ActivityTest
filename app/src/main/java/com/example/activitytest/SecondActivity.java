package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        final Intent intent = getIntent();
        String data  = intent.getStringExtra("extra_data");
        Button btn2 = (Button) findViewById(R.id.button_2);
        Log.i(TAG, "onCreate: "+data);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("extra_data","Hello FirstActivity");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent();
        intent1.putExtra("extra_data","Hello FirstActivity");
        setResult(RESULT_OK,intent1);
        finish();
    }
}
