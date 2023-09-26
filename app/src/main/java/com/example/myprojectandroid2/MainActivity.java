package com.example.myprojectandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double firstOperand = Double.NaN;
    private String operator = "";
    private boolean isOperatorClicked = false;
    private boolean isResultDisplayed = false;
    private double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setNumberButtonClickListener(R.id.button0, "0");
        setNumberButtonClickListener(R.id.button1, "1");
        setNumberButtonClickListener(R.id.button2, "2");
        setNumberButtonClickListener(R.id.button3, "3");
        setNumberButtonClickListener(R.id.button4, "4");
        setNumberButtonClickListener(R.id.button5, "5");
        setNumberButtonClickListener(R.id.button6, "6");
        setNumberButtonClickListener(R.id.button7, "7");
        setNumberButtonClickListener(R.id.button8, "8");
        setNumberButtonClickListener(R.id.button9, "9");

        setOperatorButtonClickListener(R.id.buttonDodavanay, "+");
        setOperatorButtonClickListener(R.id.buttonVidnimay, "-");
        setOperatorButtonClickListener(R.id.buttonMnozenay, "*");
        setOperatorButtonClickListener(R.id.buttonDilenya, "/");

        setClearButtonClickListener();
        setDecimalButtonClickListener();
        setEqualsButtonClickListener();


    }

    public void NextPage(View view) {
        Intent intent = new Intent(this, CheckColorActivity.class);
        startActivity(intent);
    }


    private void setDecimalButtonClickListener() {
        Button button = findViewById(R.id.buttonKoma);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = display.getText().toString();
                if (!currentText.contains(".")) {
                    display.append(".");
                }
            }
        });
    }

    private void setEqualsButtonClickListener() {
        Button button = findViewById(R.id.buttonDorivnye);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                isOperatorClicked = false;
                isResultDisplayed = true;
            }
        });
    }

    private void setClearButtonClickListener() {
        Button button = findViewById(R.id.buttonAC);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstOperand = Double.NaN;
                operator = "";
                isResultDisplayed = false;
                display.setText("0");
            }
        });
    }

    private void setOperatorButtonClickListener(int buttonId, final String op) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Double.isNaN(firstOperand)) {
                    calculate();
                }
                firstOperand = Double.parseDouble(display.getText().toString());
                operator = op;
                isOperatorClicked = true;
            }
        });
    }

    private void calculate() {
        double secondOperand = Double.parseDouble(display.getText().toString());

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.format("%s %s %s = %s", firstOperand, operator, secondOperand, result));
        firstOperand = result;
    }

    private void setNumberButtonClickListener(int buttonId, final String digit) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResultDisplayed) {
                    display.setText(digit);
                    isResultDisplayed = false;
                } else if (isOperatorClicked) {
                    display.setText(digit);
                    isOperatorClicked = false;
                } else {
                    String currentText = display.getText().toString();
                    if (currentText.equals("0") || currentText.equals("-0")) {
                        display.setText(digit);
                    } else {
                        display.append(digit);
                    }
                }
            }
        });
    }
}


//public class MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        EditText editText = findViewById(R.id.editText);
//        editText.addTextChangedListener(new TextWatcher() {
//            public void afterTextChanged(Editable s) {}
//            public void beforeTextChanged(CharSequence s, int start,
//                                          int count, int after) {
//            }
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                TextView textView = findViewById(R.id.textView);
//                textView.setText(s);
//            }
//        });
//    }
//}


