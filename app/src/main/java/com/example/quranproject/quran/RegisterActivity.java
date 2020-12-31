package com.example.quranproject.quran;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.quranproject.Base.BaseActivity;
import com.example.quranproject.R;
import com.example.quranproject.quran.API.Model.AzkarItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends BaseActivity {
    EditText email, password;
    TextView navToLogin;
    Button registerBtn;
    FirebaseAuth mAuth;
    Map<String, String> list = new HashMap<>();

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        navToLogin = findViewById(R.id.navToLogin);
        registerBtn = findViewById(R.id.registerBtn);
        mAuth = FirebaseAuth.getInstance();

        navToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, Login.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isValid() != true) {
                    showMessage("Error", "Enter Valid Data", "Ok");
                    return;
                }
                showProgressBar();
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.e("login", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String email = user.getEmail();
                                    list.put("email", email);
                                    list.put("totalTasbeh", "0");

                                    db.collection("Tasbeh")
                                            .add(list)
                                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                @Override
                                                public void onSuccess(DocumentReference documentReference) {
                                                    Log.e("success", "DocumentSnapshot written with ID: " + documentReference.getId());
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Log.e("fail", "Error adding document", e);
                                                }
                                            });

                                    DataHolder.userName = email;
                                    if (DataHolder.userName.equals(DataHolder.admin)) {
                                        DataHolder.isAdmin = true;
                                    } else DataHolder.isAdmin = false;
                                    startActivity(new Intent(activity, HomeActivity.class));
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.e("FAILED", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//
                                }

                                // ...
                                hideProgressBar();
                            }
                        });
            }
        });


    }

    public boolean isValid() {
        boolean valid = true;
        if (email.getText().toString().length() == 0) {
            valid = false;
            return valid;

        } else if (password.getText().toString().length() == 0) {
            valid = false;
            return valid;
        }
        return valid;
    }
}
