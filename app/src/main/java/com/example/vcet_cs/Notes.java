package com.example.vcet_cs;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sem_list_layout);


        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notes.this,Subject_Code_List.class);
                i.putExtra("PASS1","notes");
                i.putExtra("PASS2",3);
                startActivity(i);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notes.this,Subject_Code_List.class);
                i.putExtra("PASS1","notes");
                i.putExtra("PASS2",4);
                startActivity(i);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notes.this,Subject_Code_List.class);
                i.putExtra("PASS1","notes");
                i.putExtra("PASS2",5);
                startActivity(i);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notes.this,Subject_Code_List.class);
                i.putExtra("PASS1","notes");
                i.putExtra("PASS2",6);
                startActivity(i);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notes.this,Subject_Code_List.class);
                i.putExtra("PASS1","notes");
                i.putExtra("PASS2",7);
                startActivity(i);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notes.this,Subject_Code_List.class);
                i.putExtra("PASS1","notes");
                i.putExtra("PASS2",8);
                startActivity(i);
            }
        });

    }
}
