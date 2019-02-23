package com.example.vcet_cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class LoginRegister extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListener {

    public void logi(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new LoginFragment()).addToBackStack(null).commit();
    }


    public static  prefConfig pcg;
    public static ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        pcg = new prefConfig(this);

        apiInterface = apiclient.getApiclient().create(ApiInterface.class);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            if (pcg.readLogin()) {
                Intent i = new Intent(this, HomeActivity.class);
                startActivity(i);
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();

            }
        }
    }

    @Override
    public void performRegister() {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new RegistrationFragmet()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name,String usn,String email) {
        pcg.writeName(name);
        pcg.writeUsn(usn);
        pcg.writeEmail(email);
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);
    }
}
