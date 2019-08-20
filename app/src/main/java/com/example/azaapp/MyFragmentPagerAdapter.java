package com.example.azaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

// Документация
/*
Адаптер отвечающий за подключение и вывод Pager
----------------------------------------
*/

public  class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    MyFragmentPagerAdapter (@NonNull FragmentManager fm) {
        super(fm);
    }
    // Указывает покилечесво фрагметов
    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            // Устанавливает фрагмент по умолчанию
            default:
                return new Fragment1();
        }
    }
}
