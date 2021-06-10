package project.bzu.groupassignment2.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import project.bzu.groupassignment2.Models.Item;
import project.bzu.groupassignment2.R;


public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    private List<Item> itemsList;


    public CartItemsAdapter( Context context, List<Item> itemsList) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.itemsList=itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.cart_item_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.item_title.setText(itemsList.get(position).getName());
        holder.item_price.setText(String.valueOf(itemsList.get(position).getPrice()));
        Drawable dr= ContextCompat.getDrawable(context,itemsList.get(position).getImageID());
        holder.item_image.setImageDrawable(dr);
        holder.nis_symbol3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));
        holder.nis_symbol4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.nis_symbol));
        holder.itemQty.setText(String.valueOf(itemsList.get(position).getQuantity()));
        holder.total_cart_value.setText(String.valueOf(itemsList.get(position).getTotalBeforeTax()));

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_title,item_price,itemQty,total_cart_value;
        ImageView item_image,nis_symbol3,nis_symbol4;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title=itemView.findViewById(R.id.title_cart);
            item_price=itemView.findViewById(R.id.price_cart_value);
            itemQty=itemView.findViewById(R.id.item_qty_value);
            item_image=itemView.findViewById(R.id.image_cart);
            nis_symbol3=itemView.findViewById(R.id.nis_symbol3);
            nis_symbol4=itemView.findViewById(R.id.nis_symbol4);
            cardView = itemView.findViewById(R.id.card_cart);
            total_cart_value=itemView.findViewById(R.id.total_cart_value);

        }
    }
}
