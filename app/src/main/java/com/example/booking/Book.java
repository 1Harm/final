package com.example.booking;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Book extends AppCompatActivity {
    EditText dates,datea;
    DatePickerDialog datePickerDialog1,datePickerDialog2;
    Spinner spinner1,spinner2;
    String dep,dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        spinner1 = (Spinner) findViewById(R.id.spinnerDep);
        spinner2 = (Spinner) findViewById(R.id.spinnerDest);

        // initiate the date picker and a button

        dates = (EditText) findViewById(R.id.dateStart);
        // perform click event on edit text
        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // date picker dialog
                datePickerDialog1 = new DatePickerDialog(Book.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(android.widget.DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                dates.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                datePickerDialog1.show();
            }
        });

        datea = (EditText) findViewById(R.id.dateAnd);
        // perform click event on edit text
        datea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c1 = Calendar.getInstance();
                int year1 = c1.get(Calendar.YEAR);
                int month1 = c1.get(Calendar.MONTH);
                int day1 = c1.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog2 = new DatePickerDialog(Book.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                datea.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);


                            }
                        }, year1, month1,day1);
                datePickerDialog2.show();
            }
        });



    }


    public void Book_it(View v)
    {


        dep=String.valueOf(spinner1.getSelectedItem());
        dest=String.valueOf(spinner2.getSelectedItem());
        String DateDest=dates.getText().toString();
        String DateDep=datea.getText().toString();

        //test
        if(dep.length()==0 || dest.length()==0 || DateDep.length()==0 || DateDest.length()==0)
        {
            //AlertDialog
            AlertDialog.Builder builder1 = new AlertDialog.Builder(Book.this);
            builder1.setMessage("Fill all the informations !");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder1.show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Flight Booked !",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), CompleteOrderActivity.class);
            startActivity(intent);
        }


    }

}
