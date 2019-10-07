package com.novikov.cuintertables.CounterClass;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.novikov.cuintertables.Interface.ILoging;

public class CounterButtonListener implements ILoging {

    private final Context context;
    private Button btnPlus, btnMinus;
    private EditText Counter;


    public CounterButtonListener(Context context, Button btnPlus, Button btnMinus, EditText Counter){

        this.context = context;
        this.btnPlus = btnPlus;
        this.btnMinus = btnMinus;
        this.Counter =  Counter;
    }

    public void setButtonListener(){


        btnMinus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            int counter = Integer.parseInt(String.valueOf(Counter.getText()));

                            if (counter > 0) {
                                counter--;
                            }

                            Counter.setText(Integer.toString(counter));

                            Toast.makeText(context,"Уменьшено -1", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "кнопка Minus успешно нажата");

                        } catch (NumberFormatException e) {
                            Log.d(TAG, "Ошибка.кнопка Minus. ButtonListener - setButtonListener", e);
                        }
                    }
                }
        );

        btnPlus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            int counter = Integer.parseInt(String.valueOf(Counter.getText()));
                            counter++;
                            Counter.setText(Integer.toString(counter));

                            Toast.makeText(context,"Увеличенно +1", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "кнопка Plus успешно нажата");

                        } catch (NumberFormatException e) {
                            Log.d(TAG, "Ошибка.кнопка Plus. ButtonListener - setButtonListener", e);
                        }
                    }
                }
        );

    }


    //------------------------------//
}
