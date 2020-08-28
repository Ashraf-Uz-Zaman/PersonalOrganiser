package com.codexive.personalorganiser.custom;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewGriditemDecoration extends RecyclerView.ItemDecoration {
    private int topPadding;
    private int leftPadding;
    private int rightPadding;
    private int bottomPadding;

    public RecyclerViewGriditemDecoration(int topPadding, int leftPadding, int rightPadding, int bottomPadding) {
        this.topPadding = topPadding;
        this.leftPadding = leftPadding;
        this.rightPadding = rightPadding;
        this.bottomPadding = bottomPadding;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        final int position = parent.getChildLayoutPosition(view);
        outRect.bottom = 0;
        outRect.top = 0;
        outRect.right = 0;
        outRect.left = 0;
        if (position == 0) {
            outRect.bottom = bottomPadding;
            outRect.top = topPadding;
            outRect.right = rightPadding;
            outRect.left = leftPadding;
        } else if(position == 1){
            outRect.bottom = bottomPadding;
            outRect.top = topPadding;
            outRect.right = rightPadding;
        }
        else if(position %2 == 0){
            outRect.bottom = bottomPadding;
            outRect.left = leftPadding;
            outRect.right = rightPadding;
        }
        else{
            outRect.bottom = bottomPadding;
            outRect.right = rightPadding;
        }
    }
}
