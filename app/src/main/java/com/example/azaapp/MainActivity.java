package com.example.azaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Документация
/*
Активити отвечающая за паказ страниц, перелистывание экранов
----------------------------------------
*/

public class MainActivity extends AppCompatActivity {




    Button button;
    TextView textView;
    private MyListAdapter Listadapter;
    private RecyclerView recyclerView;
    private List<RecyclerItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyFragmentPagerAdapter Paperadapter = new MyFragmentPagerAdapter(getSupportFragmentManager());


        ViewPager viewPager = findViewById(R.id.viewpagers);
        viewPager.setAdapter(Paperadapter); // устанавливаем адаптер
        viewPager.setCurrentItem(0); // выводим первый экран







    }

    public void onClick(View view) {

        Intent intent = new Intent(MainActivity.this, Search_city_activity.class);
        startActivity(intent);

    }
    public void WebStart (View view) {
        Intent intent = new Intent(MainActivity.this, WebViewer.class);
        startActivity(intent);

    }
}

