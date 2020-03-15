package com.shambu.a10pointer.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shambu.a10pointer.Constants;
import com.shambu.a10pointer.R;
import com.shambu.a10pointer.RecyclerViewAdapters.PollsAdapter;

import java.util.HashMap;

public class AddPoll extends AppCompatActivity {

    private TextInputEditText pollName;
    private TextInputEditText pollHeading;
    private TextInputEditText pollOpt1;
    private TextInputEditText pollOpt2;

    private ToggleButton pollStatus;

    private DatabaseReference pollReference;


    private ProgressDialog progressDialog;

    //private PollsAdapter pollsAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_poll);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Adding Poll");

        pollReference=FirebaseDatabase.getInstance().getReference(Constants.polls);

        pollName=findViewById(R.id.txt_input_pollName);
        pollHeading=findViewById(R.id.txt_input_pollHeading);
        pollOpt1=findViewById(R.id.txt_input_pollOpt1);
        pollOpt2=findViewById(R.id.txt_input_pollOpt2);

        pollStatus=findViewById(R.id.poll_status_toggle);

        Button addPoll=findViewById(R.id.addPoll_button);
        addPoll.setOnClickListener(addPollButtonListener);











    }

    private View.OnClickListener addPollButtonListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progressDialog.show();
            CharSequence poll_name=pollName.getText();
            CharSequence poll_heading=pollHeading.getText();
            CharSequence poll_opt1=pollOpt1.getText();
            CharSequence poll_opt2=pollOpt2.getText();

            HashMap<String,String> pollMap=new HashMap<>();
            pollMap.put(Constants.pollHeading, poll_heading.toString());
            pollMap.put(Constants.pollOpt1, poll_opt1.toString());
            pollMap.put(Constants.pollOpt2, poll_opt2.toString());
            pollMap.put(Constants.pollStatus, pollStatus.isChecked()?"Active":"Not Active");

            String pollKey=pollReference.push().getKey();
            pollMap.put("pollId", pollKey);         //pollId is same as pollKey
            pollReference.child(pollKey)
                    .setValue(pollMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            progressDialog.dismiss();

                            Toast.makeText(AddPoll.this, "Poll added successfully", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(AddPoll.this, "Poll not added/n"+e.getMessage(), Toast.LENGTH_SHORT).show();


                        }
                    });





        }
    };


}
