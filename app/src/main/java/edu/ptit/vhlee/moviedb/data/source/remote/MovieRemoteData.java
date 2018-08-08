package edu.ptit.vhlee.moviedb.data.source.remote;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.config.Constant;
import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;

public class MovieRemoteData implements MovieDataSource {
    private ArrayList<Movie> mMovies;

    public MovieRemoteData() {
        mMovies = new ArrayList<>();
    }

    @Override
    public ArrayList<Movie> getMovies(String url, final Callback<ArrayList<Movie>> callback) {
        new BaseAsyncTask(new Callback<String>() {
            @Override
            public void onStart() {
                callback.onStart();
            }

            @Override
            public void onSuccess(String data) {
                Movie.Builder builder = new Movie.Builder();
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray arrJsonArrays = jsonObject.getJSONArray(Constant.Common.RESULT);
                    for (int i = 0; i < arrJsonArrays.length(); i++) {
                        JSONObject arr = arrJsonArrays.getJSONObject(i);
                        Movie movie = builder.setTitle(arr.getString(Constant.Common.TITLE))
                                .setBackdropPath(arr.getString(Constant.Common.POSTER_PATH))
                                .build();
                        mMovies.add(movie);
                    }
                    callback.onSuccess(mMovies);
                } catch (JSONException e) {
                    callback.onFail(e);
                }
            }

            @Override
            public void onFail(Exception exception) {
                callback.onFail(exception);
            }

            @Override
            public void onComplete() {
                callback.onComplete();
            }
        }).execute(url);
        return mMovies;
    }
}
