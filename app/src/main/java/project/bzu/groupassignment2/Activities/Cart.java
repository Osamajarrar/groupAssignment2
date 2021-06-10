package project.bzu.groupassignment2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import project.bzu.groupassignment2.Adapters.CartItemsAdapter;
import project.bzu.groupassignment2.Adapters.HomeItemsAdapter;
import project.bzu.groupassignment2.Models.Item;
import project.bzu.groupassignment2.R;

public class Cart extends AppCompatActivity {
    Intent intent;
    int itemImage;
    double itemPrice;
    String itemName,itemQty;
    CartItemsAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.cart);
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.cart:
                        return true;
                }
                return false;
            }
        });
        recyclerView=findViewById(R.id.cart_items);
        items=new ArrayList<>();

        intent=getIntent();
        if (intent==null){
            Log.d("TAG", "onCreate: nullllllll");
        }
        itemImage=(int)intent.getExtras().get("itemImage1");
        Log.d("TAG", "onCreate: "+itemImage);
        itemPrice=(double)intent.getExtras().get("itemPrice1");
        itemName=intent.getExtras().getString("itemName1");
        Log.d("TAG", "onCreate: "+itemName);
        itemQty=intent.getExtras().getString("itemQty1");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CartItemsAdapter(getApplicationContext(),itemName,itemQty,itemPrice,itemImage);
        recyclerView.setAdapter(adapter);
    }
}