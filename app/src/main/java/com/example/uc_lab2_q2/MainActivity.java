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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void submit(View view) {

        EditText txt = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText pass = findViewById(R.id.pass);
        EditText em = findViewById(R.id.email);


        String name = txt.getText().toString();
        String mobile = phone.getText().toString();
        String password = pass.getText().toString();
        String email = em.getText().toString();

        if(name.isEmpty()){
            txt.setError("Must Write your name");
            txt.requestFocus();
            return;
        }else if(!name.matches("[a-zA-Z]+")){
            txt.setError("Name must be a character");
            txt.requestFocus();
            return;
        }

        if(mobile.isEmpty()) {
            phone.setError("Must Write your Mobile Number");
            phone.requestFocus();
            return;
        }else if(mobile.matches("[a-zA-Z]+")){
            phone.setError("Phone must only contain numbers");
            phone.requestFocus();
            return;
        }

        if(password.isEmpty()){
            pass.setError("Can't leave password empty");
            pass.requestFocus();
            return;
        }

        if(email.isEmpty()){
            em.setError("Can't leave Email empty");
            em.requestFocus();
            return;
        }

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name",name);
        startActivity(intent);

    }
}
