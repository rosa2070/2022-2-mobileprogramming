package org.techtown.db1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    ListView list;
    MemoOpenHelper helper;
    SimpleCursorAdapter sa;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        list = findViewById(R.id.listview);
        helper = new MemoOpenHelper(this);
        db = helper.getReadableDatabase();
        cursor = db.query("memos", new String[]{"_id", "memo"},
                null, null, null, null, null);
//        db2ds();
        sa = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"memo"},
                new int[]{android.R.id.text1},
                0);
        list.setAdapter(sa);
        setEnabled(sa.getCount() > 0);
    }

    public void onClick(View v) {
        db = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.add:
                String str = edit.getText().toString();
                if (str.length() != 0) {
                    ContentValues values = new ContentValues();
                    values.put("memo", str);
                    long id = db.insert("memos", null, values);
                }
                break;
            case R.id.del:
                if (sa.getCount() > 0) {
//                    cursor = (Cursor)sa.getItem(0);
                    cursor = sa.getCursor();
                    cursor.moveToFirst();
                    db.delete("memos", "_id=" + cursor.getLong(0), null);
                    cursor.close();
                }
        }
        cursor = db.query("memos", new String[]{"_id", "memo"},
                null, null, null, null, null);
        sa.changeCursor(cursor);
        sa.notifyDataSetChanged();
        edit.setText("");
        setEnabled(sa.getCount() > 0);
    }

    void setEnabled(boolean enabled) {
        ((Button) findViewById(R.id.del)).setEnabled(enabled);
    }


}