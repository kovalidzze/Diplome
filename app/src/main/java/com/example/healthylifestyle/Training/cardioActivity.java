package com.example.healthylifestyle.Training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.healthylifestyle.DetailActivity6;
import com.example.healthylifestyle.R;

public class cardioActivity extends AppCompatActivity {
    private String titlescardio[] = {
            "0. Бег и прыжки",
            "1. Выпрыгивания в упор лежа",
            "2. Выпрыгивания вверх",
            "3. Удары ногами",
            "4. Элементы аэробики и танцы",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio_layot);
        this.setTitle("Кардио тренировки");
        ListView cardioList = findViewById(R.id.cardioList);
        //устанавливаем массив в ListView
        cardioList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlescardio));
        cardioList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        cardioList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentc = new Intent();
                intentc.setClass(cardioActivity.this, DetailActivity6.class);

                intentc.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intentc);
            }

        });
    }
}