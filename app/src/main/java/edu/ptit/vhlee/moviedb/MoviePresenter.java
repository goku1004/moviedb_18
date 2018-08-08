package edu.ptit.vhlee.moviedb;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;
import edu.ptit.vhlee.moviedb.data.source.repository.MovieRepository;

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View mView;
    private MovieRepository mMovieRepository;

    public MoviePresenter(MovieContract.View view) {
        this.mMovieRepository = new MovieRepository();
        this.mView = view;
    }

    @Override
    public ArrayList<Movie> getUpcommingMovies(String url) {
        return mMovieRepository.getMovies(url, new MovieDataSource.Callback() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(Object data) {
                mView.showSuccess((ArrayList<Movie>) data);
            }

            @Override
            public void onFail(Exception exception) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
