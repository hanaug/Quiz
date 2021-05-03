package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarinfoAdapter extends RecyclerView.Adapter<CarinfoAdapter.ViewHolder> {
    public  interface contactSelected{
        public void oncontactclick(int index);
    }
    ArrayList<Carinfo> car;
    contactSelected myActivity;
    public CarinfoAdapter(Context context, ArrayList<Carinfo>list){
        car=list;
        myActivity=(contactSelected) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvpersonname;
        TextView tvpersonnum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvpersonname=itemView.findViewById(R.id.cardname);
            tvpersonnum=itemView.findViewById(R.id.cardnumber);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    myActivity.oncontactclick(car.indexOf((car)itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvpersonname.setText(car.get(position).getName());
        holder.tvpersonnum.setText(car.get(position).getPhoneNumber());
        holder.itemView.setTag(car.get(position));
    }

    @Override
    public int getItemCount() {
        return car.size();
    }

}
