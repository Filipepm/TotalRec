package com.example.totalrec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateEventActivity extends AppCompatActivity {
    private EditText titleOfEvent, dateOfEvent, timeOfEvent, locationOfEvent, descOfEvent;
    private Button createEventBtn;

    private String mEvent_key = null;
    private DatabaseReference mDatabase;

    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        mProgress = new ProgressDialog(this);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Event");

        titleOfEvent = (EditText) findViewById(R.id.eventTitle);
        dateOfEvent = (EditText) findViewById(R.id.eventDate);
        timeOfEvent = (EditText) findViewById(R.id.eventTime);
        locationOfEvent = (EditText) findViewById(R.id.eventLocation);
        descOfEvent = (EditText) findViewById(R.id.eventDescription);

        createEventBtn = (Button) findViewById(R.id.createEventButton);
        createEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });
    }

    private void startPosting() {

        mProgress.setMessage("Posting to blog...");

        final String title_value = titleOfEvent.getText().toString().trim();
        final String date_value = dateOfEvent.getText().toString().trim();
        final String time_value = timeOfEvent.getText().toString().trim();
        final String location_value = locationOfEvent.getText().toString().trim();
        final String desc_value = descOfEvent.getText().toString().trim();

        if(!TextUtils.isEmpty(title_value) && !TextUtils.isEmpty(date_value)
                && !TextUtils.isEmpty(time_value) && !TextUtils.isEmpty(location_value) && !TextUtils.isEmpty(desc_value)) {

            mProgress.show();

            DatabaseReference newPost = mDatabase.push();

            newPost.child("title").setValue(title_value);
            newPost.child("date").setValue(date_value);
            newPost.child("time").setValue(time_value);
            newPost.child("location").setValue(location_value);
            newPost.child("description").setValue(desc_value);

            mProgress.dismiss();
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
    }
}
