package com.example.healthylifestyle.Ingestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.healthylifestyle.FullImageActivity;
import com.example.healthylifestyle.ImageAdapter;
import com.example.healthylifestyle.R;

public class complexClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_activity);
        this.setTitle("Готовые меню");
        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // устанавливаем адаптер через экземпляр класса ImageAdapter
        gridView.setAdapter(new ImageAdapter(this));
       gridView.setOnItemClickListener(gridviewOnItemClickListener);
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            // посылаем идентификатор картинки в FullScreenActivity
            Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
            // передаем индекс массива
            i.putExtra("id", position);
            startActivity(i);
        }
    };
}

