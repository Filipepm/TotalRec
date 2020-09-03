package com.example.totalrec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.snapshot.BooleanNode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class nonSubTeamHome extends AppCompatActivity {

    private DatabaseReference dReffT;
    private FirebaseDatabase db;
    private TextView teamNameIn, coachNameIn, creationDateIn, totMembers, sportIn;
    private FirebaseAuth fbAuth;
    private Teams team;
    private User[] subs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_sub_team_home);

        fbAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        teamNameIn = findViewById(R.id.teamNameIn2);
        coachNameIn = findViewById(R.id.coachNameIn2);
        creationDateIn = findViewById(R.id.creationDateIn2);
        sportIn = findViewById(R.id.sportIn2);
        totMembers = findViewById(R.id.totMemIn2);
        dReffT = FirebaseDatabase.getInstance().getReference().child("Teams").child("1");
        dReffT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot != null) {
                    String teamName = dataSnapshot.child("teamName").getValue().toString();
                    String coachName = dataSnapshot.child("coachName").getValue().toString();
                    String sport = dataSnapshot.child("sport").getValue().toString();
                    String creationDate = dataSnapshot.child("creationDate").getValue().toString();
                    Integer totalMembers = dataSnapshot.child("totalMembers").getValue(Integer.class);
                   // for(DataSnapshot childSnapShot: )



                    team = new Teams(teamName, creationDate, coachName, totalMembers, sport);


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
        Button subscribeButton = findViewById(R.id.joinTeamButton);
       /*
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = fbAuth.getCurrentUser().getEmail();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("User").orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot child: dataSnapshot.getChildren()) {
                            Log.d("User key", child.getKey().toString());
                            String key = child.getKey().toString();
                            DatabaseReference mData  = db.getReference().child("User").child(key);
                            String firstName = child.child("firstName").getValue().toString();
                            String lastName = child.child("lastName").getValue().toString();
                            String username = child.child("userName").getValue().toString();
                            String birthday = child.child("birthDay").getValue().toString();
                            String password = child.child("password").getValue().toString();
                            String email = child.child("email").getValue().toString();
                            Boolean athlete = (Boolean) child.child("athelete").getValue();
                            Boolean coach = (Boolean) child.child("coach").getValue();
                            String sport = child.child("sport").getValue().toString();

                            User newSub = new User(email, firstName, lastName, username, birthday, password, coach, athlete, sport);
                            team.addMember(newSub);


                            Log.d("User ref", child.getRef().toString());
                            Log.d("User val", child.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(nonSubTeamHome.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
                    }
                });

        */










         //   }
       // });

    }
}
