package org.techtown.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class Canvas3 extends AppCompatActivity {
    Path path1, path; Paint p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        setContentView(v);
        path = new Path();
        path1 = new Path();
        path1.addRect(50,50,150,150,, Path.Direction.CW);
        p = new Paint();
    }

    class MyView extends View {
        //MyView 생성자 정의
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas c) {
          super.onDraw(c);
          c.drawColor(Color.WHITE);
          p.setStrokeWidth(5);
          p.setColor(Color.RED);
          p.setStyle(Paint.Style.STROKE);
          c.drawPath(path1, p);

          path.reset();
          p.setColor(Color.BLUE);
          //x, y, radius
          path.addCircle(100, 100, 40, Path.Direction.CW);
          c.drawPath(path, p);

          path.reset();
          //왼쪽 대각선 x,y
          path.moveTo(10, 100);
          path.lineTo(50, 150);
          //오른쪽 대각선 x,y
          path.moveTo(150, 150);
          path.rLineTo(50, -50);
          p.setStrokeWidth(3);
          p.setAntiAlias(true);
          c.drawPath(path, p);



        }
    }
}