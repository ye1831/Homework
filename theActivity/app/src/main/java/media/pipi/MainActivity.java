package com.example.snowcheng.settingactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prefereceFragmentButton = (Button) findViewById(R.id.preferece_fragment_button);
        prefereceFragmentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrefereceFragmentActivity.class);
                startActivity(intent);
            }
        });

    }
}
