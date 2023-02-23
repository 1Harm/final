package com.example.booking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.booking.adapter.LoginResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.booking.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CardView plane, book,des;
    LinearLayout lay;
    LoginResponse loginResponse;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lay=findViewById(R.id.lay);
        plane = findViewById(R.id.drinks_menu);
        book = findViewById(R.id.snacks_menu);
        des=findViewById(R.id.destin);
        LinearLayout myOrder = findViewById(R.id.my_order);

        myOrder.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(intent);
        });
        plane.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "plane";
            intent.putExtra("choice", value);
            startActivity(intent);
        });
        des.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DEstination.class);
            String value = "destination";
            intent.putExtra("choice", value);
            startActivity(intent);
        });
        book.setOnClickListener(v -> {Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);startActivity(intent); Toast.makeText(getApplicationContext(), "top up successfully", Toast.LENGTH_SHORT).show();});
    }


}