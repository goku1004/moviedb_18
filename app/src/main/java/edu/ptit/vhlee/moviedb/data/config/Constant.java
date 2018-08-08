package edu.ptit.vhlee.moviedb.data.config;

import edu.ptit.vhlee.moviedb.BuildConfig;

public class Constant {

    public class Common {
        public static final String URL_IMGE = "https://image.tmdb.org/t/p/w500";
        public static final String API_KEY = BuildConfig.API_KEY;
        public static final String URL_API = "https://api.themoviedb.org/3/movie/upcoming?api_key="
                + API_KEY + "&language=en-US&page=";
        public static final String RESULT = "results";
        public static final String TITLE = "title";
        public static final String POSTER_PATH = "poster_path";
        public static final String MSG_NO_RESULT = "Cannot load data";
        public static final int NUM_SPAN = 3;
        public static final int TOTAL_PAGE = 3;

    }
}
