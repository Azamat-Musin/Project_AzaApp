package com.example.azaapp;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.PopupMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
// Документация
/*
Отвчает за создание View первой N-ой страницы при использовании Pager
----------------------------------------
*/
public class Fragment1 extends Fragment {

    public Fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        TextView textView = view.findViewById(R.id.detailsText);
        textView.setText("ПОИСК ПО ГОРОДУ");
        return view;

    }
}