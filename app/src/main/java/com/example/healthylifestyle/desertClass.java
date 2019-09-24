package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class desertClass extends AppCompatActivity {
    private String titlesdesert[] = {
            "0. Кексы с шоколадной начинкой",
            "1. Клубличный рисоблин",
            "2. Конвертики с творогом",
            "3. ПП наполеон",
            "4. ПП нутелла",
            "5. Творожная пастила",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desert_activity);
        this.setTitle("Десерты");// Получим идентификатор ListView
        ListView desList = findViewById(R.id.desertList);
        //устанавливаем массив в ListView
        desList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlesdesert));
        desList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        desList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentd = new Intent();
                intentd.setClass(desertClass.this, DetailActivity.class);

                intentd.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentd);
            }

        });
    }
}
