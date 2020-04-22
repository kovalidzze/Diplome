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

public class snackActivity extends AppCompatActivity {
    private String titlessnack[] = {
            "0. 49 пп перекусов до 50 ккал",
            "1. Общие сведения",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack_layot);
        this.setTitle("Перекусы");
        ListView snList = findViewById(R.id.snackList);
        //устанавливаем массив в ListView
        snList.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titlessnack));
        snList.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        snList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intents = new Intent();
                intents.setClass(snackActivity.this, DetailActivity.class);

                intents.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intents);
            }

        });
    }
}