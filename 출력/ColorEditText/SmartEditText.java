package org.techtown.coloredittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class SmartEditText extends AppCompatEditText {
    public SmartEditText(@NonNull Context context) {
        super(context);
    }

    public SmartEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SmartEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean b = super.onKeyDown(keyCode, event);
        setBackgroundColor(0xffffff00);
        return b;
    }
}
