package project.bzu.groupassignment2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import project.bzu.groupassignment2.R;

public class ItemAdded extends AppCompatActivity {
    Intent intent,intent2;
    int itemImage;
    double itemPrice;
    String itemName,itemQty;
    ImageView imageAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_added_layout);
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
        itemQty=intent.getExtras().getString("itemQty");
        imageAdded=findViewById(R.id.image_cart);
        imageAdded.setImageDrawable(ContextCompat.getDrawable(this,itemImage));
    }

    public void continueBtnOnClick(View view) {
        intent=new Intent(this,Cart.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemImage1",itemImage);
        Log.d("TAG", "continueBtnOnClick: "+itemImage);
        intent.putExtra("itemPrice1",itemPrice);
        intent.putExtra("itemName1",itemName);
        intent.putExtra("itemQty1",itemQty);
        intent2=new Intent(this,Home.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent2);
    }

    public void checkOutBtnOnClick(View view) {
        intent=new Intent(this,Cart.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("itemImage1",itemImage);
        Log.d("TAG", "checkOutBtnOnClick: "+itemImage);
        intent.putExtra("itemPrice1",itemPrice);
        intent.putExtra("itemName1",itemName);
        intent.putExtra("itemQty1",itemQty);
        this.startActivity(intent);
    }
}