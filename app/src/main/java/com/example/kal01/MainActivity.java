package com.example.kal01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView firstNumber;
    TextView secondNumber;
    TextView result;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;

    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button clear;
    Button equals;

    Button secondWindows;

    String act;
    boolean fnum;
    String act1;

    Spinner spinner;
    String[] str_array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str_array = new String[10];
        for (int i = 0; i < str_array.length; i++) {
            str_array[i] = "";
        }

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, str_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        secondWindows = findViewById(R.id.secondWindows);

        act = "";
        fnum = true;
        act1 = "";
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);

        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);

        secondWindows.setOnClickListener(this);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (fnum)
                {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                }
                else
                {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
                Button button1 = (Button) view;
                act1 = button1.getText().toString();
                if (act == button1.getText().toString())
                {
                    act=button1.getText().toString();
                    if (!fnum)
                    {
                        fnum=!fnum;
                    }
                }
                else
                {
                    fnum=!fnum;
                }
                break;


            case R.id.clear:
            {
                act="";
                firstNumber.setText(act);
                secondNumber.setText(act);
                result.setText(act);
                fnum=true;
            }
            case R.id.equals:
                float num1 = Float.valueOf(firstNumber.getText().toString());
                float num2 = Float.valueOf(secondNumber.getText().toString());
                String[] str_array1 = new String[10];
                switch (act1) {
                    case ("+"):
                        double rezSum = num1 + num2;
                        result.setText(String.valueOf(rezSum));
                        str_array1[0] = String.valueOf(num1 + "+" + num2 + " = " + rezSum);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("-"):
                        double rezMin = num1 - num2;
                        result.setText(String.valueOf(rezMin));
                        str_array1[0] = String.valueOf(num1 + "-" + num2 + " = " + rezMin);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("/"):
                        double rezDel = num1 / num2;
                        result.setText(String.valueOf(rezDel));
                        str_array1[0] = String.valueOf(num1 + "/" + num2 + " = " + rezDel);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("x"):
                        double rezMul = num1 * num2;
                        result.setText(String.valueOf(rezMul));
                        str_array1[0] = String.valueOf(num1 + "x" + num2 + " = " + rezMul);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                }
                break;
            case R.id.secondWindows:
                Intent intent = new Intent(MainActivity.this, Math_page.class);
                startActivity(intent);
                break;

        }
    }
}