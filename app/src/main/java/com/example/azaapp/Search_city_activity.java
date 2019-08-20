package com.example.azaapp;
import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// Импорт виджетов
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
// Массивы списков
import java.util.ArrayList;
// Списки
import java.util.List;

// Документация
/*
Активити отвечающая за вывод информации.
----------------------------------------
*/


public class Search_city_activity extends Activity  {


    //Переменная для работы с БД
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    Button button;
    TextView textView;

    private MyListAdapter Listadapter;
    private RecyclerView recyclerView;
    private List<RecyclerItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city_activity);


        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        //Коннект к элементу шаблона
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Формирование массива списков с элементами возвращаемыми выполнением запроса
        listItems = new ArrayList<>();
        //Строка запроса


        String x1 =
                "SELECT nameUniver, nameCity FROM university" +
                        " INNER JOIN city on City_idCity = idCity" +
                        " WHERE nameCity = 'Уфа'";



        String joiner = "SELECT * FROM " + "university " + "INNER JOIN "
                + "city " + "ON " + "City_idCity = city.idCity "
                + "INNER JOIN " + "faculty " + "ON " + "Univer = university.idUniver "
                + "WHERE city.nameCity = ?";

        Cursor cursor = mDb.rawQuery(x1, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            //Добаление элемента с типом RecyclerItem в массив списков
            // тип данных RecyclerItem задается классом, данный класс хранит 2 стороковые переменные title и description
            listItems.add(new RecyclerItem(cursor.getString(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        cursor.close();

        //Создание и установка адаптера
        Listadapter = new MyListAdapter(listItems, this);
        recyclerView.setAdapter(Listadapter);


    }


    }


