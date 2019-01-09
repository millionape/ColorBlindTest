package com.example.kittaphornj.colorblind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button startBtn;
    EditText nameText,ageText;
    TextView dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = (Button) findViewById(R.id.startBtn);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        dateText = (TextView) findViewById(R.id.dateText);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        dateText.setText(formattedDate);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String age = ageText.getText().toString();
                if(name.isEmpty()){
                    nameText.setError("กรุณาใส่ชื่อ-นามสกุล");
                }else{
                    if(age.isEmpty()){
                        ageText.setError("กรุณาใส่อายุ");
                    }else{
                        String strAge = ageText.getText().toString();
                        int intAge = Integer.parseInt(strAge);
                        if(intAge > 100) {
                            ageText.setError("กรุณาใส่อายุที่ถูกต้อง");
                        }else{
                            Intent i = new Intent(MainActivity.this,FirstTest.class);
                            i.putExtra("name", name);
                            i.putExtra("age", age);
                            startActivity(i);
                        }
                    }
                }
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        nameText.setText("");
        ageText.setText("");
        // put your code here...

    }
}
