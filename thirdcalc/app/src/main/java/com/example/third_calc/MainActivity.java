package com.example.third_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String num1 = "0";
    String num2 = "0";
    String mathOP;
    int count = 0;
    boolean switchText = false;

    public void numKeys(View view){
        TextView firstNumText = (TextView)findViewById(R.id.firstNum);
        TextView secondNumText = (TextView)findViewById(R.id.secondNum);
        Button button = (Button) view;
        String digits = (button.getTag()).toString();

        if(!switchText){
            num1 = num1.concat(digits);
            firstNumText.setText(num1);
        }
        else{
            num2 = num2.concat(digits);
            secondNumText.setText(num2);
        }
    }

    public void mathKeys(View view) {
        TextView mathOpText = (TextView) findViewById(R.id.mathOp);
        count++;
        Button button = (Button) view;

        mathOP = (button.getTag()).toString();
        mathOpText.setText(mathOP);

        if (count < 2) {
            switchText = true;
        }

    }

    public void calculate(View view){
        TextView resultTextView = (TextView)findViewById(R.id.result);
        double result = 0;
        double firstNum = Double.parseDouble(num1);
        double secondNum = Double.parseDouble(num2);

        switch(mathOP){
            case "+": result=firstNum+secondNum; break;
            case "-": result=firstNum-secondNum; break;
            case "*": result=firstNum*secondNum; break;
            case "/": result=firstNum/secondNum; break;
        }
        resultTextView.setText(String.valueOf(result));
    }
}