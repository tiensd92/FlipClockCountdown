package com.dino.studio.flipclockcoutdown;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by DINO on 13/05/2016.
 */

public class ImageNumber extends LinearLayout {
    ImageView top, bottom;

    public ImageNumber(Context context) {
        super(context);
        init(context);
    }

    public ImageNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater mInflater = LayoutInflater.from(context);

        View layout = mInflater.inflate(R.layout.img_number, this);
        top = (ImageView) layout.findViewById(R.id.img_top);
        bottom = (ImageView) layout.findViewById(R.id.img_bottom);
        setNumber(0);
    }

    public void setChangeNumber(int x, int y) {
        TypeAnim typeAnim = TypeAnim.flip_1_0;
        if (x == 0 && y == 5)
            typeAnim = TypeAnim.flip_0_5;
        if (x == 0 && y == 9)
            typeAnim = TypeAnim.flip_0_9;
        if (x == 1 && y == 0)
            typeAnim = TypeAnim.flip_1_0;
        if (x == 2 && y == 1)
            typeAnim = TypeAnim.flip_2_1;
        if (x == 3 && y == 2)
            typeAnim = TypeAnim.flip_3_2;
        if (x == 4 && y == 3)
            typeAnim = TypeAnim.flip_4_3;
        if (x == 5 && y == 4)
            typeAnim = TypeAnim.flip_5_4;
        if (x == 6 && y == 5)
            typeAnim = TypeAnim.flip_6_5;
        if (x == 7 && y == 6)
            typeAnim = TypeAnim.flip_7_6;
        if (x == 8 && y == 7)
            typeAnim = TypeAnim.flip_8_7;
        if (x == 9 && y == 8)
            typeAnim = TypeAnim.flip_9_8;
        setAnime(typeAnim);
    }

    public void setAnime(TypeAnim typeAnim) {
        top.setBackgroundResource(typeAnim.getAnimTop());
        bottom.setBackgroundResource(typeAnim.getAnimBottom());
        top.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) top.getBackground();
                frameAnimation.start();
            }
        });
        bottom.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) bottom.getBackground();
                frameAnimation.start();
            }
        });

    }

    public void setNumber(int x) {
        TypeAnim typeAnim = TypeAnim.full_0;
        switch (x) {
            case 0:
                typeAnim = TypeAnim.full_0;
                break;
            case 1:
                typeAnim = TypeAnim.full_1;
                break;
            case 2:
                typeAnim = TypeAnim.full_2;
                break;
            case 3:
                typeAnim = TypeAnim.full_3;
                break;
            case 4:
                typeAnim = TypeAnim.full_4;
                break;
            case 5:
                typeAnim = TypeAnim.full_5;
                break;
            case 6:
                typeAnim = TypeAnim.full_6;
                break;
            case 7:
                typeAnim = TypeAnim.full_7;
                break;
            case 8:
                typeAnim = TypeAnim.full_8;
                break;
            case 9:
                typeAnim = TypeAnim.full_9;
                break;
        }
        top.setBackgroundResource(typeAnim.getAnimTop());
        bottom.setBackgroundResource(typeAnim.getAnimBottom());
    }

}
