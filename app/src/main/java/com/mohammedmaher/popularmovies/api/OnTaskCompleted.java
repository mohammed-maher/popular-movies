package com.mohammedmaher.popularmovies.api;

public interface OnTaskCompleted {
    void onFetchMoviesTaskCompleted(Movie[] movies);
}
