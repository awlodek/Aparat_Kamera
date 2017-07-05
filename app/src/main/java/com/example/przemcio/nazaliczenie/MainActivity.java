package com.example.przemcio.nazaliczenie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zdjecie= (Button) findViewById(R.id.zdjecie);
        Button nagrywanie= (Button) findViewById(R.id.nagrywanie);

        zdjecie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context,Main2Activity.class);
                startActivity(intent);
            }
        });

        nagrywanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context,Main3Activity.class);
                startActivity(intent);
            }
        });


    }
}
