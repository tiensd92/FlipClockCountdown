package com.dino.studio.flipclockcoutdown;

/**
 * Created by DINO on 13/05/2016.
 */
public enum TypeAnim {
    flip_0_5(R.anim.flip_0_5_top, R.anim.flip_0_5_bottom),
    flip_0_9(R.anim.flip_0_9_top, R.anim.flip_0_9_bottom),
    flip_1_0(R.anim.flip_1_0_top, R.anim.flip_1_0_bottom),
    flip_2_1(R.anim.flip_2_1_top, R.anim.flip_2_1_bottom),
    flip_3_2(R.anim.flip_3_2_top, R.anim.flip_3_2_bottom),
    flip_4_3(R.anim.flip_4_3_top, R.anim.flip_4_3_bottom),
    flip_5_4(R.anim.flip_5_4_top, R.anim.flip_5_4_bottom),
    flip_7_6(R.anim.flip_7_6_top, R.anim.flip_7_6_bottom),
    flip_8_7(R.anim.flip_8_7_top, R.anim.flip_8_7_bottom),
    flip_9_8(R.anim.flip_9_8_top, R.anim.flip_9_8_bottom),
    flip_6_5(R.anim.flip_6_5_top, R.anim.flip_6_5_bottom),
    full_0(R.drawable.top_0_0, R.drawable.bottom_0_0),
    full_1(R.drawable.top_1_0, R.drawable.bottom_1_0),
    full_2(R.drawable.top_2_0, R.drawable.bottom_2_0),
    full_3(R.drawable.top_3_0, R.drawable.bottom_3_0),
    full_4(R.drawable.top_4_0, R.drawable.bottom_4_0),
    full_5(R.drawable.top_5_0, R.drawable.bottom_5_0),
    full_6(R.drawable.top_6_0, R.drawable.bottom_6_0),
    full_7(R.drawable.top_7_0, R.drawable.bottom_7_0),
    full_8(R.drawable.top_8_0, R.drawable.bottom_8_0),
    full_9(R.drawable.top_9_0, R.drawable.bottom_9_0);
    int top = R.drawable.top_0_0, bottom = R.drawable.bottom_0_0;

    TypeAnim(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getAnimTop() {
        return top;
    }
    public int getAnimBottom() {
        return bottom;
    }


}
