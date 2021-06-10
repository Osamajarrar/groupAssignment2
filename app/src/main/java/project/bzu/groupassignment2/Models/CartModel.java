package project.bzu.groupassignment2.Models;

import java.util.ArrayList;

public class CartModel {
    public ArrayList<Item> itemArrayList;

    public CartModel() {
        this.itemArrayList = new ArrayList<Item>();
    }

    public CartModel(ArrayList<Item> itemArrayList) {
        this.itemArrayList = new ArrayList<Item>();
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @Override
    public String toString() {
        return "Cart{" + itemArrayList.toString() +
                '}';
    }
}
