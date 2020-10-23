package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {
    private Button calculateBtn;
    private MaterialButton DiscountBtn;
    private TextInputEditText product1Value;
    private TextInputEditText product2Value;
    private TextInputEditText product3Value;
    private TextInputEditText product4Value;
    private CheckBox product1;
    private CheckBox product2;
    private CheckBox product3;
    private CheckBox product4;

    private TextView totalText;


    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        this.calculateBtn = findViewById(R.id.button_cal);
        this.DiscountBtn = findViewById(R.id.Discount);
        this.product1Value = findViewById(R.id.text1);
        this.product2Value = findViewById(R.id.text2);
        this.product3Value = findViewById(R.id.text3);
        this.product4Value = findViewById(R.id.text4);
        this.product1 = findViewById(R.id.checkBox);
        this.product2 = findViewById(R.id.checkBox2);
        this.product3 = findViewById(R.id.checkBox3);
        this.product4 = findViewById(R.id.checkBox4);
        this.totalText = findViewById(R.id.textView5);

        this.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCalculateBtnClicked();
                Log.d("total", "Works");
            }
        });
    }

    private void onCalculateBtnClicked() {
        float Total = 0;
        String prod1Value = product1Value.getText().toString();
        String prod2Value = product2Value.getText().toString();
        String prod3Value = product3Value.getText().toString();
        String prod4Value = product4Value.getText().toString();

        if (product1.isChecked())
                Total += Float.parseFloat(prod1Value);
        if (product2.isChecked())
        Total += Float.parseFloat(prod2Value);
        if (product3.isChecked())
        Total += Float.parseFloat(prod3Value);
        if (product4.isChecked())
        Total += Float.parseFloat(prod4Value);

        if (DiscountBtn.isChecked())
            Total *= .75;

        String totalTextMsg = String.format("Total: $%.2f", Total);

        totalText.setText(totalTextMsg);
    }
    }

