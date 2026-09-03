package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText xname, xemail, xphone, xage;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xname = findViewById(R.id.uname);
        xemail = findViewById(R.id.email);
        xphone = findViewById(R.id.phone);
        xage = findViewById(R.id.age);

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validateAndSubmit();
            }
        });
    }

    private void validateAndSubmit() {
        String name = xname.getText().toString().trim();
        String email = xemail.getText().toString().trim();
        String phone = xphone.getText().toString().trim();
        String age = xage.getText().toString().trim();

        //validate

        if (TextUtils.isEmpty(name)) {
            xname.setError("Please enter your name");
            xname.requestFocus();
            return;
        } else if (TextUtils.isEmpty(email)) {
            xemail.setError("Please enter your e mail");
            xemail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            xemail.setError("Please enter a valid e mail");
            xemail.requestFocus();
            return;
        } else if (TextUtils.isEmpty(phone)) {
            xphone.setError("Please enter your Phone number");
            xphone.requestFocus();
            return;
        } else if (phone.length() < 10) {
            xphone.setError("Please enter valid Phone number");
            xphone.requestFocus();
            return;
        }
        else if (TextUtils.isEmpty(age)) {
            xage.setError("Please enter your age");
            xage.requestFocus();
            return;
        }

        else if (Integer.parseInt(age)<18) {
            xage.setError("age must be greater than 18");
            xage.requestFocus();
            return;
        }
        Toast.makeText(MainActivity.this,"Form Submitted Successfully!",Toast.LENGTH_SHORT).show();
    }
}
