package com.mohammedmaher.popularmovies;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mohammedmaher.popularmovies.Utils.DateTimeHelper;
import com.mohammedmaher.popularmovies.api.Movie;
import com.squareup.picasso.Picasso;

import java.text.ParseException;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        TextView tvOriginalTitle = findViewById(R.id.textview_original_title);
        ImageView ivPoster =  findViewById(R.id.imageview_poster);
        TextView tvOverView =  findViewById(R.id.textview_overview);
        TextView tvVoteAverage =  findViewById(R.id.textview_vote_average);
        TextView tvReleaseDate = findViewById(R.id.textview_release_date);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra(getString(R.string.parcel_movie));

        tvOriginalTitle.setText(movie.getOriginalTitle());

        Picasso.get().load(movie.getPosterPath())
                .resize(getResources().getInteger(R.integer.tmdb_poster_w185_width),
                        getResources().getInteger(R.integer.tmdb_poster_w185_height))
                .error(R.drawable.not_found)
                .placeholder(R.drawable.searching)
                .into(ivPoster);

        String overView = movie.getOverview();
        if (overView == null) {
            tvOverView.setTypeface(null, Typeface.ITALIC);
            overView = getResources().getString(R.string.no_summary_found);
        }
        tvOverView.setText(overView);
        tvVoteAverage.setText(movie.getDetailedVoteAverage());

        String releaseDate = movie.getReleaseDate();
        if (releaseDate != null) {
            try {
                releaseDate = DateTimeHelper.getLocalizedDate(this,
                        releaseDate, movie.getDateFormat());
            } catch (ParseException e) {
            }
        } else {
            tvReleaseDate.setTypeface(null, Typeface.ITALIC);
            releaseDate = getResources().getString(R.string.no_release_date_found);
        }
        tvReleaseDate.setText(releaseDate);
    }
}