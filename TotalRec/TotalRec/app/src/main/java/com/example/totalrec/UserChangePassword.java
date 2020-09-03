package com.example.totalrec;

import android.os.Bundle;
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

public class UserChangePassword extends AppCompatActivity {
    private String TAG = "UserChangePassword";
    private TextView userNewPassword;
    private Button changePassword;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_change_password);
        changePassword = (Button) findViewById(R.id.changePasswordButton);
        userNewPassword = (TextView) findViewById(R.id.newUserPassword);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null){

        }
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPasswordNew = userNewPassword.getText().toString();
                firebaseUser.updatePassword(userPasswordNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UserChangePassword.this, "Password Changed", Toast.LENGTH_SHORT);
                            finish();
                        } else {
                            Toast.makeText(UserChangePassword.this, "Password Update Failed", Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
        });
    }
}
