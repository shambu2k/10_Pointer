package com.shambu.a10pointer.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shambu.a10pointer.Constants;
import com.shambu.a10pointer.Data.Polls;
import com.shambu.a10pointer.R;

import java.util.ArrayList;

public class PollsAdapter extends RecyclerView.Adapter<PollsAdapter.PollViewHolder> {

    Context context;
    ArrayList<Polls> polls;

    DatabaseReference pollsResultsReference;

    public void PollsDataChanged()
    {
        notifyDataSetChanged();
    }

    public PollsAdapter(Context context, ArrayList<Polls> polls) {
        this.context = context;
        this.polls = polls;
    }

    @NonNull
    @Override
    public PollViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        pollsResultsReference= FirebaseDatabase.getInstance().getReference(Constants.pollResults);
        return new PollViewHolder(LayoutInflater.from(context).inflate(R.layout.poll_ui, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PollViewHolder holder, final int position) {

        holder.poll_heading.setText(polls.get(position).getPollHeading());
        holder.poll_status.setText(polls.get(position).getPollStatus());
        holder.opt1.setText(polls.get(position).getPollOpt1());
        holder.opt2.setText(polls.get(position).getPollOpt2());
        if (polls.get(position).getPollStatus().equals("Not Active"))
        {
            holder.poll_status.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_poll_not_active_red_24dp,0,0,0);
        }else holder.poll_status.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_poll_active_green_24dp,0,0,0);

        holder.poll_submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, polls.get(position).getPollId(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return polls.size();
    }


    class PollViewHolder extends RecyclerView.ViewHolder {

        TextView poll_heading, poll_status, opt1, opt2;
        Button poll_submit_button;
        public PollViewHolder(@NonNull View itemView) {
            super(itemView);
            poll_submit_button=itemView.findViewById(R.id.poll_submit_button);
            poll_heading=itemView.findViewById(R.id.pollHeading);
            poll_status=itemView.findViewById(R.id.poll_status);
            opt1=itemView.findViewById(R.id.opt1);
            opt2=itemView.findViewById(R.id.opt2);
        }
    }
}
