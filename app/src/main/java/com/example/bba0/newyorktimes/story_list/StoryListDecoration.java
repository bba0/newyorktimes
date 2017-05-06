package com.example.bba0.newyorktimes.story_list;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by bba0 on 2017. 5. 5..
 */

public class StoryListDecoration extends RecyclerView.ItemDecoration {

    int mDecoration = 20;
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams)view .getLayoutParams();
        int spanIndex = lp.getSpanIndex();
        if (position <= 1) {
            outRect.top = mDecoration;
        }
        if(position >= 0){
            if(spanIndex == 0){
                outRect.left = mDecoration;
                outRect.right = mDecoration / 2;
            } else{
                outRect.right = mDecoration;
                outRect.left = mDecoration / 2;
            }
            outRect.bottom = mDecoration;
        }
    }
}
