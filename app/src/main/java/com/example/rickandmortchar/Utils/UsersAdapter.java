package com.example.rickandmortchar.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.rickandmortchar.Model.CharacterNames;

import com.example.rickandmortchar.Model.Result;
import com.example.rickandmortchar.R;


import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    Context context;
    List<CharacterNames> listOfUsers;
    LayoutInflater inflater;
    private Object Result;
    //ArrayList<Information> data; //dummy data

    public UsersAdapter(Context context, List<CharacterNames> listOfUsers) {
        this.context = context;
        this.listOfUsers = listOfUsers;
    }
    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_charcters, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder myViewHolder, int i) {
        CharacterNames currentUser = listOfUsers.get(i);
        myViewHolder.textView.setText(currentUser.getClass().getName());
        myViewHolder.circleImageView.setImageResource(R.drawable.birthday);
        // Glide.with(context)
        //   .load(circleImageView.getDrawable())
        //   .placeholder(R.drawable.birthday)
        // .into(circleImageView);
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

