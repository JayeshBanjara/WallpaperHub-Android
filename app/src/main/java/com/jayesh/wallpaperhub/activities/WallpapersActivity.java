package com.jayesh.wallpaperhub.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jayesh.wallpaperhub.R;
import com.jayesh.wallpaperhub.adapters.WallpapersAdapter;
import com.jayesh.wallpaperhub.models.Wallpaper;

import java.util.ArrayList;
import java.util.List;

public class WallpapersActivity extends AppCompatActivity {

    List<Wallpaper> wallpaperList;
    RecyclerView recyclerView;
    WallpapersAdapter adapter;

    DatabaseReference dbWallpapers;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        wallpaperList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WallpapersAdapter(this, wallpaperList);
        recyclerView.setAdapter(adapter);
        progressBar = findViewById(R.id.progressBar);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(category);
        setSupportActionBar(toolbar);

        dbWallpapers = FirebaseDatabase.getInstance().getReference("images")
                .child(category);
        progressBar.setVisibility(View.VISIBLE);
        dbWallpapers.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.GONE);
                if (dataSnapshot.exists()){
                    for (DataSnapshot wallpaperSnapshot: dataSnapshot.getChildren()){
                        Wallpaper wallpaper = wallpaperSnapshot.getValue(Wallpaper.class);
                        wallpaperList.add(wallpaper);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
