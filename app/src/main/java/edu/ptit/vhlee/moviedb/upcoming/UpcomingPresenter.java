package edu.ptit.vhlee.moviedb.upcoming;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;
import edu.ptit.vhlee.moviedb.data.source.repository.MovieRepository;

public class UpcomingPresenter implements UpcomingContract.Presenter {
    private UpcomingContract.View mView;
    private MovieRepository mMovieRepository;

    public UpcomingPresenter(UpcomingContract.View view) {
        this.mMovieRepository = new MovieRepository();
        this.mView = view;
    }

    @Override
    public ArrayList<Movie> getUpcommingMovies(String url) {
        return mMovieRepository.getMoviesDemo(url, new MovieDataSource.Callback() {
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
