package com.mohammedmaher.popularmovies.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class MovieModel implements Parcelable {
    private String title;
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("release_date")
    private String releaseDate;

    private String id;
    private int runtime;

    private String cachedPosterPath;

    protected MovieModel(Parcel p){
        id=p.readString();
        title=p.readString();
        overview=p.readString();
        posterPath=p.readString();
        voteAverage=p.readString();
        releaseDate=p.readString();
        runtime=p.readByte();
        cachedPosterPath=p.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public MovieModel createFromParcel(Parcel in){
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int i) {
            return new MovieModel[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getCachedPosterPath() {
        return cachedPosterPath;
    }

    public void setCachedPosterPath(String cachedPosterPath) {
        this.cachedPosterPath = cachedPosterPath;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
        parcel.writeString(voteAverage);
        parcel.writeString(releaseDate);
        parcel.writeInt(runtime);
        parcel.writeString(cachedPosterPath);
    }
}
