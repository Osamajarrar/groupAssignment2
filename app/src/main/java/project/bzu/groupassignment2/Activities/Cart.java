package project.bzu.groupassignment2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;



import java.util.ArrayList;
import java.util.Arrays;


import project.bzu.groupassignment2.Adapters.CartItemsAdapter;

import project.bzu.groupassignment2.Models.Item;
import project.bzu.groupassignment2.R;

public class Cart extends AppCompatActivity {

    String json;
    CartItemsAdapter adapter;
    RecyclerView recyclerView;
    Item item,item2;
    Intent intent;
    Button next;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String CARTPREFS = "cartPrefs" ;
    Gson gson;
    ArrayList<Item> cartItemsList;
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
        cartItemsList=new ArrayList<>();
        setUpSharedPrefs();
        next=findViewById(R.id.next);
        gson = new Gson();
        json = sharedPreferences.getString(CARTPREFS, "");
        String[] jsonArr=json.split("#");
        Log.d("TAG", "onCreateasasdas: "+ Arrays.toString(jsonArr));
        for (int i=0;i<jsonArr.length;i++){
            item2 = gson.fromJson(jsonArr[i], Item.class);
            cartItemsList.add(item2);
        }
        if(cartItemsList.size()>=1 && cartItemsList.get(0)!=null){
            next.setVisibility(View.VISIBLE);
            Log.d("TAG", "inside if: "+cartItemsList.size());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter=new CartItemsAdapter(getApplicationContext(),cartItemsList);
            recyclerView.setAdapter(adapter);
        }else{
            next.setVisibility(View.GONE);
        }
    }
    private void setUpSharedPrefs(){
        sharedPreferences= getSharedPreferences(CARTPREFS, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }


    public void nextOnClick(View view) {
        intent=new Intent(this,Checkout.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemsString",json);
        this.startActivity(intent);
    }


}