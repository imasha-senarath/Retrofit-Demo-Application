package com.example.retrofitdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.PostViewHolder>{
    private Context mContext;
    private ArrayList<Post> mPostArrayList;

    public Adapter(Context context, ArrayList<Post> postArrayList) {
        mContext = context;
        mPostArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = mPostArrayList.get(position);

        String text = post.getText();

        holder.text.setText(text);
    }

    @Override
    public int getItemCount() {
        return mPostArrayList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.row_text);
        }
    }
}
