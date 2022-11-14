package org.techtown.db1demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MemoOpenHelper extends SQLiteOpenHelper {
    public MemoOpenHelper(@Nullable Context context) {
        super(context, "memos.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table memos (" +
                "_id integer primary key autoincrement, " +
                "memo text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists memos;");
        onCreate(db);
    }
}
