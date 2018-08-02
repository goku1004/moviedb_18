package edu.ptit.vhlee.moviedb.popular;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ptit.vhlee.moviedb.R;

public class PopularFragment extends Fragment {
    public PopularFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_popular, container, false);
    }
}
