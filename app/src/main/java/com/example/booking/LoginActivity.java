package com.example.booking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.adapter.LoginRequest;
import com.example.booking.adapter.LoginResponse;
import com.example.booking.adapter.RegisterRequest;
import com.example.booking.adapter.RegisterResponse;
import com.example.booking.models.ApiClient;
import com.example.booking.models.DataModel;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    private EditText userNameEdt, emailEdt, passwordEdt;
    private Realm realm;
    private String userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        realm = Realm.getDefaultInstance();
        userNameEdt = findViewById(R.id.editTextUserNameToLogin);
        passwordEdt = findViewById(R.id.editTextPasswordToLogin);
        TextView reg=findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
                                   }
                               });
        Button log = findViewById(R.id.buttonS);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = userNameEdt.getText().toString();
                password = passwordEdt.getText().toString();
                DataModel dataModel= new DataModel();
                String user=dataModel.getUserName();
                String passwords=dataModel.getPassword();
                if (TextUtils.isEmpty(password) || TextUtils.isEmpty(userName)) {
                    Toast.makeText(LoginActivity.this, "Fields shouldn't be empty", Toast.LENGTH_SHORT).show();

                } else {
                    if (user == userName && passwords == password) {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

//                    LoginRequest loginRequest = new LoginRequest();
//                    loginRequest.setUsername(userName);
//                    loginRequest.setPassword(password);
//                    loginUser(loginRequest);
//                    Toast.makeText(RegistrationActivity.this, "User registered", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(RegistrationActivity.this,WelcomeActivity.class);
//                    startActivity(intent);
                }

        }});
        }



public void loginUser(LoginRequest loginRequest){
    Call<LoginResponse> loginResponseCall= ApiClient.getService().loginUser(loginRequest);

    loginResponseCall.enqueue(new Callback<LoginResponse>() {
        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            if(response.isSuccessful()){
                LoginResponse loginResponse=response.body();
                startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("data",loginResponse));
                finish();
            }
            else{
                String message="Authorization successful";
                LoginResponse loginResponse=response.body();
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtra("data",loginResponse));
                finish();
            }
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            String message=t.getLocalizedMessage();
            Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();

        }
    });

}
}