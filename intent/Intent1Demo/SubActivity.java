package org.techtown.intent1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.exit)
            // finish 후에는 조금전에 호출한 MainActivity
            finish();
    }
}
