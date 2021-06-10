package project.bzu.groupassignment2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import project.bzu.groupassignment2.R;

public class ItemDetails extends AppCompatActivity {
    Intent intent;
    ImageView item_image_preview,star1_preview,star2_preview,star3_preview,star4_preview,star5_preview,nis_symbol2;
    TextView item_title_preview,item_price_preview;
    Spinner quantity_spinner;
    int itemImage;
    double itemPrice;
    String itemName,itemRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details_layout);
        BottomNavigationView BottomNavigationView =findViewById(R.id.bottomNavigationView);
        BottomNavigationView.setSelectedItemId(R.id.homepage);
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
        intent=getIntent();
        itemImage=(int)intent.getExtras().get("itemImage");
        itemPrice=(double)intent.getExtras().get("itemPrice");
        itemName=intent.getExtras().getString("itemName");
        itemRating=intent.getExtras().getString("itemRating");
        item_image_preview=findViewById(R.id.item_image_preview);
        star1_preview=findViewById(R.id.star1_preview);
        star2_preview=findViewById(R.id.star2_preview);
        star3_preview=findViewById(R.id.star3_preview);
        star4_preview=findViewById(R.id.star4_preview);
        star5_preview=findViewById(R.id.star5_preview);
        nis_symbol2=findViewById(R.id.nis_symbol2);
        item_title_preview=findViewById(R.id.item_title_preview);
        item_price_preview=findViewById(R.id.item_price_preview);
        quantity_spinner=findViewById(R.id.quantity_spinner);

        item_image_preview.setImageDrawable(ContextCompat.getDrawable(this,itemImage));
        item_title_preview.setText(itemName);
        if(itemRating.equals("1")){
            star1_preview.setVisibility(View.VISIBLE);
            star1_preview.setImageResource(R.drawable.ic_baseline_star_24);
        }else if (itemRating.equals("2")){
            star1_preview.setVisibility(View.VISIBLE);
            star1_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star2_preview.setVisibility(View.VISIBLE);
            star2_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
        }
        else if (itemRating.equals("3")){
            star1_preview.setVisibility(View.VISIBLE);
            star1_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star2_preview.setVisibility(View.VISIBLE);
            star2_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star3_preview.setVisibility(View.VISIBLE);
            star3_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
        }
        else if (itemRating.equals("4")){
            star1_preview.setVisibility(View.VISIBLE);
            star1_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star2_preview.setVisibility(View.VISIBLE);
            star2_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star3_preview.setVisibility(View.VISIBLE);
            star3_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star4_preview.setVisibility(View.VISIBLE);
            star4_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
        }else if (itemRating.equals("5")){
            star1_preview.setVisibility(View.VISIBLE);
            star1_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star2_preview.setVisibility(View.VISIBLE);
            star2_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star3_preview.setVisibility(View.VISIBLE);
            star3_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star4_preview.setVisibility(View.VISIBLE);
            star4_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
            star5_preview.setVisibility(View.VISIBLE);
            star5_preview.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_star_24));
        }
        item_price_preview.setText(String.valueOf(itemPrice));
        nis_symbol2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.nis_symbol));
        populateSpinner();
    }
    private void populateSpinner() {
        String[] qty={"1","2","3"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,qty);

        quantity_spinner.setAdapter(adapter);
    }

    public void addToCartOnClick(View view) {
        intent=new Intent(this,ItemAdded.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemImage",itemImage);
        intent.putExtra("itemName",itemName);
        intent.putExtra("itemPrice",itemPrice);
        intent.putExtra("itemQty",  quantity_spinner.getSelectedItem().toString());
        Log.d("TAG", "addToCartOnClick: "+quantity_spinner.getSelectedItem().toString());
        Log.d("TAG", "addToCartOnClick: "+itemImage);
        this.startActivity(intent);
    }
}