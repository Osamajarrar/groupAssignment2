package project.bzu.groupassignment2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import project.bzu.groupassignment2.Adapters.CartItemsAdapter;
import project.bzu.groupassignment2.Adapters.HomeItemsAdapter;
import project.bzu.groupassignment2.Models.CartModel;
import project.bzu.groupassignment2.Models.Item;
import project.bzu.groupassignment2.R;

public class Cart extends AppCompatActivity {

    int itemImage;
    double itemPrice;
    String itemName,itemQty;
    CartItemsAdapter adapter;
    RecyclerView recyclerView;
    Item item;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String CARTPREFS = "cartPrefs" ;
    Gson gson;
    CartModel cartObject;
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

        setUpSharedPrefs();

        itemImage = sharedPreferences.getInt("itemImageToItemAdded2",0);
        itemPrice = (double) sharedPreferences.getFloat("itemPriceToItemAdded2",0);
        itemName = sharedPreferences.getString("itemNameToItemAdded2","");
        itemQty = sharedPreferences.getString("itemQtyToItemAdded2","");
        item=new Item(itemName,itemPrice,Integer.parseInt(itemQty),itemImage);
        Log.d("TAG", "itemCreation: "+item.toString());

        gson = new Gson();
        String json = sharedPreferences.getString(CARTPREFS, "");
        cartObject = gson.fromJson(json, CartModel.class);
        Log.d("TAG", "onCreate: "+cartObject.itemArrayList);


        if(cartObject.itemArrayList.size()!=0){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CartItemsAdapter(getApplicationContext(),cartObject.itemArrayList);
        recyclerView.setAdapter(adapter);
        }


    }
    private void setUpSharedPrefs(){
        sharedPreferences= getSharedPreferences(CARTPREFS, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

}