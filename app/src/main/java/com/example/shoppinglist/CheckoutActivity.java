package com.example.shoppinglist;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    TextView total;
    EditText payment;
    int totalAmount, paymentAmount, changeAmount;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent i = getIntent();

        total = findViewById(R.id.total);
        payment = findViewById(R.id.payment);

        totalAmount = i.getIntExtra("TOTAL", 0);
        total.setText(totalAmount + "");

        items = i.getStringArrayListExtra("LIST");

    }

    public void back(View v){
        finish();
    }


    public void finalize(View v){
        paymentAmount = Integer.parseInt(payment.getText().toString());

        if(paymentAmount < totalAmount) {
            Toast.makeText(getApplicationContext(), "Invalid Amount Input", Toast.LENGTH_SHORT).show();
        }
        else{
            changeAmount = paymentAmount - totalAmount;

            Intent intent = new Intent(this,FinalTransaction.class);
            intent.putExtra("TOTAL", totalAmount);
            intent.putExtra("PAID", paymentAmount);
            intent.putExtra("CHANGE",changeAmount);
            intent.putStringArrayListExtra("LIST", items);
            startActivity(intent);
            finish();
        }
    }
}
