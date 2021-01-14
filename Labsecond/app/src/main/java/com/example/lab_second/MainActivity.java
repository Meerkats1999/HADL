package com.example.lab_second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void nextPage(View view) {
//        EditText userName = findViewById(R.id.userName);
//        Bundle b = new Bundle();
//        b.putString("Username", userName.getText().toString());
//        Intent it = new Intent(MainActivity.this,secondActivity.class);
//        it.putExtra("bundle", b);
//        startActivity(it);
//    }

    public void nextPageAdd(View view) {
        Bundle bundle = getData(view);
        bundle.putInt("flag", 1);
        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }

    public void nexPageSubtract(View view) {
        Bundle bundle = getData(view);
        bundle.putInt("flag", 2);
        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }

    private Bundle getData(View view){
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        Bundle bundle = new Bundle();
        bundle.putInt("Num1", Integer.parseInt(num1.getText().toString()));
        bundle.putInt("Num2", Integer.parseInt(num2.getText().toString()));
        return bundle;
    }
}