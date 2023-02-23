package com.example.booking;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DEstination extends ListActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.des);

            AlertDialog.Builder builder1 = new AlertDialog.Builder(DEstination.this);
            builder1.setMessage("Choose your Destination !");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder1.show();
            String[] values = new String[] { "USA", "India", "Tailand","Korea", "Switzerland", "Canada","France", "Italy", "Turkey" ,"Spain","United Kingdom","Mexico","Kazakstan"};
            DestinationAdapter adapter = new DestinationAdapter(this, values);
            setListAdapter(adapter);


        }






    }

