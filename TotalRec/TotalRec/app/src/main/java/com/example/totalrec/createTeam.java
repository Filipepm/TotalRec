package com.example.totalrec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class createTeam extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private TextView coachName;
    private String coachNametext;
    private TextView sport;
    private String sportText;
    private String teamName;
    private String creationDate;
    private Teams team;
    private User[] subs;
    FirebaseAuth fbAuth;
    private DatabaseReference teamR;
    long maxId = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        fbAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance();
        teamR = mDatabase.getReference().child("Teams");
        teamR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    maxId = dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        /*
        Bringing the user's name and the sport they're creating the team for over to the team creation portion of the applicaiton
         */
        coachName = (TextView) findViewById(R.id.coachName);
        coachNametext = getIntent().getExtras().getString("coachName");
        coachName.setText(coachNametext);
        sport = (TextView) findViewById(R.id.sportTransfer);
        sportText = getIntent().getExtras().getString("sport");
        sport.setText(sportText);

        Button createTeamButton = (Button) findViewById(R.id.teamCreationbutton);












        createTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //subs = new User[1];
                EditText teamNameIn = (EditText) findViewById(R.id.teamNameInput);
                teamName = teamNameIn.getText().toString().trim();
                EditText creationDateIn = (EditText) findViewById(R.id.creationDateInput);
                creationDate = creationDateIn.getText().toString().trim();
                team = new Teams(teamName, creationDate, coachNametext, 1, sportText);






                teamR.child(String.valueOf(maxId+1)).setValue(team);

                Toast.makeText(createTeam.this,"Team Inserted Successfully",Toast.LENGTH_LONG).show();
                openProfile();




            }
        });


    }

    public void openProfile()
    {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
}
