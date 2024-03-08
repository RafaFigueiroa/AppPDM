package com.example.apppdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin();
        forgotPassword();
        joinNow();
    }

    private void signin() {
        TextView email = (TextView) findViewById(R.id.inputEmail);
        TextView password = (TextView) findViewById(R.id.inputPassword);
        Button signInButton = (Button) findViewById(R.id.signin);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "email: " + email.getText() + "\nsenha: " + password.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forgotPassword() {
        Button forgotPasswordButton = (Button) findViewById(R.id.forgotpassword);

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "esqueci a senha", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void joinNow() {
        Button joinNowButton = (Button) findViewById(R.id.joinnow);

        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "entrar agora", Toast.LENGTH_SHORT).show();
            }
        });
    }
}