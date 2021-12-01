package com.example.craps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class Home extends AppCompatActivity {

    public Button button;

    EditText editText;

    TextView avail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button = (Button) findViewById(R.id.start);
        editText=findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
              /*  int value = Integer.parseInt(editText.getText().toString());*/

                String et = editText.getText().toString();
                Intent intent=new Intent(Home.this,MainActivity.class);
                intent.putExtra("et",et);

                startActivity(intent);


                //String value = button.getText().toString();

            }
        });
    }


}