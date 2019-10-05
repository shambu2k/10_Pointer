package com.shambu.a10pointer.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shambu.a10pointer.Activity.AddPoll;
import com.shambu.a10pointer.Constants;
import com.shambu.a10pointer.Data.Polls;
import com.shambu.a10pointer.R;
import com.shambu.a10pointer.RecyclerViewAdapters.PollsAdapter;

import java.util.ArrayList;

public class polls_fragment extends Fragment {

    DatabaseReference polls_reference;
    RecyclerView polls_recycler;
    PollsAdapter pollsAdapter;
    ArrayList<Polls> polls;
    Context context;

    public polls_fragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_polls,container,false);

        FloatingActionButton addPolls_fab=view.findViewById(R.id.addPoll_fab);
        addPolls_fab.setOnClickListener(fabListener);

        polls_recycler=view.findViewById(R.id.polls_recyclerView);
        polls_recycler.setLayoutManager(new LinearLayoutManager(context));
        polls=new ArrayList<Polls>();

        polls_reference= FirebaseDatabase.getInstance().getReference(Constants.polls);
        polls_reference.child("Poll 1").child("pollHeading").setValue("This is the first Poll ever.");
        polls_reference.child("Poll 1").child("pollStatus").setValue("Not Active");
        polls_reference.child("Poll 1").child("pollOpt1").setValue("Thats cool");
        polls_reference.child("Poll 1").child("pollOpt2").setValue("Not bad");

        polls_reference.child("Poll 2").child("pollHeading").setValue("How is the Poll UI");
        polls_reference.child("Poll 2").child("pollStatus").setValue("Active");
        polls_reference.child("Poll 2").child("pollOpt1").setValue("Good");
        polls_reference.child("Poll 2").child("pollOpt2").setValue("Has a lot of room for improvement");
        //polls_reference= FirebaseDatabase.getInstance().getReference(Constants.polls);
        polls_reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {

                    /*Polls poll=new Polls();
                    poll.setPollHeading(dataSnapshot1.child("poll_heading").getValue().toString());
                    poll.setActiveStatus(dataSnapshot1.child("poll_status").getValue().toString());
                    poll.setPollOpt1(dataSnapshot1.child("opt1").getValue().toString());
                    poll.setPollOpt2(dataSnapshot1.child("opt2").getValue().toString());*/
                    Polls poll=dataSnapshot1.getValue(Polls.class);
                    polls.add(poll);
                }

                pollsAdapter=new PollsAdapter(context,polls);
                polls_recycler.setAdapter(pollsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;


    }

    private View.OnClickListener fabListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent addPoll=new Intent(context, AddPoll.class);
            startActivity(addPoll);

        }
    };


}
