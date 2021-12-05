package com.course.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText;

        MyViewHolder(View view) {
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
        }
    }

    private ArrayList<Products> myProductsList;
    MyAdapter(ArrayList<Products> products){
        this.myProductsList = products;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.myPicture.setImageResource(myProductsList.get(position).getFirstImage());
        myViewHolder.myText.setText(myProductsList.get(position).getProductName());

        myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), ProductView.class);

                intent.putExtra("ProductName",myProductsList.get(position).getProductName());
                intent.putExtra("FirstImage",myProductsList.get(position).getFirstImage());
                intent.putExtra("SecondImage",myProductsList.get(position).getSecondImage());
                intent.putExtra("Description",myProductsList.get(position).getDescription());
                intent.putExtra("price",myProductsList.get(position).getPrice());
                intent.putExtra("url",myProductsList.get(position).getURL());

                context.startActivity(intent);
            }
        });

        myViewHolder.myText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), ProductView.class);

                intent.putExtra("ProductName",myProductsList.get(position).getProductName());
                intent.putExtra("FirstImage",myProductsList.get(position).getFirstImage());
                intent.putExtra("SecondImage",myProductsList.get(position).getSecondImage());
                intent.putExtra("Description",myProductsList.get(position).getDescription());
                intent.putExtra("price",myProductsList.get(position).getPrice());
                intent.putExtra("url",myProductsList.get(position).getURL());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myProductsList.size();
    }
}
