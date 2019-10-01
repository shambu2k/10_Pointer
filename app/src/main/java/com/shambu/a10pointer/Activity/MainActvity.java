package com.shambu.a10pointer.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shambu.a10pointer.Fragments.attendance_fragment;
import com.shambu.a10pointer.Fragments.cr_notific_fragment;
import com.shambu.a10pointer.Fragments.grpchat_fragment;
import com.shambu.a10pointer.Fragments.polls_fragment;
import com.shambu.a10pointer.Fragments.timetable_fragment;
import com.shambu.a10pointer.R;

public class MainActvity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, new timetable_fragment());
        bottomNavigationView.setSelectedItemId(R.id.timetable);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

            }
        });
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selected_fragment=null;
            switch (menuItem.getItemId()){
                case R.id.cr_notif:
                    selected_fragment=new cr_notific_fragment();
                    break;
                case R.id.timetable:
                    selected_fragment=new timetable_fragment();
                    break;
                case R.id.attendance:
                    selected_fragment=new attendance_fragment();
                    break;
                case R.id.polls:
                    selected_fragment=new polls_fragment();
                    break;
                case R.id.groupchat:
                    selected_fragment=new grpchat_fragment();
                    break;


            }

            if (selected_fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container,selected_fragment).commit();
            }

            return true;
        }
    };
}
