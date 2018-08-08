package edu.ptit.vhlee.moviedb.data.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String mVoteCount;
    private String mId;
    private String mVoteAverage;
    private String mTitle;
    private String mPosterPath;
    private String mBackdropPath;
    private String mReleaseDate;
    private String mOverView;

    private Movie(Builder builder) {
        mVoteCount = builder.mVoteCount;
        mId = builder.mId;
        mVoteAverage = builder.mVoteAverage;
        mTitle = builder.mTitle;
        mPosterPath = builder.mPosterPath;
        mBackdropPath = builder.mBackdropPath;
        mReleaseDate = builder.mReleaseDate;
        mOverView = builder.mOverView;
    }

    public static class Builder {
        private String mVoteCount;
        private String mId;
        private String mVoteAverage;
        private String mTitle;
        private String mPosterPath;
        private String mBackdropPath;
        private String mReleaseDate;
        private String mOverView;

        public Builder() {
        }

        public Builder setVoteCount(String voteCount) {
            this.mVoteCount = voteCount;
            return this;
        }

        public Builder setId(String id) {
            this.mId = id;
            return this;
        }

        public Builder setVoteAverage(String voteAverage) {
            this.mVoteAverage = voteAverage;
            return this;
        }

        public Builder setTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder setPosterPath(String posterPath) {
            this.mPosterPath = posterPath;
            return this;
        }

        public Builder setBackdropPath(String backdropPath) {
            this.mBackdropPath = backdropPath;
            return this;
        }

        public Builder setReleaseDate(String releaseDate) {
            this.mReleaseDate = releaseDate;
            return this;
        }

        public Builder setOverView(String overView) {
            this.mOverView = overView;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    public String getVoteCount() {
        return mVoteCount;
    }

    public String getId() {
        return mId;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getOverView() {
        return mOverView;
    }
}
