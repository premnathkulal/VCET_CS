package com.example.vcet_cs;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.util.UUID;

// Importing UploadService Package.

public class Uploader extends AppCompatActivity {



    // Creating Buttons.
    Button SelectButton, UploadButton;

    // Creating EditText.
    EditText PdfNameEditText,Semister ;

    // Creating URI .
    Uri uri;

    // Server URL.
    public static  String PDF_UPLOAD_HTTP_URL;


    // Pdf upload request code.
    public int PDF_REQ_CODE = 1;

    // Define strings to hold given pdf name, path and ID.
    String PdfNameHolder, PdfPathHolder, PdfID ,Semist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String key = i.getStringExtra("KEY");

        if(key.equals("NOTES")) {
            setContentView(R.layout.activity_uplod_notes);
        }else{
            setContentView(R.layout.activity_uplod_quetionpapers);
        }

        PDF_UPLOAD_HTTP_URL = "https://mokedatuluver.000webhostapp.com/server_upload_pdf.php?p1="+key;

        // Method to enable runtime permission.
        RequestRunTimePermission();

        // Assign ID'S to button and EditText.
        SelectButton = (Button) findViewById(R.id.Button_Select_PDF_ID);
        UploadButton = (Button) findViewById(R.id.Button_Upload_PDF_ID);
        PdfNameEditText = (EditText) findViewById(R.id.PDF_Name_EditText_ID);
        Semister = (EditText) findViewById(R.id.PDF_Sem_EditText_ID);

        // Adding click listener to Button.
        SelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // PDF selection code start from here .
                // Creating intent object.
                Intent intent = new Intent();

                // Setting up default file pickup time as PDF.
                intent.setType("application/pdf");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PDF_REQ_CODE);


            }
        });

        // Adding click listener to Upload PDF button.
        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling method to upload PDF on server.
                PdfUploadFunction();

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PDF_REQ_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();

            // After selecting the PDF set PDF is Selected text inside Button.
            SelectButton.setText("File is Selected");

            Toast.makeText(this,"selected",Toast.LENGTH_SHORT).show();

            SelectButton.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }


    // PDF upload function starts from here.
    public void PdfUploadFunction() {

        // Getting pdf name from EditText.
        PdfNameHolder = PdfNameEditText.getText().toString().trim();
        Semist = Semister.getText().toString().trim();

        // Getting file path using Filepath class.
        PdfPathHolder = FilePath.getPath(this, uri);


        if (PdfPathHolder == null) {

            Toast.makeText(this, "Please move your PDF file to internal storage & try again.", Toast.LENGTH_LONG).show();

        }
        // If file path is not null then PDF uploading file process will starts.
        else {

            try {

                PdfID = UUID.randomUUID().toString();

                new MultipartUploadRequest(this, PdfID, PDF_UPLOAD_HTTP_URL)
                        .addFileToUpload(PdfPathHolder, "pdf")
                        .addParameter("name", PdfNameHolder)
                        .addParameter("sem", Semist)
                        .setNotificationConfig(new UploadNotificationConfig())
                        .setMaxRetries(5)
                        .startUpload();

            } catch (Exception exception) {

                Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

        // Requesting run time permission method starts from here.

        public void RequestRunTimePermission(){

            if (ActivityCompat.shouldShowRequestPermissionRationale(Uploader.this, Manifest.permission.READ_EXTERNAL_STORAGE))
            {

                Toast.makeText(Uploader.this,"READ_EXTERNAL_STORAGE permission Access Dialog", Toast.LENGTH_LONG).show();

            } else {

                ActivityCompat.requestPermissions(Uploader.this,new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

            }
        }

        @Override
        public void onRequestPermissionsResult(int RC, String per[], int[] Result) {

            switch (RC) {

                case 1:

                    if (Result.length > 0 && Result[0] == PackageManager.PERMISSION_GRANTED) {

                        Toast.makeText(Uploader.this,"Permission Granted", Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(Uploader.this,"Permission Canceled", Toast.LENGTH_LONG).show();

                    }
                    break;
            }
        }
    }



