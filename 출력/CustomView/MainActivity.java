// 원그리기
package org.techtown.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        setContentView(v);
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.LTGRAY);
            Paint p = new Paint();
            p.setColor(Color.BLUE);
            // x, y, 반지름
            canvas.drawCircle(100, 100, 80, p);


        }
    }
}
