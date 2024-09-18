package com.example.myapplicationbmi;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText etWeight , etHeight ;
Button btnCaluculator ;
    // safa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        connectComponents();
    }

    private void connectComponents() {
        etWeight=findViewById(R.id.etWeightMain);
        etHeight=findViewById(R.id.etHeightMain2);
        btnCaluculator=findViewById(R.id.btnCalculator);


    }

    public void Calculator(View view) {
        String weight = etWeight.getText().toString();
        String height = etHeight.getText().toString();
        if (weight.isEmpty()|| !TextUtils.isDigitsOnly(weight) ||height.isEmpty()|| !TextUtils.isDigitsOnly(height)){
            Toast.makeText(this, "check data your entered " , Toast.LENGTH_SHORT).show();
            return ; }
        double w,h ,bmi;
        w=Double.parseDouble(weight);
        h=Double.parseDouble(height);
        bmi = w/(h*h);
        Toast.makeText(this, "your bmi is "+bmi , Toast.LENGTH_SHORT).show();

    }
}