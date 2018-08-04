package edu.ptit.vhlee.moviedb.data.source.local;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.config.DataCallback;
import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;

public class LocalMovieDataSource implements MovieDataSource {

    @Override
    public ArrayList<Movie> getMovies(String url, Callback<ArrayList<Movie>> callback) {
        return null;
    }
}
