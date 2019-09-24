package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class pressСlass extends AppCompatActivity {

    private String titlespress[] = {
            "0. Велосипед",
            "1. Махи с согнутой ногой",
            "2. Ножницы",
            "3. Планка «пила»",
            "4. Скручивания",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.press_activity);
        this.setTitle("Пресс");
        ListView pressList = findViewById(R.id.pressList);
        //устанавливаем массив в ListView
        pressList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlespress));
        pressList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        pressList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentp = new Intent();
                intentp.setClass(pressСlass.this, DetailActivity.class);

                intentp.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentp);
            }

        });
    }
}