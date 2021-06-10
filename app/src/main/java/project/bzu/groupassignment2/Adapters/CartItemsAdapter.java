package project.bzu.groupassignment2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

import project.bzu.groupassignment2.Activities.ItemDetails;
import project.bzu.groupassignment2.R;


public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    private String itemName,itemQty;
    private double itemPrice;
    private int itemImagesID;


    public CartItemsAdapter( Context context, String itemName, String itemQty, double itemPrice,int itemImagesID) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.itemName = itemName;
        Log.d("TAG", "CartItemsAdapter:itemName: "+itemName);
        this.itemQty = itemQty;
        Log.d("TAG", "CartItemsAdapter: itemQty:  "+itemQty);
        this.itemPrice = itemPrice;
        Log.d("TAG", "CartItemsAdapter: itemPrice: "+itemPrice);
        this.itemImagesID=itemImagesID;
        Log.d("TAG", "CartItemsAdapter: itemImagesID: "+itemImagesID);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.cart_item_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.item_title.setText(itemName);
        holder.item_price.setText(String.valueOf(itemPrice));
        Drawable dr= ContextCompat.getDrawable(context,itemImagesID);
        holder.item_image.setImageDrawable(dr);
        holder.nis_symbol3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));
        holder.nis_symbol4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_title,item_price,itemQty;
        ImageView item_image,nis_symbol3,nis_symbol4;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title=itemView.findViewById(R.id.title_cart);
            item_price=itemView.findViewById(R.id.price_cart_value);
            itemQty=itemView.findViewById(R.id.qty_cart_value);
            item_image=itemView.findViewById(R.id.image_cart);
            nis_symbol3=itemView.findViewById(R.id.nis_symbol3);
            nis_symbol4=itemView.findViewById(R.id.nis_symbol4);
            cardView = itemView.findViewById(R.id.card_cart);

        }
    }
}
