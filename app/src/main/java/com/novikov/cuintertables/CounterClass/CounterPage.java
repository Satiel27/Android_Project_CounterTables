package com.novikov.cuintertables.CounterClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.novikov.cuintertables.R;

public class CounterPage extends AppCompatActivity {

    private TextView namePage;
    private Button btnPlus, btnMinus;
    private EditText Counter;
    private Switch dailySwitch;
    private CounterSave newSave;

    //Сохранение настроек
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_page);

        //Инициализируем и находим переменные
        namePage = (TextView)findViewById(R.id.namePage);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        Counter = (EditText) findViewById(R.id.Counter);
        dailySwitch = (Switch) findViewById(R.id.dailySwitch);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        newSave  = new CounterSave();

        addButtonListener();

    }

    public void addButtonListener() {

        CounterButtonListener buttonListener = new CounterButtonListener(this,
                btnPlus,
                btnMinus,
                Counter);

        buttonListener.setButtonListener();

    }

    @Override
    protected void onResume() {
        super.onResume();

        newSave = new CounterSave();
        int IntCounter = Integer.parseInt(String.valueOf(Counter.getText()));

        int ICount  = newSave.ReadCounter(APP_PREFERENCES_COUNTER, mSettings, IntCounter);
        Counter.setText(Integer.toString(ICount));

    }

    @Override
    protected void onPause() {
        super.onPause();

        newSave = new CounterSave();
        int IntCounter = Integer.parseInt(String.valueOf(Counter.getText()));
        newSave.SaveCounter(APP_PREFERENCES_COUNTER, mSettings, IntCounter);

    }

}
