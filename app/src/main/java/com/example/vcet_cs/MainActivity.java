package com.example.vcet_cs;

import android.content.Intent;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static  prefConfig pcg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pcg = new prefConfig(this);

    }

    public void click(View view) {
            Intent i= new Intent(this,LoginRegister.class);
            startActivity(i);
    }
}
