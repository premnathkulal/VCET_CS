package com.example.vcet_cs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragmet extends Fragment {
    private EditText Name,Useremail,Userusn,Userpass;
    private Button bn;


    public RegistrationFragmet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration_fragmet, container, false);
        Name = view.findViewById(R.id.iname);
        Useremail = view.findViewById(R.id.iemail);
        Userusn =view.findViewById(R.id.iusn);
        Userpass = view.findViewById(R.id.ipassword);
        bn = view.findViewById(R.id.button1);



        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });

        return  view;
    }

    public void performRegistration(){
        String name = Name.getText().toString();
        String email = Useremail.getText().toString();
        String usn = Userusn.getText().toString();
        String password = Userpass.getText().toString();

        Call<user> call = LoginRegister.apiInterface.performRegistration(name,email,usn,password);

        call.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {

                if(response.body().getResponse().equals("ok")){
                    LoginRegister.pcg.displyToast("Registration success....");
                }
                else if(response.body().getResponse().equals("exist")){
                    LoginRegister.pcg.displyToast("exists");
                }
                else{
                    LoginRegister.pcg.displyToast("somthing went wrong");
                }
            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {
                LoginRegister.pcg.displyToast("Failed");
            }
        });
        Name.setText(null);
        Useremail.setText(null);
        Userusn.setText(null);
        Userpass.setText(null);
    }
}
