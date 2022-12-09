package org.techtown.permissiondemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.read)
            readContacts();
        else
            text.setText("초기화");
    }

    void readContacts() {
        //퍼미션 요청
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED)
            showContacts();
        else
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1 &&
                grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED)
            showContacts();
    }

    void showContacts() {
        //아직 안 배운 내용
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(
                ContactsContract.Contacts.CONTENT_URI, null, null,null, null);
        int nameidx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

//                if (cursor.moveToNext()) {
//                    text.setText(cursor.getString(nameidx));
//                } else {
//                    text.setText("주소록이 비어 있습니다.");
//                }
        StringBuilder sb = new StringBuilder();
        while (cursor.moveToNext()) {
            sb.append(cursor.getString(nameidx) + "\n");
        }
        text.setText(sb.toString());
        cursor.close();


    }
}