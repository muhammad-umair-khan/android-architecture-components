package com.kstechsolutions.mvvm.data.network;

import com.kstechsolutions.mvvm.modules.comments.model.Comment;
import com.kstechsolutions.mvvm.modules.posts.model.Photo;
import com.kstechsolutions.mvvm.modules.posts.model.Post;


import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("posts")
    Observable<ArrayList<Post>> getPosts();

    @GET("photos")
    Observable<ArrayList<Photo>> getPhotos();

    @GET("posts/{id}/comments")
    Single<ArrayList<Comment>> getPostComments(@Path("id") int id);
}
