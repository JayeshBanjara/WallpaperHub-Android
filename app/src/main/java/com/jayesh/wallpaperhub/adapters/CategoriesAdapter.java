package com.jayesh.wallpaperhub.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jayesh.wallpaperhub.R;
import com.jayesh.wallpaperhub.activities.WallpapersActivity;
import com.jayesh.wallpaperhub.models.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public CategoriesAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_categories, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Category c = categoryList.get(position);

        holder.textView.setText(c.name);

        Glide.with(context)
                .load(c.thumb)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewCategory);
            textView = itemView.findViewById(R.id.textViewCategoryName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Category category = categoryList.get(pos);

            Intent intent = new Intent(context, WallpapersActivity.class);
            intent.putExtra("category", category.name);
            context.startActivity(intent);
        }
    }
}
