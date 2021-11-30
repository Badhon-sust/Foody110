package com.example.foody110.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foody110.MainActivity;
import com.example.foody110.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.register_email);
        password=findViewById(R.id.register_password);

    }


    public void Login(View view) {

        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();

        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(LoginActivity.this,"Enter your email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(LoginActivity.this,"Enter your password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length()<6){
            Toast.makeText(this,"password must be 6 digit",Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));

                            Toast.makeText(LoginActivity.this,"Succesfully LogIn",Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.]
                            Toast.makeText(LoginActivity.this,"Succesfully LogIn",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
                        }

                        // ...
                    }
                });

    }
}