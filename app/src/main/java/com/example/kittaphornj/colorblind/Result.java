package com.example.kittaphornj.colorblind;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Result extends AppCompatActivity {
    TextView resultName,resultAge;
    TextView resultText;
    Button backButton;
    String name,age,firstTest,score0,score1,score2,score3,maxIndex;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ResultRecord");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            age = bundle.getString("age");
            firstTest = bundle.getString("firstTest");
            score0 = bundle.getString("score0");
            score1 = bundle.getString("score1");
            score2 = bundle.getString("score2");
            score3 = bundle.getString("score3");
            maxIndex = bundle.getString("maxIndex");
        }
        backButton = (Button) findViewById(R.id.buttonBack);
        resultName = (TextView) findViewById(R.id.resultName);
        resultAge = (TextView) findViewById(R.id.resultAge);
        resultText = (TextView) findViewById(R.id.textView8);
        resultName.setText(name);
        resultAge.setText(age);
        String finalResult;
        //String resultForm = "score0 = "+score0+"\nscore1 = "+score1+"\nscore2 = "+score2+"\nscore3 = "+score3;
        if(maxIndex.equals("0")){
            finalResult = "สายตาปกติ";
        }else if(maxIndex.equals("1")){
            finalResult = "ตาบอดสีฟ้า";
        }else if(maxIndex.equals("2")){
            finalResult = "ตาบอดสี(ทุกสี)";
        }else if(maxIndex.equals("3")){
            finalResult = "ตาบอดสี เขียว/แดง";
        }else{
            finalResult = "";
        }
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Result.this);
        builder1.setMessage("แน่ใจที่จะกลับไปหน้าแรก?");
        builder1.setCancelable(false);
        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        finish();
                    }
                });
        builder1.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog alert11 = builder1.create();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert11.show();
            }
        });
        resultText.setText(finalResult);
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        UserData udata = new UserData(age,formattedDate,firstTest,name,resultText.getText().toString(),score0,score1,score2,score3);
        myRef.child(name).setValue(udata);
    }
}
