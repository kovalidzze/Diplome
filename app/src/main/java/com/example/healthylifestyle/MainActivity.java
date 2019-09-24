package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button brecipe;
    Button bcalculate;
    Button btraining;
    Button bzogh;
    //Button bfavourites;
    Button boutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* this.setTitle("Калькулятор КБЖУ");*/
        brecipe = (Button) findViewById(R.id.brecipe);
        brecipe.setOnClickListener(this);
        bcalculate = (Button) findViewById(R.id.bcalculate);
        bcalculate.setOnClickListener(this);
        btraining = (Button) findViewById(R.id.btraining);
        btraining.setOnClickListener(this);
        bzogh = (Button) findViewById(R.id.bzogh);
        bzogh.setOnClickListener(this);
        //bfavourites = (Button) findViewById(R.id.bfavorites);
        //bfavourites.setOnClickListener(this);
        boutput = (Button) findViewById(R.id.boutput);
        boutput.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bcalculate:
                Intent calculate_intent = new Intent(MainActivity.this, calculateKBJU.class);
                startActivity(calculate_intent);
                break;

            case R.id.brecipe:
                Intent recipe_intent = new Intent(MainActivity.this, recipesСlass.class);
                startActivity(recipe_intent);
                break;

            case R.id.btraining:
                Intent training_intent = new Intent(MainActivity.this, trainingСlass.class);
                startActivity(training_intent);
                break;

            case R.id.bzogh:
                Intent zogh_intent = new Intent(MainActivity.this, zohСlass.class);
                startActivity(zogh_intent);
                break;

            //case R.id.bfavorites:
               // Intent intent5 = new Intent(MainActivity.this, favouritesclass.class);
                //startActivity(intent5);
               // break;

            case R.id.boutput:
                finish();
                System.exit(0);
                break;
            default:
                break;
        }

    }
}
