package com.kstechsolutions.mvvm.modules.comments.data;

import com.kstechsolutions.mvvm.data.network.ApiInterface;
import com.kstechsolutions.mvvm.modules.base.BaseApiService;
import com.kstechsolutions.mvvm.modules.comments.model.Comment;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class CommentApiService extends BaseApiService {
    @Inject
    Retrofit retrofit;


    public CommentApiService() {
        getApiComponent().inject(this);
    }

    public Single<ArrayList<Comment>> getComments(int postId) {
        return retrofit.create(ApiInterface.class).getPostComments(postId);
    }
}
