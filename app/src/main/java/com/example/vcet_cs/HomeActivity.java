package com.example.vcet_cs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textView;
    private Button bn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.userName);
        TextView nav_email = (TextView)hView.findViewById(R.id.userEmail);
        nav_user.setText(LoginRegister.pcg.readName());
        nav_email.setText(LoginRegister.pcg.readEmail());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.vcetMail) {

            Intent i = new Intent(HomeActivity.this,Web_links.class);
            String url = "https://mail.vcetputtur.ac.in/";
            i.putExtra("URLID",url);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ihome) {
            //this page it self
        } else if (id == R.id.inotes) {

            Intent i =new Intent(this,Notes.class);
            startActivity(i);

        } else if (id == R.id.iqpapers) {

            Intent i =new Intent(this,QuetionPapers.class);
            startActivity(i);

        } else if (id == R.id.islideshow) {

            Intent ii = new Intent(this,UploadSelecter.class);
            startActivity(ii);

        } else if (id == R.id.ichat) {

            Intent ii = new Intent(this,chat_activity.class);
            startActivity(ii);

        } else if (id == R.id.ielinks) {

            Intent i = new Intent(HomeActivity.this,Web_links.class);
            String url = "http://cells.vcetputtur.ac.in/";
            i.putExtra("URLID",url);
            startActivity(i);

        }else if (id == R.id.logout) {

            LoginRegister.pcg.wrightLogin(false);
            LoginRegister.pcg.writeName("user");
            Intent i = new Intent(HomeActivity.this,LoginRegister.class);
            startActivity(i);

        }else if (id == R.id.iupload){

            Intent ii = new Intent(this,UploadSelecter.class);
            startActivity(ii);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
