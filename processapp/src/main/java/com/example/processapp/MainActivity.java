package com.example.processapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.processapp.data.PersonBean;
import com.example.processapp.data.PersonDataServer;
import com.example.processapp.decoration.BitmapItemDecoration;
import com.example.processapp.decoration.LineDecorattion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private PersonAdapter personAdapter;
    private BitmapItemDecoration lineDecorattion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerview));
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lineDecorattion = new BitmapItemDecoration();
        lineDecorattion.setOrientation(LinearLayoutManager.VERTICAL);

        lineDecorattion.setDrawable(getDrawable(R.drawable.timg));


        recyclerView.addItemDecoration(lineDecorattion);

        recyclerView.setLayoutManager(layoutManager);
        ArrayList<PersonBean> sampleList = PersonDataServer.getSampleList(10);
        personAdapter = new PersonAdapter(this, sampleList);
        recyclerView.setAdapter(personAdapter);

    }
}
