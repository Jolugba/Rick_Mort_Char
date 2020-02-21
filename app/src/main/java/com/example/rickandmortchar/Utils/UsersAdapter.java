package com.example.rickandmortchar.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickandmortchar.Model.Result;
import com.example.rickandmortchar.R;


import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    Context context;
    List<Result> listOfUsers;


    public UsersAdapter(Context context, List<Result> listOfUsers) {
        this.context = context;
        this.listOfUsers = listOfUsers;
    }
    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_charcters, parent, false);
         return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder myViewHolder, int i) {
        Result currentUser = listOfUsers.get(i);
        myViewHolder.textView.setText(currentUser.getName());
         Glide.with(context)
           .load(currentUser.getImage())
                 .centerCrop()
           .placeholder(R.drawable.birthday)
         .into(myViewHolder.circleImageView);

        myViewHolder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context," I'm cute right, you are too!!!  ",Toast.LENGTH_SHORT).show();

            }
        });
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Nice to meet you   ",Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return listOfUsers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        de.hdodenhof.circleimageview.CircleImageView circleImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            circleImageView = itemView.findViewById(R.id.characterPicture);

        }


    }
}

