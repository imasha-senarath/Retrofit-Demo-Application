package com.example.retrofitdemo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<PostModel>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts")
    Call<List<PostModel>> getPosts(@QueryMap Map<String, String> parameters);

    @GET("posts/{id}/comments")
    Call<List<CommentModel>> getComments(@Path("id") int postId);

    @GET
    Call<List<CommentModel>> getComments(@Url String url);

    @POST("posts")
    Call<PostModel> createPost(@Body PostModel post);

    @FormUrlEncoded
    @POST("posts")
    Call<PostModel> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<PostModel> createPost(@FieldMap Map<String, String> fields);
}
