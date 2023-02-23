package com.example.booking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking.adapter.ListItemAdapter;
import com.example.booking.models.Item;
import com.example.booking.models.ItemData;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ImageView back_btn = findViewById(R.id.back_buttons);
        back_btn.setOnClickListener(v -> {
            finish();
        });

        Intent intent = getIntent();
        String choice = intent.getStringExtra("choice");

        LinearLayout myOrder = findViewById(R.id.my_order);
        myOrder.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(i);
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        if (choice.equals("plane")) {
            items.addAll(ItemData.getList());
            showRecyclerView(choice);

        }
    }

    private void showRecyclerView(String choice) {
        ListItemAdapter adapter = new ListItemAdapter(items);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new ListItemAdapter.Listener() {
            @Override
            public void onClick(Item data) {
                Intent intent = new Intent(getApplicationContext(), ItemOrderActivity.class);
                intent.putExtra(ItemOrderActivity.ORDER_ITEM, data);
                startActivity(intent);
            }
        });}
}