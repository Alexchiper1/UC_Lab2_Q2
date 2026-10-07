package com.example.uc_lab2_q2;

import android.content.Intent;
import android.net.Uri;
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

    int randomnum;

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

        randomnum = 100000 + (int)(Math.random() * 900000);
        //Toast.makeText(this, "Code: " + randomnum, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Verification Code");
        intent.putExtra(Intent.EXTRA_TEXT, "Code: " + randomnum);
        startActivity(intent);

    }

    public void confirme(View view) {
        EditText num = findViewById(R.id.code);

        String c = num.getText().toString();


        if(c.isEmpty()) {
            num.setError("Please Enter code");
            num.requestFocus();
            return;
        }else if(!c.matches(String.valueOf(randomnum))) {
            num.setError("Please Enter Valid Code");
            num.requestFocus();
            return;
        }else if(c.length() != 6){
            num.setError("Please Enter Code That is 6 Digits");
            num.requestFocus();
            return;
        }else if (c.matches(String.valueOf(randomnum))){
            Toast.makeText(this, "Email Confirmed", Toast.LENGTH_SHORT).show();
        }
    }
}
