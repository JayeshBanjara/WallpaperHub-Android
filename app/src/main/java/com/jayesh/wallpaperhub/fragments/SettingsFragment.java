package com.jayesh.wallpaperhub.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jayesh.wallpaperhub.R;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {

    View rootview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            return inflater.inflate(R.layout.fragment_home, container, false);
        }

        return rootview;
    }
}
