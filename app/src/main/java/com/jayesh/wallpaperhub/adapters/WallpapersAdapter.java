package com.jayesh.wallpaperhub.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jayesh.wallpaperhub.R;
import com.jayesh.wallpaperhub.models.Category;
import com.jayesh.wallpaperhub.models.Wallpaper;

import java.util.List;

public class WallpapersAdapter extends RecyclerView.Adapter<WallpapersAdapter.MyViewHolder> {

    private Context context;
    private List<Wallpaper> wallpaperList;

    public WallpapersAdapter(Context context, List<Wallpaper> wallpaperList) {
        this.context = context;
        this.wallpaperList = wallpaperList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_wallpapers, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Wallpaper w = wallpaperList.get(position);

        holder.textView.setText(w.title);

        Glide.with(context)
                .load(w.url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return wallpaperList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewCategory);
            textView = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
