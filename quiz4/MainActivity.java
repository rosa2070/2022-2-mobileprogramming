package com.example.quiz42;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Circle circle;
    LinearLayout ll;
    int color = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle = new Circle(this);
        ll = findViewById(R.id.ll);
		
		// 필요한 코드 추가
        ll.addView(circle);
        ((RadioGroup)findViewById(R.id.group)).setOnCheckedChangeListener(
                (gp, i) -> {
                    switch (i) {
                        case R.id.red:
                            color = Color.RED;
                            break;
                        case R.id.green:
                            color = Color.GREEN;
                            break;
                        case R.id.blue:
                            color = Color.BLUE;
                            break;
                    }
                    circle.invalidate();


        });
    }

    // Circle 클래스 추가
    class Circle extends View {
        public Circle(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(color);
            canvas.drawCircle(120, 70, 50, p);
        }
    }
}