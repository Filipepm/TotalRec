package com.example.totalrec;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserEmailChange extends AppCompatActivity {
    private String TAG = "UserInfoUpdate";
    private TextView userNewEmail;
    private Button changeEmail;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_email_change);

        changeEmail = (Button) findViewById(R.id.changeEmailButton);
        userNewEmail = (TextView) findViewById(R.id.newUserEmail);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Log.d(TAG, "onCreate" + firebaseUser.getEmail());
        changeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmailNew = userNewEmail.getText().toString();
                firebaseUser.updateEmail(userEmailNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UserEmailChange.this, "Email Changed", Toast.LENGTH_SHORT);
                            finish();
                        } else {
                            Toast.makeText(UserEmailChange.this, "Email Update Failed", Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
        });
    }
}
