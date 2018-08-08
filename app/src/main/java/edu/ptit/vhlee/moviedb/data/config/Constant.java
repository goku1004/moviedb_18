package edu.ptit.vhlee.moviedb.data.config;

import edu.ptit.vhlee.moviedb.BuildConfig;

public interface Constant {

    interface Common {
        String LANGUAGE_ENG = "en-US";
        String TYPE_NOWPLAYING = "now_playing";
        String TYPE_POPULAR = "popular";
        String TYPE_TOP_RATE = "top_rated";
        String TYPE_UPCOMING = "upcoming";
        String URL_BASE = "https://api.themoviedb.org/3/movie/";
        String URL_KEY = "?api_key=";
        String URL_LANGUAGE = "&language=";
        String URL_PAGE = "&page=";
        String URL_IMGE = "https://image.tmdb.org/t/p/w500";
        String API_KEY = BuildConfig.API_KEY;
        String RESULT = "results";
        String TITLE = "title";
        String POSTER_PATH = "poster_path";
        String MSG_NO_RESULT = "Cannot load data";
        int NUM_SPAN = 3;
        int TOTAL_PAGE = 3;
    }
    interface Url {
        String URL = Common.URL_BASE + "%s" + Common.URL_KEY
                + Common.API_KEY + Common.URL_LANGUAGE + "%s" + Common.URL_PAGE+"%d";
    }
}
