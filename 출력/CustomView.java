// 원그리기
package org.techtown.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class CustomView extends AppCompatActivity {

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
        protected void onDraw(Canvas canvas) {
            //onDraw 재정의
            super.onDraw(canvas);
            canvas.drawColor(Color.LTGRAY);
            //Paint는 붓을 의미
            Paint p = new Paint();
            p.setColor(Color.BLUE);
            canvas.drawCircle(100, 100, 80, p);


        }
    }
}