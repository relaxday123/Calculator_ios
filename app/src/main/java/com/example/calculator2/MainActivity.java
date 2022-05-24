package com.example.calculator2;

import static androidx.core.view.ViewCompat.setBackgroundTintList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ed1;
    boolean isNewOp = true;
    boolean opExist = false;
    private Button btnac;
    String op = "";
    String oldNumber = "";
    Button add, mul, div, sub;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ed1 = findViewById(R.id.textView);
        btnac = (Button) findViewById(R.id.btnac);
        add = findViewById(R.id.btnadd);
        mul = findViewById(R.id.btnmul);
        div = findViewById(R.id.btndiv);
        sub = findViewById(R.id.btnsub);
    }

    public void numberEvent(View view)  {
        if(isNewOp) {
            ed1.setText("");
            btnac.setText("C");
        }
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btndot:
                if (number.contains("."))
                    break;
                else
                    number += ".";
                break;
            case R.id.btnswitch:
                if (number.isEmpty()) {
                    number = "-" + "0";
                }
                else if (number.charAt(0) == '-')
                    number = number.substring(1, number.length());
                else
                    number = "-" + number;
                break;
            case R.id.btnac:
                number = "0";
                btnac.setText("AC");
                isNewOp = true;
                opExist = false;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()) {
            case R.id.btnadd:
                op = "+";
                break;
                case R.id.btnsub:
                    op = "-";
                    break;
                case R.id.btndiv:
                    op = "/";
                    break;
                case R.id.btnmul:
                    op = "*";
                    break;
        }
//        ed1.setText(oldNumber + op);
    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result + "");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double result = Double.parseDouble(ed1.getText().toString()) / 100;
        ed1.setText(result + "");
        isNewOp = true;
    }
}