package com.example.vcet_cs;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView RegText;
    private EditText Useremail,Useerpass;
    private Button bn;


    OnLoginFormActivityListener loginFormActivityListener;
    public  interface  OnLoginFormActivityListener{
        public void  performRegister();
        public void performLogin(String name,String usn,String email);
    }

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        RegText =view.findViewById(R.id.reg_txt);
        Useremail = view.findViewById(R.id.iemail);
        Useerpass = view.findViewById(R.id.ipassword);
        bn = view.findViewById(R.id.button1);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    loginFormActivityListener.performRegister();
            }
        });
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFormActivityListener = (OnLoginFormActivityListener) activity;
    }


    private void performLogin(){
        String emai = Useremail.getText().toString();
        String password = Useerpass.getText().toString();

        Call<user> call = LoginRegister.apiInterface.performUserLogin(emai,password);

        call.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
                if(response.body().getResponse().equals("ok")){

                    LoginRegister.pcg.wrightLogin(true);
                    loginFormActivityListener.performLogin(response.body().getName(),response.body().getUsn(),response.body().getEmail());

                }
                else if(response.body().getResponse().equals("failed")){
                    LoginRegister.pcg.displyToast("Login failed");
                }
            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {

            }
        });
        Useremail.setText(null);
        Useerpass.setText(null);
    }
}
