package com.example.awos.tipcaculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.PatternSyntaxException;

public class MainActivity extends AppCompatActivity {
    private double amount;
    private double tipPercentage;
    private double taxPercentage;
    private String finalMessage;
    private double total;
    EditText amountArea;
    EditText taxArea;
    EditText tipArea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amountArea = (EditText) findViewById(R.id.amount_area);
        taxArea = (EditText) findViewById(R.id.tax_area);
        tipArea = (EditText) findViewById(R.id.tip_area);

    }

    public void submitOrder(View view) {
        Intent intent=new Intent(this,ReceiptActivity.class);
        amount = Double.parseDouble(amountArea.getText().toString());
        tipPercentage = Double.parseDouble(tipArea.getText().toString());
        taxPercentage = Double.parseDouble(taxArea.getText().toString());
        total=amount*(taxPercentage+taxPercentage);
        finalMessage="Total: "+amount;
        finalMessage+="\nSales Tax:"+taxPercentage;
        finalMessage+="\nTip: "+tipPercentage;
        finalMessage+="\nGrand Total: "+total;
        intent.putExtra("final",finalMessage);
        intent.putExtra("tax",taxPercentage);
        intent.putExtra("tip",tipPercentage);
        intent.putExtra("total",amount);

        startActivity(intent);


    }
}
