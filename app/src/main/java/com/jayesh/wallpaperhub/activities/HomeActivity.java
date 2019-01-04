package com.jayesh.wallpaperhub.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jayesh.wallpaperhub.R;
import com.jayesh.wallpaperhub.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //loading home fragment by default
        displayFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment;

        switch (menuItem.getItemId()) {

            case R.id.nav_home:
                fragment = new HomeFragment();
                break;

            case R.id.nav_favorites:
                fragment = new HomeFragment();
                break;

            case R.id.nav_settings:
                fragment = new HomeFragment();
                break;

            default:
                fragment = new HomeFragment();
                break;
        }

        displayFragment(fragment);

        return true;
    }

    private void displayFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_area, fragment)
                .commit();

    }
}
