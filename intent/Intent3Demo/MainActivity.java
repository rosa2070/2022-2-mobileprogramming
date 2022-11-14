package org.techtown.intent3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.call) {
            i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:01011112222"));
        } else
            i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.google.com"));
        startActivity(i);
    }
}