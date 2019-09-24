package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class breastСlass extends AppCompatActivity {
    private String titlesbreast[] = {
            "0. Упор в стену",
            "1. Жим гантелей лежа на наклонной скамье",
            "2. Классические отжимания",
            "3. Отжимания с колен",
            "4. Разводка гантелей лежа на горизонтальной скамье",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breast_activity);
        this.setTitle("Грудь");// Получим идентификатор ListView
        ListView breastList = findViewById(R.id.breastList);
        //устанавливаем массив в ListView
        breastList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlesbreast));
        breastList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        breastList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentb = new Intent();
                intentb.setClass(breastСlass.this, DetailActivity6.class);

                intentb.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentb);
            }

        });
    }
}