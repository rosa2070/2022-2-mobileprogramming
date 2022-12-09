package org.techtown.db0demo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FruitOpenHelper helper = new FruitOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from fruits;", null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, c,
                new String[] {"name", "price"},
                new int[]{android.R.id.text1, android.R.id.text2});
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}