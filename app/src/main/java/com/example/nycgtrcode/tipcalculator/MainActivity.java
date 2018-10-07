package com.example.nycgtrcode.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText checkAmountValue, partySizeValue;
    Button buttonCompute;
    TextView fifteenPercentTipValue, twentyPercentTipValue, twentyfivePercentTipValue, fifteenPercentTotalValue, twentyPercentTotalValue, twentyfivePercentTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        partySizeValue = (EditText) findViewById(R.id.partySizeValue);
        buttonCompute = (Button) findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = (TextView) findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = (TextView) findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = (TextView) findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = (TextView) findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = (TextView) findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = (TextView) findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkVal = checkAmountValue.getText().toString();
                String partVal  = partySizeValue.getText().toString();
                checkInputVals(checkVal, partVal);
            }
        });

        checkAmountValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fifteenPercentTipValue.setText("______");
                twentyPercentTipValue.setText("______");
                twentyfivePercentTipValue.setText("______");
                fifteenPercentTotalValue.setText("______");
                twentyPercentTotalValue.setText("______");
                twentyfivePercentTotalValue.setText("______");
            }
        });

        partySizeValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fifteenPercentTipValue.setText("______");
                twentyPercentTipValue.setText("______");
                twentyfivePercentTipValue.setText("______");
                fifteenPercentTotalValue.setText("______");
                twentyPercentTotalValue.setText("______");
                twentyfivePercentTotalValue.setText("______");
            }
        });
    }

    public void checkInputVals(String checkAmountValue, String partySizeValue){
        if(checkAmountValue.isEmpty() || partySizeValue.isEmpty())
        {
            Toast message = Toast.makeText(getApplicationContext(), "Please enter values on all fields", Toast.LENGTH_LONG);
            message.show();
        }

        else{

            int checkVal = Integer.valueOf(checkAmountValue);
            int partyVal = Integer.valueOf(partySizeValue);


            if(checkVal<0 || partyVal < 0)
            {
                Toast message = Toast.makeText(getApplicationContext(), "Please enter a positive value", Toast.LENGTH_LONG);
                message.show();

            }
            else
            {
                calculateVals(checkVal, partyVal);
            }

        }
    }

    public void calculateVals(int checkVal, int partyVal)
    {
         double perPersonAmount = checkVal/partyVal;

         double tip15 = Math.round(perPersonAmount*.15);

         double tip20 = Math.round(perPersonAmount*.20);

         double tip25 = Math.round(perPersonAmount*.25);

         double total15 = tip15 + perPersonAmount;

         double total20 = tip20 + perPersonAmount;

         double total25 = tip25 + perPersonAmount;

        fifteenPercentTipValue.setText(String.valueOf((int) tip15));
        twentyPercentTipValue.setText(String.valueOf((int) tip20));
        twentyfivePercentTipValue.setText(String.valueOf((int) tip25));
        fifteenPercentTotalValue.setText(String.valueOf((int) total15));
        twentyPercentTotalValue.setText(String.valueOf((int) total20));
        twentyfivePercentTotalValue.setText(String.valueOf((int) total25));
    }
}
