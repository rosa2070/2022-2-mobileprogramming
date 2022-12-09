package org.techtown.coloredittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class LavelView extends AppCompatTextView {
    private Paint p;
    public LavelView(@NonNull Context context) {
        super(context);
//        init();
    }

    public LavelView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        init();
    }

    public LavelView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init();
    }

    //모든 생성자에서 사용하는 공통적인 것
//    void init() {
//        p = new Paint();
//        p.setColor(Color.BLACK);
//        p.setAntiAlias(true);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.YELLOW);
        super.onDraw(canvas);
    }
}
