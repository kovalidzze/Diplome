package com.example.healthylifestyle;

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

public class recipesclass extends AppCompatActivity {

    GridView gridViewRecipe;
    String[] ingestionNames ={"Завтрак", "Обед", "Ужин", "Десерты", "Перекусы", "Готовые меню"};
    //String[] ingestionNames = getResources().getStringArray(R.array.r);
    int[] ingestionImg= {R.drawable.zavtrak, R.drawable.obed, R.drawable.yjin, R.drawable.desert, R.drawable.perekus, R.drawable.comlex};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);
        this.setTitle("Рецепты");
        gridViewRecipe = (GridView)findViewById(R.id.gridViewRecipe);
        final recipeAdapter recipeAdapter = new recipeAdapter();
        gridViewRecipe.setAdapter(recipeAdapter);
        /*gridViewRecipe.setOnItemClickListener(gridviewOnItemClickListener);
    }
        private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent breakfast_intent = new Intent(recipesclass.this, breakfast.class);
                    startActivity(breakfast_intent);
                }

                if (position == 1) {
                    Intent dinner_intent = new Intent(recipesclass.this, sights.class);
                    startActivity(dinner_intent);
                }

                if (position == 2) {
                    Intent dinner2_intent = new Intent(recipesclass.this, tours.class);
                    startActivity(dinner2_intent);
                }
                if (position == 3) {
                    Intent dessert_intent = new Intent(recipesclass.this, save.class);
                    startActivity(dessert_intent);
                }
                if (position == 4) {
                    Intent snack_intent = new Intent(recipesclass.this, forecast.class);
                    startActivity(snack_intent);
                }
                if (position == 5) {
                    Intent complex_intent = new Intent(recipesclass.this, forecast.class);
                    startActivity(complex_intent);
                }

            }*/
        }

   private class recipeAdapter extends BaseAdapter {

        // кол-во элементов
        @Override
        public int getCount() {
            return ingestionNames.length;
        }
        // элемент по позиции
        @Override
        public Object getItem(int position) {
            return ingestionNames[position];
        }
        // id по позиции
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewl = (View) getLayoutInflater().inflate(R.layout.cellgridrecipe,null);
            TextView name = (TextView) viewl.findViewById(R.id.textrec);
            ImageView image =(ImageView) viewl.findViewById(R.id.imagerec);
            name.setText(ingestionNames[i]);
            image.setImageResource(ingestionImg[i]);
            return viewl;
        }

    }



    }


