package project.bzu.groupassignment2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;

import project.bzu.groupassignment2.Adapters.CartItemsAdapter;
import project.bzu.groupassignment2.Adapters.CheckoutItemsAdapter;
import project.bzu.groupassignment2.Models.Item;
import project.bzu.groupassignment2.R;

public class Checkout extends AppCompatActivity {
    Intent intent;
    String itemsString;
    RecyclerView recyclerView;
    ArrayList<Item> cartItemsList;
    CheckoutItemsAdapter adapter;
    Gson gson;
    Item item;
    Double totalPriceBeforeTax,totalPriceAfterTax,subtotal,tax;
    TextView totalBtaxV,taxV,totalAtaxV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_layout);
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
                        startActivity(new Intent(getApplicationContext(), Cart.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        totalBtaxV=findViewById(R.id.totalBtaxV);
        totalAtaxV=findViewById(R.id.totalAtaxV);
        taxV=findViewById(R.id.taxV);

        subtotal=0.0;
        recyclerView=findViewById(R.id.checkout_items);
        cartItemsList=new ArrayList<>();
        gson = new Gson();
        intent=getIntent();
        itemsString=intent.getStringExtra("itemsString");
        String[] itemsList=itemsString.split("#");
        Log.d("TAG", "onCreateasasdas: ");
        for (int i=0;i<itemsList.length;i++){
            item = gson.fromJson(itemsList[i], Item.class);
            subtotal+=item.getTotalBeforeTax();
            Log.d("TAG", "onCreate: "+subtotal);
            cartItemsList.add(item);
        }
        totalPriceBeforeTax=subtotal;
        totalBtaxV.setText(String.valueOf(totalPriceBeforeTax));
        tax=totalPriceBeforeTax*0.14;
        taxV.setText(String.valueOf(tax));
        totalPriceAfterTax=totalPriceBeforeTax+tax;
        totalAtaxV.setText(String.valueOf(totalPriceAfterTax));

        if(cartItemsList.size()!=0){
            Log.d("TAG", "inside if: "+cartItemsList.size());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter=new CheckoutItemsAdapter(getApplicationContext(),cartItemsList);
            recyclerView.setAdapter(adapter);
        }
    }
    public void placeOrder(View view) {
        intent=new Intent(this,Confirmation.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }
}