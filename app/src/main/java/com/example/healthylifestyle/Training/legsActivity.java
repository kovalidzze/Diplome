package com.example.healthylifestyle.Training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.healthylifestyle.DetailActivity7;
import com.example.healthylifestyle.R;

public class legsActivity extends AppCompatActivity {

    private String titleslegs[] = {
            "0. Велосипед",
            "1. Гиперэкстензия",
            "2. Стульчик",
            "3. Приседания",
            "4. Ягодичный мостик",

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legs_layot);
        this.setTitle("Ноги");
        ListView legsList = findViewById(R.id.legsList);
        //устанавливаем массив в ListView
        legsList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleslegs));
        legsList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        legsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentl = new Intent();
                intentl.setClass(legsActivity.this, DetailActivity7.class);

                intentl.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentl);
            }

        });
    }
}