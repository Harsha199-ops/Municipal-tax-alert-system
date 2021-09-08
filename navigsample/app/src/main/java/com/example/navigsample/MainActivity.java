package com.example.navigsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
{
    NavigationView nav;
    Toolbar mToolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);


        nav=findViewById(R.id.navmenu);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nav);
        nav.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Fragment myfragment= null;
        Class fragmentClass = null;

        switch (item.getItemId())
        {
            case R.id.menu_home:
                fragmentClass =home.class;
                break;
            case R.id.menu_housetax:
                fragmentClass =housetax.class;
                break;
            case R.id.menu_agritax:
                fragmentClass =agritax.class;
                break;
            case R.id.menu_watertax:
                fragmentClass =watertax.class;
                break;



        }
        try
        {
            myfragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent,myfragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();
        return true;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.iconmenu, menu);
        return true;
    }
    private void setupDrawerContent(NavigationView nav){
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });
    }






}