package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalTransaction extends AppCompatActivity {

    int total=0;
    int change =0;
    int paid =0;
    ArrayList<String> myItems;
    TextView changetxt,amounttxt,totaltxt;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_transaction);
        Intent intent = getIntent();
        total = intent.getIntExtra("TOTAL",0);
        paid = intent.getIntExtra("PAID",0);
        change = intent.getIntExtra("CHANGE",0);


        myItems = intent.getStringArrayListExtra("LIST");

        button=findViewById(R.id.menubutton);
        changetxt=findViewById(R.id.totalchange1);
        amounttxt=findViewById(R.id.amountpaid1);
        totaltxt=findViewById(R.id.totalamount1);

        totaltxt.setText(Integer.toString(total));
        amounttxt.setText(Integer.toString(paid));
        changetxt.setText(Integer.toString(change));




    }

    public void click(View v){
        Intent intent = new Intent(this,Start.class);
        startActivity(intent);
        finish();
    }
}
