package org.techtown.listview1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new String[]{"apple", "banana", "cupcake", "donut", "eclair"};
        ListView list = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String s = "clicked item = " + data[i];
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    };

}