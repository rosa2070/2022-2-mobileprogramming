package org.techtown.intent2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class SubActivity extends AppCompatActivity {
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        RadioGroup rg = findViewById(R.id.group);
        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i) {
                case R.id.red:
                    color = Color.RED;
                    break;
                case R.id.green:
                    color = Color.GREEN;
                    break;
                case R.id.blue:
                    color = Color.BLUE;
            }

        });
    }

    public void onClick(View view) {
        Intent intent = new Intent();
//        intent.putExtra("color", color);
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}