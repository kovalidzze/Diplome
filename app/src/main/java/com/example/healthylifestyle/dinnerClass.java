package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class dinnerClass extends AppCompatActivity {
    private String titlesdinner[] = {
            "0. Кабачковый суп-пюре",
            "1. Люлякебаб с сыром",
            "2. Морковный суп-пюре",
            "3. Оливье",
            "4. Роллы филадельфия",
            "5. Сюп-пюре из цветной капусты",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner_activity);
        this.setTitle("Обед");
        ListView dinList = findViewById(R.id.dinnerList);
        //устанавливаем массив в ListView
        dinList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlesdinner));
        dinList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        dinList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentd = new Intent();
                intentd.setClass(dinnerClass.this, DetailActivity.class);

                intentd.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentd);
            }

        });
    }
}