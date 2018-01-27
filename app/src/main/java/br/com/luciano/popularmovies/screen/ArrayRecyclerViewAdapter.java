package br.com.luciano.popularmovies.screen;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class ArrayRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> items;

    public ArrayRecyclerViewAdapter(@Nullable List<T> items) {
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
    }


    public List<T> getItems() {
        return items;
    }

    @Nullable
    public T getItem(int position) {
        if (items == null) {
            return null;
        }
        if (position < 0 || position > items.size()) {
            return null;
        }
        return items.get(position);
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        items = new ArrayList<>();
    }

}
