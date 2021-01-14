package com.example.lab_second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    private Integer result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        Bundle b = getIntent().getBundleExtra("bundle");
//        String userName = b.getString("Username");
//        Toast.makeText(getApplicationContext(),userName, Toast.LENGTH_LONG).show();
//        ((TextView)findViewById(R.id.userName_second)).setText(userName);
        
        Bundle bundle = getIntent().getBundleExtra("bundle");
        Integer flag = bundle.getInt("flag");
        if(flag == 1){
            result = bundle.getInt("Num1") + bundle.getInt("Num2");
        }
        else if(flag == 2){
            result = bundle.getInt("Num1") - bundle.getInt("Num2");
        }
        ((TextView)findViewById(R.id.result)).setText(result.toString());
    }

    public void goBack(View view) {
        Intent intent = new Intent(secondActivity.this, MainActivity.class);
        startActivity(intent);
    }
}