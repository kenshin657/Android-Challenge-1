package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalTransaction extends AppCompatActivity {

    int total=0;
    int change =0;
    int paid =0;
    ArrayList<String> myItems;
    TextView changetxt,amounttxt,totaltxt;

    Button button;

    ListView list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_transaction);
        Intent intent = getIntent();
        total = intent.getIntExtra("TOTAL",0);
        paid = intent.getIntExtra("PAID",0);
        change = intent.getIntExtra("CHANGE",0);
        myItems = intent.getStringArrayListExtra("LIST");

        list = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.textView, myItems);
        list.setAdapter(adapter);


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
