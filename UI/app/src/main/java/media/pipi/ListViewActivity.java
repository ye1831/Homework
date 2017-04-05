package com.example.snowcheng.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.simpleadapter, new String[]{"name", "head"}, new int[]{R.id.name, R.id.head});

        ListView listView = (ListView) findViewById(R.id.list_view_layout);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), getData().get(i).get("name").toString(), Toast.LENGTH_SHORT).show();//show the selected image in toast according to position
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Lion");
        map.put("head", R.drawable.lion);
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Tiger");
        map.put("head", R.drawable.tiger);
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Monkey");
        map.put("head", R.drawable.monkey);
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Dog");
        map.put("head", R.drawable.dog);
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Cat");
        map.put("head", R.drawable.cat);
        lists.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Elephant");
        map.put("head", R.drawable.elephant);
        lists.add(map);

        return lists;
    }
}
