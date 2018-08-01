package edu.ptit.vhlee.moviedb.toprate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ptit.vhlee.moviedb.R;

public class TopRateFragment extends Fragment {

    public TopRateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_rate, container, false);
    }
}
