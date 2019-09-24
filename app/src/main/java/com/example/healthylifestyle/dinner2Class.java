package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class dinner2Class extends AppCompatActivity {
    private String titlesdinner2[] = {
            "0. Баклажаны, запеченные с сыром и томатами",
            "1. Куриные бедрышки с грибами и ананасами",
            "2. Паста из кабачка",
            "3. Перепелки с грибами",
            "4. ПП пицца",
            "5. ПП салаты",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner2_activity);
        this.setTitle("Ужин");
        ListView din2List = findViewById(R.id.dinner2List);
        //устанавливаем массив в ListView
        din2List.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlesdinner2));
        din2List.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        din2List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentd = new Intent();
                intentd.setClass(dinner2Class.this, DetailActivity.class);

                intentd.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentd);
            }

        });
    }
}