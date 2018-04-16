package com.kstechsolutions.mvvm.modules.posts.data;

import com.kstechsolutions.mvvm.data.network.ApiInterface;
import com.kstechsolutions.mvvm.modules.base.BaseApiService;
import com.kstechsolutions.mvvm.modules.posts.model.Photo;
import com.kstechsolutions.mvvm.modules.posts.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class PostApiService extends BaseApiService {
    @Inject
    Retrofit retrofit;

    public PostApiService() {
        getApiComponent().inject(this);
    }

    public Observable<ArrayList<Post>> getPosts() {
        return retrofit.create(ApiInterface.class).getPosts();
    }

    public Observable<ArrayList<Photo>> getPhotos() {
        return retrofit.create(ApiInterface.class).getPhotos();
    }
}
