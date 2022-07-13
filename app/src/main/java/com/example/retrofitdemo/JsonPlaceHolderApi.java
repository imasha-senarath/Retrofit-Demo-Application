package com.example.retrofitdemo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @Headers({"Static-Header1: 123", "Static-Header2: 456"})
    @PUT("posts/{id}")
    Call<PostModel> putPost(@Header("Dynamic-Header") String header,
                       @Path("id") int id,
                       @Body PostModel post);

    @PATCH("posts/{id}")
    Call<PostModel> patchPost(@HeaderMap Map<String, String> headers,
                         @Path("id") int id,
                         @Body PostModel post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
