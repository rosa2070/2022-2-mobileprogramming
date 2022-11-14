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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    ListView list;
    MemoOpenHelper helper;
    List<Memo> ds;
    ArrayAdapter<Memo> aa;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        list = findViewById(R.id.listview);
        helper = new MemoOpenHelper(this);
        ds = new ArrayList<>();
        db2ds();
        aa = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ds);
        list.setAdapter(aa);
        setEnabled(ds.size() > 0);



    }

    public void onClick(View v) {
        Memo memo;
        db = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.add:
                String str = edit.getText().toString();
                if (str.length() != 0) {
                    ContentValues values = new ContentValues();
                    values.put("memo", str);
                    long id = db.insert("memos", null, values);
                    memo = new Memo(id, str);
                    ds.add(memo);
                }
                break;
            case R.id.del:
                if (ds.size() >0) {
                    memo = ds.get(0);
                    db.delete("memos", "_id=" + memo.getId(), null);
                    ds.remove(0);
                }
        }
        aa.notifyDataSetChanged();
        edit.setText("");
        setEnabled(ds.size() > 0);
    }

    void db2ds() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("memos", new String[]{"_id", "memo"},
                null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            Memo memo = new Memo(c.getLong(0), c.getString(1));
            ds.add(memo);
            c.moveToNext();
        }
        c.close();
        helper.close();
        db.close();
    }

    void setEnabled(boolean enabled) {
        ((Button)findViewById(R.id.del)).setEnabled(enabled);
    }
}