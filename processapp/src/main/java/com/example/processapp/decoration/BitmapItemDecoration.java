package com.example.processapp.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhangzhe on 2017/11/22.
 */

public class BitmapItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paint ;

    private final int VERTICAL = LinearLayoutManager.VERTICAL;
    private final int HORIZENTAL = LinearLayoutManager.HORIZONTAL;

    private int orientation  = VERTICAL;
    private Drawable drawable;

    public BitmapItemDecoration() {
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

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    /**
     * 在所有item绘制之前draw
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (orientation == VERTICAL && null != this.drawable){
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams
                        = (RecyclerView.LayoutParams) view.getLayoutParams();
                int top = view.getBottom() + layoutParams.bottomMargin;
                int bottom = top +drawable.getIntrinsicHeight();
                drawable.setBounds(left,top,right,bottom);
                drawable.draw(c);
            }
        }


    }

    /**
     * 在所有item绘制完成之后 onDrawOver
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (orientation == VERTICAL) {
            outRect.set(0, 0, 0, drawable.getIntrinsicHeight());
        }else if (orientation == HORIZENTAL){
            outRect.set(0, 0, 2, 0);
        }

    }
}
