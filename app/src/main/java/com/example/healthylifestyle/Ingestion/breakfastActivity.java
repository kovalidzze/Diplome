package com.example.healthylifestyle.Ingestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.healthylifestyle.DetailActivity;
import com.example.healthylifestyle.R;

public class breakfastActivity extends AppCompatActivity {

    private String titlesbreak[] = {
            "0. Кабачковые наггетсы",
            "1. Лаваш с семгой",
            "2. Маффины из кабачков",
            "3. Овсяноблин с сыром и помидорами",
            "4. Печеночные рулеты с яйцом и зеленью",
            "5. ПП блинчики с творогом и смородиной",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast_layot);
        this.setTitle("Завтрак");

        // Получим идентификатор ListView
        ListView breakList = findViewById(R.id.breakList);
        //устанавливаем массив в ListView
        breakList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlesbreak));
        breakList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        breakList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentb = new Intent();
                intentb.setClass(breakfastActivity.this, DetailActivity.class);

                intentb.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentb);
            }

        });
    }
}
