package com.shambu.a10pointer.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.shambu.a10pointer.R;

public class AddPoll extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_poll);

        TextInputEditText pollHeading=findViewById(R.id.txt_input_pollHeading);
        TextInputEditText pollOpt1=findViewById(R.id.txt_input_pollOpt1);
        TextInputEditText pollOpt2=findViewById(R.id.txt_input_pollOpt2);

        ToggleButton pollStatus=findViewById(R.id.poll_status_toggle);

        Button addPoll=findViewById(R.id.addPoll_button);








    }
}
