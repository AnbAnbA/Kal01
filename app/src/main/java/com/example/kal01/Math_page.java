package com.example.kal01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Math_page extends AppCompatActivity implements View.OnClickListener{
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

    Button pow;
    Button sqrt;
    Button cos;
    Button sin;
    Button clear;
    Button equals;

    Button firstWindows;

    String act;
    boolean fnum;
    String act1;

    Spinner spinner;
    String[] str_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_page);
        str_array = new String[10];
        for (int i = 0; i < str_array.length; i++) {
            str_array[i] = "";
        }

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, str_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        firstWindows = findViewById(R.id.firstWindows);


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

        pow = findViewById(R.id.pow);
        sqrt = findViewById(R.id.sqrt);
        cos = findViewById(R.id.cos);
        sin = findViewById(R.id.sin);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);

        firstWindows.setOnClickListener(this);

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
        pow.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        cos.setOnClickListener(this);
        sin.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
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
                if (act == button1.getText().toString()) {
                    act = button1.getText().toString();
                    if (!fnum) {
                        fnum = !fnum;
                    }
                } else {
                    fnum = !fnum;
                }
                break;


            case R.id.clear: {
                act = "";
                firstNumber.setText(act);
                secondNumber.setText(act);
                result.setText(act);
                fnum = true;
            }
            case R.id.equals:
                float num1 = Float.valueOf(firstNumber.getText().toString());
                float num2 = Float.valueOf(secondNumber.getText().toString());
                String[] str_array1 = new String[10];
                switch (act1) {
                    case ("√"):
                        double rezKor = Math.sqrt(num1);
                        result.setText(String.valueOf(rezKor));
                        str_array1[0] = String.valueOf("√" + num1 + " = " + rezKor);
                        for (int i = 0; i < 9; i++) {
                            str_array1[i + 1] = str_array[i];
                        }
                        for (int i = 0; i < str_array.length; i++) {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("sin"):
                        double rezSin = Math.sin(num1);
                        result.setText(String.valueOf(rezSin));
                        str_array1[0] = String.valueOf("sin " + num1 + " = " + rezSin);
                        for (int i = 0; i < 9; i++) {
                            str_array1[i + 1] = str_array[i];
                        }
                        for (int i = 0; i < str_array.length; i++) {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("cos"):
                        double rezCos = Math.cos(num1);
                        result.setText(String.valueOf(rezCos));
                        str_array1[0] = String.valueOf("cos " + num1 + " = " + rezCos);
                        for (int i = 0; i < 9; i++) {
                            str_array1[i + 1] = str_array[i];
                        }
                        for (int i = 0; i < str_array.length; i++) {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("^"):
                        double rezStep = Math.pow(num1, num2);
                        result.setText(String.valueOf(rezStep));
                        str_array1[0] = String.valueOf(num1 + "^" + num2 + " = " + rezStep);
                        for (int i = 0; i < 9; i++) {
                            str_array1[i + 1] = str_array[i];
                        }
                        for (int i = 0; i < str_array.length; i++) {
                            str_array[i] = str_array1[i];
                        }
                        break;
                }
                break;
            case R.id.firstWindows:
                Intent intent = new Intent(Math_page.this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }