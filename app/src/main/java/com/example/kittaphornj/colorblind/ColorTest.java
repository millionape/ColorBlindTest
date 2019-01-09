package com.example.kittaphornj.colorblind;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class ColorTest extends AppCompatActivity {
    /// normal , blueBlind , allBlind , redGree //
    int score[]={0,0,0,0};
    ArrayList<TestImageInfo> list=new ArrayList<TestImageInfo>();
    private Integer images[] = {R.drawable.w5,R.drawable.w45,R.drawable.n12,R.drawable.n15,R.drawable.n16,R.drawable.n26,R.drawable.n29,R.drawable.n3,R.drawable.n42,R.drawable.n45,R.drawable.n5,R.drawable.n6,R.drawable.n74,R.drawable.n8};
    ////// normalAnswer , blueBlindAnswer , allBlindAnswer , redGreenAnswer //////
    public String answers[][] = {{"x"," "," ","5"}, //w5
                                {"x"," "," ","45"}, //w45
                                {"12","12","12","12"}, //12
                                {"15"," ","x","17"},//15
                                {"16"," ","x"," "},//16
                                {"26","26","26","26"},//26
                                {"29"," ","x","70"},//29
                                {"3"," ","x","5"},//3
                                {"42","42","42","42"},//42
                                {"45"," ","x"," "},//45
                                {"5"," ","x","2"},//5
                                {"6"," ","x"," "},//6
                                {"74"," ","x","21"},//74
                                {"8","3","x"," "}//8
    };
    ImageView imgv;
    Button nextBtn;
    EditText inputAns;
    int img_counter = 0;
    TestImageInfo img_info;
    String name,age,firstTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_test);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            age = bundle.getString("age");
            firstTest = bundle.getString("firstTest");
        }
        imgv = (ImageView) findViewById(R.id.imageView);
        nextBtn = (Button) findViewById(R.id.button2);
        inputAns = (EditText) findViewById(R.id.editText3);
        for(int i=0;i<14;i++){
            TestImageInfo item = new TestImageInfo(images[i],answers[i][0],answers[i][1],answers[i][2],answers[i][3]);
            list.add(item);
        }
        Collections.shuffle(list);
        img_info = list.get(img_counter);
        imgv.setImageResource(img_info.getImage());

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_counter += 1;
                if(img_counter < 14){
                    String userAns = inputAns.getText().toString();
                    if(userAns.isEmpty()){
                        userAns = "x";
                    }
                    if(userAns.equals(img_info.getNormalAnswer())){
                        score[0] += 1; /// score[0] is normal score
                    }else if(userAns.equals(img_info.getBlueBlindAnswer())){
                        score[1] += 1;
                    }else if(userAns.equals(img_info.getAllBlindAnswer())){
                        score[2] += 1;
                    }else if(userAns.equals(img_info.getRedGreenAnswer())){
                        score[3] += 1;
                    }
                    img_info = list.get(img_counter);
                    imgv.setImageResource(img_info.getImage());
                }else{
                    String userAns = inputAns.getText().toString();
                    if(userAns.isEmpty()){
                        userAns = "x";
                    }
                    if(userAns.equals(img_info.getNormalAnswer())){
                        score[0] += 1; /// score[0] is normal score
                    }else if(userAns.equals(img_info.getBlueBlindAnswer())){
                        score[1] += 1;
                    }else if(userAns.equals(img_info.getAllBlindAnswer())){
                        score[2] += 1;
                    }else if(userAns.equals(img_info.getRedGreenAnswer())){
                        score[3] += 1;
                    }
                    //////////////
                    if(firstTest.equals("2")){
                        score[0] += 1;
                    }else{
                        score[1] += 1;
                        score[2] += 1;
                        score[3] += 1;
                    }

                    final int max = getIndexOfLargest(score);
                    //String str_score = String.valueOf(score[0]) +"/"+String.valueOf(score[1])+"/"+String.valueOf(score[2])+"/"+String.valueOf(score[3])+": max@index>>"+String.valueOf(max);
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(ColorTest.this);
                    builder1.setMessage("ทดสอบเสร็จเรียบร้อย");
                    builder1.setCancelable(false);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent i = new Intent(ColorTest.this,Result.class);
                                    i.putExtra("name", name);
                                    i.putExtra("age", age);
                                    i.putExtra("firstTest", firstTest);
                                    i.putExtra("score0", String.valueOf(score[0]));
                                    i.putExtra("score1", String.valueOf(score[1]));
                                    i.putExtra("score2", String.valueOf(score[2]));
                                    i.putExtra("score3", String.valueOf(score[3]));
                                    i.putExtra("maxIndex", String.valueOf(max));
                                    startActivity(i);
                                    finish();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                inputAns.setText("");
            }
        });


    }
    public int getIndexOfLargest( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest; // position of the first largest found
    }
}
