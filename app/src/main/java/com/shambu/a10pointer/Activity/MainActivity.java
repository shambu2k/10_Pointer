package com.shambu.a10pointer.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shambu.a10pointer.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar =getSupportActionBar();
        BottomNavigationView menuView=findViewById(R.id.bottom_nav);
        menuView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.cr_notif:
                        return true;

                    case R.id.timetable:
                        return true;
                    case R.id.attendance:
                        return true;
                    case R.id.polls:
                        return true;
                    case R.id.groupchat:
                        return true;

                }
                return false;
            }
        });
    }


    private void IntentStarter(){



    }




}
