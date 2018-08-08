package edu.ptit.vhlee.moviedb;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;

public interface MovieContract {
    interface Presenter {
        ArrayList<Movie> getUpcommingMovies(String url);
    }

    interface View {
        void showNoResult(ArrayList<Movie> movies, Exception ex);

        void showSuccess(ArrayList<Movie> movies);
    }
}
