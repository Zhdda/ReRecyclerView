package com.example.processapp.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangzhe on 2017/11/22.
 */

public class LineDecorattion extends RecyclerView.ItemDecoration {
    private Paint paint ;

    public LineDecorattion() {
        this.paint = new Paint();
        paint.setColor(0xffff0000);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams
                    = (RecyclerView.LayoutParams) view.getLayoutParams();
            int top = view.getBottom() + layoutParams.bottomMargin;
            int bottom = top +2;
            c.drawRect(new RectF(left,top,right,bottom),paint);
        }

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 2);
    }
}
