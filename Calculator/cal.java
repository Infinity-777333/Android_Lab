package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    TextView cal_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=findViewById(R.id.num1);
        txt2=findViewById(R.id.num2);
        cal_result=findViewById(R.id.result);
    }
    public void calculate(View view){
        double a=Double.parseDouble(txt1.getText().toString());
        double b=Double.parseDouble(txt2.getText().toString());
        double result=0;

        int id=view.getId();

        if(id ==R.id.btnadd){
            result= a+b;
        }
        else if(id==R.id.btnsub){
            result=a-b;
        }
        else if(id==R.id.btnmult){
            result=a*b;
        }
        else if(id==R.id.btndiv){
            if (b==0) {
                cal_result.setText("Cannot divide by zero");
                return;
            }
                result = a/b;

        }
        cal_result.setText("Result: "+result);
    }

    public void clear(View view){
        txt1.setText("");
        txt2.setText("");
        cal_result.setText("");
    }

}
