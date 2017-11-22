package com.example.processapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.processapp.data.PersonBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by zhangzhe on 2017/11/22.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private Context mContext;
    private ArrayList<PersonBean> mDatas;
    private LayoutInflater inflater;

    public PersonAdapter(Context mContext, ArrayList<PersonBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(inflater.inflate(R.layout.item_person,parent,false));
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        PersonBean person = mDatas.get(position);
        holder.mTvName.setText(person.getName());
        Picasso.with(mContext).load(person.getAvatar()).into(holder.mThumb);

    }

    @Override
    public int getItemCount() {
        return mDatas == null ?0 :mDatas.size();
    }
}
