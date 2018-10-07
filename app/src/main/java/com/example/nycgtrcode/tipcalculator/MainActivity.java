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
         int perPersonAmount = checkVal/partyVal;

         int tip15 = (int) (perPersonAmount*.15);

         System.out.println(tip15+"tip15");

         int tip20 = (int) (perPersonAmount*.20);

         int tip25 = (int) (perPersonAmount*.25);

         int total15 = (int) (perPersonAmount*.15) + perPersonAmount;

         int total20 = (int) (perPersonAmount*.20) + perPersonAmount;

         int total25 = (int) (perPersonAmount*.25) + perPersonAmount;

        fifteenPercentTipValue.setText(String.valueOf(tip15));
        twentyPercentTipValue.setText(String.valueOf(tip20));
        twentyfivePercentTipValue.setText(String.valueOf(tip25));
        fifteenPercentTotalValue.setText(String.valueOf(total15));
        twentyPercentTotalValue.setText(String.valueOf(total20));
        twentyfivePercentTotalValue.setText(String.valueOf(total25));
    }
}
