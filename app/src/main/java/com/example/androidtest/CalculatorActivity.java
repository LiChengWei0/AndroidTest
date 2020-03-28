package com.example.androidtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private TextView tv_result;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_calculator);

        tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.ib_sqrt).setOnClickListener(this);

    }
    private String firstNumber = "";
    private String secondNumber = "";
    private String operator = "";
    private String result = "";
    private String v3 = "";
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_plus || id == R.id.btn_multiply || id == R.id.btn_minus || id == R.id.btn_divide){
            operator = ((TextView) v).getText().toString();
            result = firstNumber+operator;
            tv_result.setText(result);
        } else if (id == R.id.btn_equal) {
            BigDecimal v1 = new BigDecimal(firstNumber);
            BigDecimal v2 = new BigDecimal(secondNumber);
            Toast.makeText(this,operator,Toast.LENGTH_SHORT).show();
            if (operator.equals("+")) {
                v3 = String.valueOf(v1.add(v2));
            } else if (operator.equals("-")) {
                v3 = String.valueOf(v1.subtract(v2));
            } else if (operator.equals("x")) {
                v3 = String.valueOf(v1.multiply(v2));
            }else if(operator.equals("÷")){
                v3 = String.valueOf(v1.divide(v2));
            }
//            switch (operator) {
//                case "+":
//                    v3 = String.valueOf(v1.add(v2));
//                    Toast.makeText(this,"v3",Toast.LENGTH_SHORT).show();
//                    break;
//                case "-":
//                    v3 = String.valueOf(v1.subtract(v2));
//                    break;
//                case "*":
//                    v3 = String.valueOf(v1.multiply(v2));
//                    break;
//                case "/":
//                    v3 = String.valueOf(v1.divide(v2));
//                    break;
//            }
//            Toast.makeText(this,"点击了=",Toast.LENGTH_SHORT).show();
            result = firstNumber + operator + secondNumber + "=" + v3;
            tv_result.setText(result);

            firstNumber = v3;
            operator = "";
            secondNumber = "";

        } else if (id == R.id.btn_clear) {
            firstNumber = "";
            operator = "";
            secondNumber = "";
            result = "";
            v3 = "";
            tv_result.setText(result);
        } else if (id == R.id.ib_sqrt) {

        } else {
            if (firstNumber.length() == 0 || operator.equals("") == true) {
                firstNumber += ((TextView) v).getText().toString();
            } else if (operator.equals("") == false) {
                secondNumber += ((TextView) v).getText().toString();
            }
            result = firstNumber + operator + secondNumber;
            tv_result.setText(result);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
