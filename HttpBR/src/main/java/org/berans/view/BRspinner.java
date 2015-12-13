package org.berans.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Spinner;

public class BRspinner extends Spinner {

    public String  fontsPath = "fonts/";
    public String  font      = "iransans";
    public Context context;

    public BRspinner(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BRspinner(Context context, int mode) {
        super(context, mode);
    }

    public BRspinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BRspinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BRspinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BRspinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode) {
        super(context, attrs, defStyleAttr, defStyleRes, mode);
    }

    public void initialize(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray attrFontName = getContext().obtainStyledAttributes(attrs, R.styleable.app);
        String fontName = attrFontName.getString(R.styleable.app_fontName);
        if (fontName!=null) {
            setFont(fontName);
        }else{
            setFont(font);
        }
        attrFontName.recycle();
    }

    public void setFont(String font) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontsPath + font + ".ttf");
//        setTypeface(tf);
    }
}
