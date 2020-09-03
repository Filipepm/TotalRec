package com.example.totalrec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class teamHome extends AppCompatActivity {

    private DatabaseReference dReff;
    private TextView teamNameIn, coachNameIn, creationDateIn, totMembers, sportIn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_home);

        teamNameIn = findViewById(R.id.teamNameIn);
        coachNameIn = findViewById(R.id.coachNameIn);
        creationDateIn = findViewById(R.id.creationDateIn);
        sportIn = findViewById(R.id.sportIn);
        totMembers = findViewById(R.id.totMemIn);
        dReff = FirebaseDatabase.getInstance().getReference().child("Teams").child("1");
        dReff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot != null) {
                    String teamName = dataSnapshot.child("teamName").getValue().toString();
                    String coachName = dataSnapshot.child("coachName").getValue().toString();
                    String sport = dataSnapshot.child("sport").getValue().toString();
                    String creationDate = dataSnapshot.child("creationDate").getValue().toString();
                    Integer totalMembers = dataSnapshot.child("totalMembers").getValue(Integer.class);


                    teamNameIn.setText(teamName);
                    coachNameIn.setText(coachName);
                    sportIn.setText(sport);
                    creationDateIn.setText(creationDate);
                    totMembers.setText(totalMembers.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








        Button nonSubButton = (Button) findViewById(R.id.nonSubButton);

        nonSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNonSubTeamHome();
            }
        });


    }

    public void openNonSubTeamHome()
    {
        Intent intent = new Intent(this, nonSubTeamHome.class);
        startActivity(intent);


    }

}
