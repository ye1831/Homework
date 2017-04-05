package com.example.snowcheng.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class XmlActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        textView = (TextView) findViewById(R.id.xml_test_textview);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.text_size_small_item:
                textView.setTextSize(10*2);
                break;
            case R.id.text_size_middle_item:
                textView.setTextSize(16*2);
                break;
            case R.id.text_size_big_item:
                textView.setTextSize(20*2);
                break;
            case R.id.normal_menu_item:
                Toast.makeText(this, "这是普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_color_red_item:
                textView.setTextColor(Color.RED);
                break;
            case R.id.text_color_black_item:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return true;
    }
}
