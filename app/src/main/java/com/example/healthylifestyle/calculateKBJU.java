package com.example.healthylifestyle;

import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class calculateKBJU extends AppCompatActivity implements View.OnClickListener {

    Spinner genderSpinner;
    EditText oldInput;
    EditText widthInput;
    EditText growInput;
    Spinner activSpinner;
    Spinner goalSpinner;
    TextView resultOut;
    TextView squirrelOut;
    TextView fatsOut;
    TextView carbohydeatesOut;
    Button resultbtn;

    public HashMap <Double, String> genders = new HashMap <Double, String>();
    {
        genders.put(1.0, "Мужской" );
        genders.put(0.9, "Женский");
    }

    public HashMap <Double, String> activing = new HashMap <Double, String>();

    {
        activing.put(1.2, "Минимальные нагрузки");
        activing.put(1.3, "Немного дневной активности");
        activing.put(1.4, "Тренировки 4-5 раз в неделю");
        activing.put(1.5, "Интенсивные трен-ки 4-5 раз");
        activing.put(1.6, "Ежедневные тренировки");
        activing.put(1.7, "Ежедневные интенсив тренировки");
        activing.put(1.9, "Тяжелая физическая работа");
    }

      /*  public enum Goal
    {
        sliming,
        setting,
        keeping
    } */

        public HashMap <Integer, String> goals = new HashMap <Integer, String>();

    {
        goals.put(0, "Поддержание");
        goals.put(1, "Похудение");
        goals.put(2, "Набор");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        this.setTitle("Калькулятор КБЖУ");

        genderSpinner = (Spinner) findViewById(R.id.gender);
        oldInput = (EditText) findViewById(R.id.oldInput);
        widthInput = (EditText) findViewById(R.id.widthInput);
        growInput = (EditText) findViewById(R.id.growInput);
        activSpinner = (Spinner) findViewById(R.id.activ);
        goalSpinner = (Spinner) findViewById(R.id.goal);
        resultOut = (TextView) findViewById(R.id.resultOutput);
        squirrelOut = (TextView) findViewById(R.id.squirrelOutput);
        fatsOut = (TextView) findViewById(R.id.fatsOutput);
        carbohydeatesOut = (TextView) findViewById(R.id.carbohydeatesOutput);
        resultbtn = (Button) findViewById(R.id.resultbtn);

        ArrayList<String> gendersName = new ArrayList<String>();
        for (String i: genders.values()) gendersName.add(i);
        ArrayList<String> activingNames = new ArrayList<String>();
        for (String i: activing.values()) activingNames.add(i);
        ArrayList<String> goalsNames = new ArrayList<String>();
        for (String i: goals.values()) goalsNames.add(i);

        ArrayAdapter<String> gender_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gendersName);
        ArrayAdapter<String> activing_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activingNames);
        ArrayAdapter<String> goals_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, goalsNames);
        genderSpinner.setAdapter(gender_adapter);
        activSpinner.setAdapter(activing_adapter);
        goalSpinner.setAdapter(goals_adapter);

        resultbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String selected1 = genderSpinner.getSelectedItem().toString();
        String selected2 = activSpinner.getSelectedItem().toString();
        String selected3 = goalSpinner.getSelectedItem().toString();
        Double gendvalue = (Double) getKeyFromValue(genders,selected1);
        Double actvalue = (Double) getKeyFromValue(activing,selected2);
        Integer goalvalue = (Integer) getKeyFromValue(goals,selected3);

        if ((oldInput.getText().toString().equals("")) || (widthInput.getText().toString().equals(""))|| (growInput.getText().toString().equals("")))

        {
            AlertDialog.Builder builder = new AlertDialog.Builder(calculateKBJU.this);
            builder.setTitle("Ошибка")
                    .setMessage("Введены не все данные!")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else
        {
            int oldvalue = Integer.parseInt(oldInput.getText().toString());
            double widthvalue = Double.parseDouble(widthInput.getText().toString());
            double growvalue = Double.parseDouble(growInput.getText().toString());
            String l = "Исправьте:";
            String exs = "";
            if ((widthvalue < 30) || (widthvalue > 210))
            {
                exs = exs + "Вес ";
            }

            if ((oldvalue < 10) || (oldvalue > 110))
            {
                exs = exs + "Возраст ";
            }

            if ((growvalue < 100) || (growvalue > 220))
            {
                exs = exs + "Рост ";
            }
            if (exs.length() != 0)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(calculateKBJU.this);
                builder.setTitle("Ошибка")
                        .setMessage(l + exs)
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
            else {
                double  result =  Calculator.CalorieCalculation (widthvalue, growvalue, oldvalue, actvalue, gendvalue, goalvalue);
                int protein = (int) (((result * 30) / 100) / 4);
                int fats = (int)(((result * 30) / 100) / 9);
                int carbohydeates = (int)(((result * 40) / 100) / 4);
                int calories = (int) result;
                /*Toast.makeText(getApplicationContext(), selected2, Toast.LENGTH_LONG).show();*/
                resultOut.setText("Ккал: " + calories);
                squirrelOut.setText("Белки: " + protein);
                fatsOut.setText("Жиры: " + fats);
                carbohydeatesOut.setText("Углеводы: " + carbohydeates);
            }
        }

    }
    public Object getKeyFromValue(HashMap hm, String value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }





}


