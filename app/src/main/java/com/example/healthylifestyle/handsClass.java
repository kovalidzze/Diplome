package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class handsClass extends AppCompatActivity {
    private String titleshands[] = {
            "0. Жим гантелей стоя",
            "1. Махи руками",
            "2. Отжимания",
            "3. Планка",
            "4. Сгибания рук за головой",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hands_activity);
        this.setTitle("Руки");
        ListView handsList = findViewById(R.id.handsList);
        //устанавливаем массив в ListView
        handsList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleshands));
        handsList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        handsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intenth = new Intent();
                intenth.setClass(handsClass.this, DetailActivity6.class);

                intenth.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intenth);
            }

        });
    }
}