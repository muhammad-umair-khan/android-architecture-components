package com.kstechsolutions.mvvm.modules.posts.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.modules.base.BaseViewModel;
import com.kstechsolutions.mvvm.modules.posts.data.PostApiService;
import com.kstechsolutions.mvvm.modules.posts.data.IPostView;
import com.kstechsolutions.mvvm.modules.posts.model.PostAndPhoto;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class PostListViewModel extends BaseViewModel<IPostView> {
    @Inject
    PostApiService mApiService;
    private final MutableLiveData<PostAndPhoto> postsLiveData;

    public PostListViewModel() {
        postsLiveData = new MutableLiveData<>();
        getViewModelComponent().inject(this);
    }

    private void fetchPostsAndPhotos() {
        if (getView().isNetworkConnected()) {
            getView().showLoading(R.string.please_wait);
            getCompositeDisposable().add(
                    mApiService.getPosts()
                            .flatMap(postsResponse -> mApiService.getPhotos(),
                                    PostAndPhoto::new)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(data -> {
                                postsLiveData.setValue(data);
                                getView().hideLoading();
                            }, throwable -> {
                                getView().hideLoading();
                                getView().onError(throwable.getMessage());
                            }));
        } else getView().onError(R.string.err_network);

    }

    public MutableLiveData<PostAndPhoto> getPostsLiveData() {
        if (postsLiveData.getValue() == null) fetchPostsAndPhotos();
        return postsLiveData;
    }

}
