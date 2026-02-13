package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Class variables
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    // Matching GUI controls to Java objects
    private Button buttonExit;
    private EditText txtColorSelected;
    private TextView txtSpyBox;
    private ConstraintLayout myScreen;
    private String PREFNAME = "myPrefFile1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display the main screen
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        txtColorSelected = findViewById(R.id.editText1);
        buttonExit = findViewById(R.id.button1);
        txtSpyBox = findViewById(R.id.textView1);
        myScreen = findViewById(R.id.myScreen1);

        buttonExit.setOnClickListener(v -> finish());

        txtColorSelected.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String chosenColor = s.toString().toLowerCase(Locale.US);
                txtSpyBox.setText(chosenColor);
                setbc(chosenColor, myScreen);
            }
        });

        // Show the current state's name
        Toast.makeText(context, "onCreate", duration).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // If appropriate, change background color to chosen value
        updateMeUsingSavedStateData();
        Toast.makeText(context, "onStart", duration).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(context, "onResume", duration).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String chosenColor = txtSpyBox.getText().toString();
        saveStateData(chosenColor);
        Toast.makeText(context, "onPause", duration).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(context, isFinishing() ? "onStop (finishing)" : "onStop (background)", duration).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing())
            Toast.makeText(context, "onDestroy (app closed)", duration).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(context, "onRestart (returning to app)", duration).show();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String chosenColor = txtSpyBox.getText().toString();
        outState.putString("selectedColor", chosenColor);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String chosenColor = savedInstanceState.getString("selectedColor", "white");
            txtSpyBox.setText(chosenColor);
            setbc(chosenColor, myScreen);
        }
    }


    private void setbc(String chosenColor, ConstraintLayout myScreen) {


        if (chosenColor.contains("red"))
            myScreen.setBackgroundColor(0xffff0000);
        else if (chosenColor.contains("green"))
            myScreen.setBackgroundColor(0xff00ff00);
        else if (chosenColor.contains("blue"))
            myScreen.setBackgroundColor(0xff0000ff);
        else if (chosenColor.contains("white"))
            myScreen.setBackgroundColor(0xffffffff);
    }

    private void saveStateData(String chosenColor) {
        SharedPreferences myPrefContainer = getSharedPreferences(PREFNAME, MODE_PRIVATE);
        SharedPreferences.Editor myPrefEditor = myPrefContainer.edit();
        String key = "chosenBackgroundColor";
        String value = txtSpyBox.getText().toString();
        myPrefEditor.putString(key, value);
    }
    private void updateMeUsingSavedStateData() {
        SharedPreferences myPrefContainer = getSharedPreferences(PREFNAME, MODE_PRIVATE);

        String key = "chosenBackgroundColor";
        String defaultValue = "white";

        if (myPrefContainer != null && myPrefContainer.contains(key)) {
            String color = myPrefContainer.getString(key, defaultValue);
            setbc(color, myScreen);
            txtSpyBox.setText(color);
        }
    }
}
