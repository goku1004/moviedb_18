package edu.ptit.vhlee.moviedb.upcoming;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.R;
import edu.ptit.vhlee.moviedb.data.config.Constant;
import edu.ptit.vhlee.moviedb.data.model.Movie;

public class UpcomingFragment extends Fragment implements UpcomingContract.View {
    private RecyclerView recyclerView;
    private UpcomingPresenter mUpcomingPresenter;

    public UpcomingFragment() {
        mUpcomingPresenter = new UpcomingPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        init(view);
        getDataPage();
        return view;
    }

    public void init(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
    }

    public void getDataPage() {
        int pageNum = 0;
        while (pageNum < Constant.Common.TOTAL_PAGE) {
            mUpcomingPresenter.getUpcommingMovies(Constant.Common.URL_API
                    + String.valueOf(++pageNum));
        }
    }

    public void initAdapter(ArrayList<Movie> movies){
        UpcommingAdapter upcommingAdapter = new UpcommingAdapter(getActivity(), movies);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getActivity(), Constant.Common.NUM_SPAN);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(upcommingAdapter);
        upcommingAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoResult(ArrayList<Movie> movies, Exception ex) {
        Toast.makeText(getActivity(),Constant.Common.MSG_NO_RESULT,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccess(ArrayList<Movie> movies) {
       initAdapter(movies);
    }
}

