package org.techtown.coloredittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String[] codes = new String[]{
            "Apple", "Banana", "Cupcake", "Donut", "Eclair", "Froyo"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.list1);
        lv.setAdapter(new ArrayAdapter<String>(this,
                R.layout.row, codes));
    }

    AdapterView.OnItemClickListener listener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> list, View view, int position, long id) {
                    String s = "Select Item = " + codes[position];
                    Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();

                }
            };


}