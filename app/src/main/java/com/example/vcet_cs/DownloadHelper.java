package com.example.vcet_cs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DownloadHelper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list);
    }

    public void downme_ooi(View view) {
        Toast.makeText(this,"HI",Toast.LENGTH_SHORT).show();
    }
}
