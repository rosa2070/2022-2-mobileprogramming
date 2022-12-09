package org.techtown.listview1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    EditText edit;
    List<String> data;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        edit = findViewById(R.id.edit);
        data = new ArrayList<>();
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
//        list.setOnItemClickListener(listener);
    }

    public void onClick(View v) {
        data.add(edit.getText().toString());
        edit.setText("");
        adapter.notifyDataSetChanged();

    }

//    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            String s = "clicked item = " + data[i];
//            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//        }
//    };

}