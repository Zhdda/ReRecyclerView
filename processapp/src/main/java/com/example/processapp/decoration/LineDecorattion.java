package com.example.processapp.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by zhangzhe on 2017/11/22.
 */

public class LineDecorattion extends RecyclerView.ItemDecoration {
    private Paint paint ;

    private final int VERTICAL = LinearLayoutManager.VERTICAL;
    private final int HORIZENTAL = LinearLayoutManager.HORIZONTAL;

    private int orientation  = VERTICAL;

    public LineDecorattion() {
        this.paint = new Paint();
        paint.setColor(0xffff0000);
    }

    /**
     * 设置
     * @param orientation
     */
    public void setOrientation(int orientation){
        this.orientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (orientation == VERTICAL){
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
        }else {
            int top = parent.getPaddingTop();
            int bottom = parent.getHeight() - parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams
                        = (RecyclerView.LayoutParams) view.getLayoutParams();
                int left = view.getLeft() + layoutParams.rightMargin;
                int right = left +2;
                c.drawRect(new RectF(left,top,right,bottom),paint);
            }
        }


    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (orientation == VERTICAL) {
            outRect.set(0, 0, 0, 2);
        }else if (orientation == HORIZENTAL){
            outRect.set(0, 0, 2, 0);
        }

    }
}
