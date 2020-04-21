package com.example.healthylifestyle.Training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthylifestyle.R;

public class trainingСlass extends AppCompatActivity {

    GridView gridViewTrain;
    String[] trainNames ={"Грудь", "Ноги", "Пресс", "Руки", "Кардио"};
    //String[] ingestionNames = getResources().getStringArray(R.array.r);
    int[] trainImg= {R.drawable.grud, R.drawable.nogi, R.drawable.press, R.drawable.ryki, R.drawable.kardio};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_activity);
        this.setTitle("Тренировки");
        gridViewTrain = (GridView)findViewById(R.id.gridViewTrain);
        final trainAdapter trainAdapter = new trainAdapter();
        gridViewTrain.setAdapter(trainAdapter);
        gridViewTrain.setOnItemClickListener(gridviewOnItemClickListener);
    }
    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            if (position == 0) {
                Intent breast_intent = new Intent(trainingСlass.this, breastСlass.class);
                startActivity(breast_intent);
            }

            if (position == 1) {
                Intent legs_intent = new Intent(trainingСlass.this, legsСlass.class);
                startActivity(legs_intent);
            }

            if (position == 2) {
                Intent press_intent = new Intent(trainingСlass.this, pressСlass.class);
                startActivity(press_intent);
            }
            if (position == 3) {
                Intent hands_intent = new Intent(trainingСlass.this, handsClass.class);
                startActivity(hands_intent);
            }
            if (position == 4) {
                Intent cardio_intent = new Intent(trainingСlass.this, cardioClass.class);
                startActivity(cardio_intent);
            }


        }
    };

    private class trainAdapter extends BaseAdapter {

        // кол-во элементов
        @Override
        public int getCount() {
            return trainNames.length;
        }
        // элемент по позиции
        @Override
        public Object getItem(int position) {
            return trainNames[position];
        }
        // id по позиции
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewl = (View) getLayoutInflater().inflate(R.layout.cellgrid2,null);
            TextView name = (TextView) viewl.findViewById(R.id.text1);
            ImageView image =(ImageView) viewl.findViewById(R.id.image1);
            name.setText(trainNames[i]);
            image.setImageResource(trainImg[i]);
            return viewl;
        }

    }
}

