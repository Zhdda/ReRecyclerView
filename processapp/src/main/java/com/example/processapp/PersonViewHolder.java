package com.example.processapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangzhe on 2017/11/22.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder {
    protected ImageView mThumb;
    protected TextView mTvName;

    public PersonViewHolder(View itemView) {
        super(itemView);

        mThumb = (ImageView) itemView.findViewById(R.id.thumb);
        mTvName = (TextView) itemView.findViewById(R.id.tv_name);
    }



}
