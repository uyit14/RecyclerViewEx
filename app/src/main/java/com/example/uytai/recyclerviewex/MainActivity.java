package com.example.uytai.recyclerviewex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration decoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(decoration);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divi);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList = new ArrayList<>();
        arrayList.add(new Data(R.drawable.a52017,"SamSung Galaxy A5 2017"));
        arrayList.add(new Data(R.drawable.a72017,"SamSung Galaxy A7 2017"));
        arrayList.add(new Data(R.drawable.iphone6splus,"Iphone 6s Plus"));
        arrayList.add(new Data(R.drawable.iphone7,"Iphone 7"));
        arrayList.add(new Data(R.drawable.iphone7plus,"Iphone 7 Plus"));
        arrayList.add(new Data(R.drawable.iphonese,"Iphone SE"));
        arrayList.add(new Data(R.drawable.s8plus,"SamSung Galaxy S8 Plus"));
        Adapter adapter = new Adapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
