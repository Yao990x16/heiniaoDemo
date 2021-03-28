package com.example.heiniaodemo.utils;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageText extends LinearLayout {

    public ImageText(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub

        ImageView imageViewButton = new ImageView(context, attrs);

        imageViewButton.setPadding(0, 0, 0, 0);

        TextView textView = new TextView(context, attrs);
        //水平居中
        textView.setGravity(android.view.Gravity.CENTER_HORIZONTAL);

        textView.setPadding(0, 0, 0, 0);

        setClickable(true);

        setFocusable(true);

        //setBackgroundResource(android.R.drawable.btn_default);

        setOrientation(LinearLayout.VERTICAL);

        addView(imageViewButton);

        addView(textView);
    }
}
