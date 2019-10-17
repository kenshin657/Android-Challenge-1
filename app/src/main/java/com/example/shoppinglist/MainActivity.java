package com.example.shoppinglist;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> myItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Spinner shopList;
    EditText nItems;
    int total = 0;
    TextView nTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nItems = findViewById(R.id.nItems);
        shopList = findViewById(R.id.shopList);
        nTotal = findViewById(R.id.nTotal);

        list = (ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.textView, myItems);
        list.setAdapter(adapter);
    }

    private String calculate(String item, int count) {

        if(item.equals("Apple")) {
            total += count * 20;
        }
        if(item.equals("Orange")) {
            total+= count * 10;
        }
        if(item.equals("Banana")) {
            total+= count *30;
        }

        return Integer.toString(total);
    }

    public void add(View v) {
        String str;
        str = shopList.getSelectedItem().toString() + "....." + nItems.getText().toString();

        adapter.add(str);

        nTotal.setText("Total: " + calculate(shopList.getSelectedItem().toString(), Integer.parseInt(nItems.getText().toString())));

        nItems.setText("");



    }

    public void checkout(View v) {
        Intent intent = new Intent(this, CheckoutActivity.class);

        intent.putStringArrayListExtra("LIST", myItems);
        intent.putExtra("TOTAL", total);

        startActivity(intent);
    }
}
