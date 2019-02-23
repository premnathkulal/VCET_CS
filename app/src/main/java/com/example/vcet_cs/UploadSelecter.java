package com.example.vcet_cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UploadSelecter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_selecter);

    }

    public void openNotes(View view) {
        Intent  i = new Intent(this,Uploader.class);
        i.putExtra("KEY","NOTES");
        startActivity(i);
    }

    public void openQpapers(View view) {
        Intent  i = new Intent(this,Uploader.class);
        i.putExtra("KEY","QPAPERS");
        startActivity(i);
    }
}
