package com.example.snowcheng.ui;

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

        Button listViewButton = (Button) findViewById(R.id.list_view_button);
        listViewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        Button alertDialogButton = (Button) findViewById(R.id.alert_dialog_button);
        alertDialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                startActivity(intent);
            }
        });

        Button xmlButton = (Button) findViewById(R.id.xml_button);
        xmlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XmlActivity.class);
                startActivity(intent);
            }
        });

        Button actionModeButton = (Button) findViewById(R.id.action_mode_button);
        actionModeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActionModeActivity.class);
                startActivity(intent);
            }
        });
    }
}
