package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText name,mail,pss;
    private Button btn;
    private TextView viewuser, viewmail, viewpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.uname);
        mail=findViewById(R.id.email);
        pss=findViewById(R.id.upass);

        viewuser=findViewById(R.id.viewuser);
        viewmail=findViewById(R.id.viewmail);
        viewpass=findViewById(R.id.viewpass);

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=name.getText().toString();
                String email=mail.getText().toString();
                String pass=pss.getText().toString();

                SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();

                editor.putString("Username",uname);
                editor.putString("Email",email);
                editor.putString("Password",pass);
                editor.apply();


                Toast.makeText(MainActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);



            }
        });


    }
}
