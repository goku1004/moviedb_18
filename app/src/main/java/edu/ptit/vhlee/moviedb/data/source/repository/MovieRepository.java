package edu.ptit.vhlee.moviedb.data.source.repository;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;
import edu.ptit.vhlee.moviedb.data.source.remote.MovieRemoteData;

public class MovieRepository {
    private MovieRemoteData mMovieRemoteData;

    public MovieRepository() {
        this.mMovieRemoteData = new MovieRemoteData();
    }

    public ArrayList<Movie> getMoviesDemo(String url, MovieDataSource.Callback callback) {
        return mMovieRemoteData.getMovies(url, callback);
    }
}
