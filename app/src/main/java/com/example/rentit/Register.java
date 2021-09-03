package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username,password,repassword;
    androidx.appcompat.widget.AppCompatButton signup,signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword =(EditText) findViewById(R.id.repassword);
        signup =(androidx.appcompat.widget.AppCompatButton) findViewById(R.id.btnsignup);
        signin =(androidx.appcompat.widget.AppCompatButton) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if (user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(Register.this,"please enter all fields",Toast.LENGTH_SHORT).show();
              else{
                  if(pass.equals(repass)){
                      Boolean checkuser = DB.checkusername(user);
                      if (checkuser ==false){
                          Boolean insert= DB.InsertData(user,pass);
                          if (insert == true){
                              Toast.makeText(Register.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                              startActivity(intent);
                          }else {
                              Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                          }
                          }else {
                          Toast.makeText(Register.this, "user already exist! please sign in", Toast.LENGTH_SHORT).show();
                      }
                          }else{
                              Toast.makeText(Register.this,"passwords ot matching",Toast.LENGTH_SHORT).show();
                          }

                      }
                  }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });

    }
}