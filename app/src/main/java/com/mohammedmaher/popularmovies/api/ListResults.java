package com.mohammedmaher.popularmovies.api;

import java.util.List;

public class ListResults {
    List<MovieModel> results;
    int page;

    public ListResults(List<MovieModel> results, int page) {
        this.results = results;
        this.page = page;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
