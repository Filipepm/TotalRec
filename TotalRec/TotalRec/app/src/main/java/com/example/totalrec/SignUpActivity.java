package com.example.totalrec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    private  EditText mEmail, mFirstName, mLastName, mPassword, mPasswordConfirmation, mUserName, mBirthday, mSport;
    private Switch coach, athelte;
    private Button signUp, createTeamButton, profileButton;
    private ArrayList<User> users = new ArrayList<User>();
    private DatabaseReference reff;
    private FirebaseAuth fbAuth;

    private String TAG = "TAG";
    private ProgressDialog mProgress;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fbAuth = FirebaseAuth.getInstance();
        reff = FirebaseDatabase.getInstance().getReference().child("User");
        mProgress = new ProgressDialog(this);

        mEmail = (EditText) findViewById(R.id.emailAddressInput);
        mFirstName = (EditText) findViewById(R.id.firstNameInput);
        mLastName = (EditText) findViewById(R.id.lastNameInput);
        mPassword = (EditText) findViewById(R.id.passwordInput);
        mPasswordConfirmation = (EditText) findViewById(R.id.passwordConfirmationInput);
        mBirthday = (EditText) findViewById(R.id.birthdayInput);
        mUserName = (EditText) findViewById(R.id.userNameInput);
        signUp = (Button) findViewById(R.id.signUpButton);
        mSport = (EditText) findViewById(R.id.sportInput);
        coach = (Switch) findViewById(R.id.coachSwitch);
        athelte = (Switch) findViewById(R.id.athleteSwitch);
        createTeamButton = findViewById(R.id.createTeamButton);
        profileButton = findViewById(R.id.profileButton);

        if (fbAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = mEmail.getText().toString().trim();
                String passwordText = mPassword.getText().toString().trim();
                String firstNameText = mFirstName.getText().toString().trim();
                String lastNameText = mLastName.getText().toString().trim();
                String userNameText = mUserName.getText().toString().trim();
                String birthDayText = mBirthday.getText().toString().trim();
                String sportText = mSport.getText().toString().trim();


                //Check if the athlete and coach switches are checked
                boolean isCoach = coach.isChecked();
                boolean isAthlete = athelte.isChecked();

                if (TextUtils.isEmpty(emailText)) {
                    mEmail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(passwordText)) {
                    mPassword.setError("Password is Required.");
                    return;
                }

                if (passwordText.length() < 6 || !passwordText.matches(".*\\d.*")) {
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                fbAuth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // send verification link

                            FirebaseUser fuser = fbAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(SignUpActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                }
                            });

                            Toast.makeText(SignUpActivity.this, "User Created.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                //Creates new user object and adds it to the arrayList
                User user = new User(emailText, firstNameText, lastNameText, userNameText, birthDayText, passwordText, isCoach, isAthlete,sportText);
                users.add(user);

                reff.push().setValue(user);
                Toast.makeText(SignUpActivity.this,"Data Inserted Successfully",Toast.LENGTH_LONG).show();


                if(isCoach){
                    createTeamButton.setVisibility(View.VISIBLE);
                }
                else if(isAthlete)
                {
                    profileButton.setVisibility(View.VISIBLE);
                }

            }


        });
        createTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateTeamActivity();
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });



    }



    public void openCreateTeamActivity()
    {
        Intent intent = new Intent(this, createTeam.class);
        String firstNameText = mFirstName.getText().toString().trim();
        String lastNameText = mLastName.getText().toString().trim();
        String name = firstNameText + " "  + lastNameText;
        intent.putExtra("coachName", name);
        String sportText = mSport.getText().toString().trim();
        intent.putExtra("sport", sportText);
        startActivity(intent);
    }

    public void openProfileActivity()
    {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

}
