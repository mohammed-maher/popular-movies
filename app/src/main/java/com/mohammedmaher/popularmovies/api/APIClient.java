package com.mohammedmaher.popularmovies.api;
//
//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//
//public interface APIClient{
//    @GET("/movie/popular")
//    Call<ListResults> getPopular(@Query("api_key") String API_KEY);
//    @GET("/movie/top_rated")
//    Call<ListResults> getTopRated(@Query("api_key") String API_KEY);
//    @GET("/movie/{id}")
//    MovieModel getMovieDetails(@Path("id") String id,@Query("api_key") String API_KEY);
//}