package com.codexive.personalorganiser.custom;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHorizontalDecoration extends RecyclerView.ItemDecoration {
    int topPadding;

    public RecyclerViewHorizontalDecoration(int topPadding) {
        this.topPadding = topPadding;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = 0;
        outRect.top = 0;
        outRect.right = 0;
        outRect.left = 0;

        outRect.right = topPadding;
        outRect.left = topPadding;


    }
}