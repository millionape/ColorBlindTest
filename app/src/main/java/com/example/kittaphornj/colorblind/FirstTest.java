package com.example.kittaphornj.colorblind;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstTest extends AppCompatActivity {
    Button ans1,ans2,ans3,nextBtn;
    String name,age;
    int ans = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            age = bundle.getString("age");
        }
        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        ans2.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
        ans1.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
        ans3.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
        nextBtn = (Button) findViewById(R.id.nextBtn);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setBackgroundColor(Color.GREEN);
                ans2.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
                ans3.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
                ans = 1;
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans2.setBackgroundColor(Color.GREEN);
                ans1.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
                ans3.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
                ans = 2;
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans3.setBackgroundColor(Color.GREEN);
                ans2.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
                ans1.setBackgroundColor(Color.parseColor("#FFD6D7D7"));
                ans = 3;
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans > 0){
                    Intent i = new Intent(FirstTest.this,ColorTest.class);
                    i.putExtra("name", name);
                    i.putExtra("age", age);
                    i.putExtra("firstTest", String.valueOf(ans));
                    startActivity(i);
                    finish();
                }else{
                    showDialog();
                }
            }
        });

    }
    void showDialog(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("กรุณาเลือกคำตอบ");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
