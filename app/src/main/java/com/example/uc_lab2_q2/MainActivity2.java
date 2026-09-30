package com.example.uc_lab2_q2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        TextView text = findViewById(R.id.email);
        String email = getIntent().getStringExtra("email");

        text.setText("You need to confirm your email " + email + " please enter code");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    int code = getIntent().getIntExtra("randomnum", -1);

    public void confirme(View view) {
        EditText num = findViewById(R.id.code);

        String c = num.getText().toString();

        if(c.isEmpty()) {
            num.setError("Please Enter code");
            num.requestFocus();
            return;
        }else if(!c.matches(String.valueOf(code))){
            num.setError("Please Enter code");
            num.requestFocus();
            return;
        }else if (c.matches(String.valueOf(code))){
            Toast.makeText(this, "Email Confirmed", Toast.LENGTH_SHORT).show();
        }
    }
}