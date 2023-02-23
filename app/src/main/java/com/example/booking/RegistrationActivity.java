package com.example.booking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.adapter.RegisterRequest;
import com.example.booking.adapter.RegisterResponse;
import com.example.booking.models.ApiClient;
import com.example.booking.models.DataModel;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends Activity {
    private EditText userNameEdt, emailEdt, passwordEdt;
    private Realm realm;
    private String userName, email, password;
    private Button read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        realm = Realm.getDefaultInstance();;
        userNameEdt = findViewById(R.id.userName);
        emailEdt = findViewById(R.id.email);
        passwordEdt = findViewById(R.id.password);
        read = findViewById(R.id.idBtnReadData);
        Button reg = findViewById(R.id.button_reg);
//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                userName = userNameEdt.getText().toString();
//                email = emailEdt.getText().toString();
//                password = passwordEdt.getText().toString();
//                RegisterRequest registerRequest = new RegisterRequest();
//                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(userName)) {
//                    Toast.makeText(RegistrationActivity.this, "Fields shouldn't be empty", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    registerRequest.setEmail(email);
//                    registerRequest.setPassword(password);
//                    registerRequest.setUsername(userName);
//                    registerUser(registerRequest);
////                    Toast.makeText(RegistrationActivity.this, "User registered", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(RegistrationActivity.this,WelcomeActivity.class);
////                    startActivity(intent);
//                }
//            }
//        });
//    }
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = userNameEdt.getText().toString();
                email = emailEdt.getText().toString();
                password = passwordEdt.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    userNameEdt.setError("Please enter username");
                } else if (TextUtils.isEmpty(email)) {
                    emailEdt.setError("Enter email");
                } else if (TextUtils.isEmpty(password)) {
                    passwordEdt.setError("Enter password");
                }  else {
                    addDataToDatabase(userName, email, password);
                    Toast.makeText(RegistrationActivity.this, "User registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistrationActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, ReadUsers.class);
                startActivity(i);
            }
        });
    }


    private void addDataToDatabase(String userName, String email, String password) {
        DataModel modal = new DataModel();

        Number id = realm.where(DataModel.class).max("id");
        long nextId;
        if (id == null) {
            nextId = 1;
        } else {
            nextId = id.intValue() + 1;
        }
        modal.setId(nextId);
        modal.setEmail(email);
        modal.setUserName(userName);
        modal.setPassword(password);
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(modal);
            }
        });

//    public void registerUser(RegisterRequest registerRequest){
//        Call<RegisterResponse> registerResponseCall= ApiClient.getService().registerUser(registerRequest);
//        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
//            @Override
//            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//            if(response.isSuccessful()){
//                String message="Registration Successful";
//                Toast.makeText(RegistrationActivity.this,message,Toast.LENGTH_LONG).show();
//                startActivity(new Intent(RegistrationActivity.this,WelcomeActivity.class));
//                finish();
//            }
//            else{
//                String message="Error, try again";
//                Toast.makeText(RegistrationActivity.this,message,Toast.LENGTH_LONG).show();
//            }
//            }
//
//            @Override
//            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                String message=t.getLocalizedMessage();
//                Toast.makeText(RegistrationActivity.this,message,Toast.LENGTH_LONG).show();
//
//            }
//        });

    }
}
