//package com.example.mighty.journalapplication;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//public class LoginActivity extends AppCompatActivity {
//
//    private EditText mEmail;
//    private EditText mPassword;
//    private Button mLoginButton;
//
//    //ProgressDialog
//    private ProgressDialog mLoginProgress;
//
//    //Firebase Auth
//    private FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        getSupportActionBar().setTitle("Login In");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        mLoginProgress = new ProgressDialog(this);
//
//        //Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//
//        //Registration fields
//        mEmail = findViewById(R.id.email_login);
//        mPassword = findViewById(R.id.password_login);
//        mLoginButton = findViewById(R.id.button_login);
//
//        mLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String email = mEmail.getText().toString().trim();
//                String password = mPassword.getText().toString().trim();
//
//                if ((!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password))){
//
//                    mLoginProgress.setTitle("Logging in");
//                    mLoginProgress.setMessage("Please wait while we check your credentials! \nThank you!");
//                    mLoginProgress.setCanceledOnTouchOutside(false);
//                    mLoginProgress.show();
//
//                    loginUser(email, password);
//                }
//            }
//        });
//    }
//
//    private void loginUser(String email, String password) {
//
//        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                if (task.isSuccessful()){
//                    mLoginProgress.dismiss();
//                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
//                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(mainIntent);
//                    finish();
//                } else {
//                    mLoginProgress.hide();
//                    Toast.makeText(LoginActivity.this, "Cannot Sign in. Please check the form and " +
//                            "try again.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
//}
