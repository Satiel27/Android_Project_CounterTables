package com.novikov.cuintertables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterAllCounters extends RecyclerView.Adapter<AdapterAllCounters.CounterVievHolder> {

    private int numberOfItems;

    public AdapterAllCounters(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @NonNull
    @Override
    public CounterVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.adaptercounter_layaout;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        CounterVievHolder counterVievHolder = new CounterVievHolder(view);
        counterVievHolder.name.setText("Таблетка");

        return counterVievHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CounterVievHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class CounterVievHolder extends RecyclerView.ViewHolder {

        private TextView name, number;

        public CounterVievHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_vievHolder_NameCounter);
            number = itemView.findViewById(R.id.tv_vievHolder_NumberCounter);

        }

        public void bind(int listIndex) {
            number.setText(String.valueOf(listIndex));
        }


    }

}
