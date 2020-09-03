package com.example.totalrec;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    private Button createEvent;
    private RecyclerView mEventList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Event");

        mEventList = (RecyclerView) findViewById(R.id.profile_list);
        mEventList.setHasFixedSize(true);
        mEventList.setLayoutManager(new LinearLayoutManager(this));

        createEvent = (Button) findViewById(R.id.makeEvent);

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startEvent();
            }
        });

        Button teamHome = findViewById(R.id.teamHomeButton);
        teamHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTeamHome();
            }
        });
    }

    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Events> options = new FirebaseRecyclerOptions.Builder<Events>().setQuery(mDatabase, Events.class).build();

         FirebaseRecyclerAdapter<Events, EventViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Events, EventViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull EventViewHolder viewHolder, int position, @NonNull Events model) {
                viewHolder.post_title.setText(model.getTitle());
                viewHolder.post_date.setText(model.getDate());
                viewHolder.post_time.setText(model.getTime());
                viewHolder.post_location.setText(model.getLocation());
                viewHolder.post_description.setText(model.getDescription());
            }

            @NonNull
            @Override
            public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_row, viewGroup, false);
                return new EventViewHolder(view);
            }
        };

        mEventList.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{

        private TextView post_title, post_date, post_time, post_location, post_description;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            post_title = (TextView) itemView.findViewById(R.id.post_title);
            post_date = (TextView) itemView.findViewById(R.id.post_date);
            post_time = (TextView) itemView.findViewById(R.id.post_time);
            post_location = (TextView) itemView.findViewById(R.id.post_location);
            post_description = (TextView) itemView.findViewById(R.id.post_description);

        }
    }

    public void startEvent(){
        Intent i = new Intent(this, CreateEventActivity.class);

        startActivity(i);
    }
    public void startTeamHome(){
        Intent i = new Intent(this, teamHome.class);
        startActivity(i);
    }

}
