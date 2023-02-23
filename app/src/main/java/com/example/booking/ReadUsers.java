package com.example.booking;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking.adapter.ReadAdapter;
import com.example.booking.models.DataModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ReadUsers extends AppCompatActivity {

    List<DataModel> dataModals;

    private Realm realm;
    private RecyclerView recyclerView;
    private ReadAdapter readAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_user);
        recyclerView = findViewById(R.id.idRead);
        realm = Realm.getDefaultInstance();
        dataModals = new ArrayList<>();
        prepareRecyclerView();
    }

    private void prepareRecyclerView() {
        dataModals = realm.where(DataModel.class).findAll();
        readAdapter = new ReadAdapter(dataModals, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(readAdapter);
    }
}