package org.techtown.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Type;

public class Canvas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        setContentView(v);
    }

    class MyView extends View {
        //MyView 생성자 정의
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas c) {
            //onDraw 재정의
            super.onDraw(c);
            c.drawColor(Color.WHITE);
            //Paint는 붓을 의미
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            //x, y
            c.drawPoint(10, 50, p);
            c.drawPoint(15, 50, p);
            p.setColor(Color.GREEN);
            p.setAlpha(0x80);
            p.setAntiAlias(true);
            //left, top, right, bottom
            c.drawRect(30, 100, 200, 200, p);
            p.setColor(Color.BLACK);
            Typeface tf = Typeface.create(Typeface.SANS_SERIF,
                    Typeface.BOLD_ITALIC);
            p.setTypeface(tf);
            p.setTextSize(20);
            //text, x, y
            c.drawText("Hi, Android", 20, 30, p);
            tf = Typeface.create(Typeface.SERIF,
                    Typeface.BOLD_ITALIC);
            p.setTypeface(tf);
            c.drawText("Hi, Android", 20, 60, p);

            //글씨체 삐친게 serif, 안 삐친게 sans_serif



        }
    }
}