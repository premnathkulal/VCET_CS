package com.example.vcet_cs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Subject_Code_List extends AppCompatActivity {


    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work



    public static  String URL_PRODUCTS ,pass1;
    public  static  int pass2;
    private static ProgressDialog progressDialog;

    //a list to store all the products
    List<sub_data> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject__code__list);
        Intent i = getIntent();

         pass1 = i.getStringExtra("PASS1");
         pass2 = i.getIntExtra("PASS2",0);

         TextView tv = findViewById(R.id.textView5);
         String tvt = tv.getText().toString();
         tvt = tvt + "\n OF " + pass2 + " SEMISTER";
         tv.setText(tvt);

         Toast.makeText(this,pass1,Toast.LENGTH_SHORT).show();

        URL_PRODUCTS = "https://mokedatuluver.000webhostapp.com/getsub.php?p1="+pass2;


        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();

    }

    private void loadProducts() {


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new sub_data(
                                        product.getString("PdfName")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            SubListAdapter adapter = new SubListAdapter(Subject_Code_List.this, productList);

                            recyclerView.setAdapter(adapter);

                            progressDialog.dismiss();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void callMe(View view) {

        Intent i = new Intent(Subject_Code_List.this,Notes_List.class);
        i.putExtra("TOPIC",pass1);
        String name = ((Button) view).getText().toString();
        i.putExtra("SUBJECTCODE",name);
        startActivity(i);

    }
}
