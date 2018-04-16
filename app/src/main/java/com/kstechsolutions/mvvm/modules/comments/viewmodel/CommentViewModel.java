package com.kstechsolutions.mvvm.modules.comments.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.modules.base.BaseViewModel;
import com.kstechsolutions.mvvm.modules.comments.data.CommentApiService;
import com.kstechsolutions.mvvm.modules.comments.data.ICommentView;
import com.kstechsolutions.mvvm.modules.comments.model.Comment;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class CommentViewModel extends BaseViewModel<ICommentView> {
    @Inject
    CommentApiService mApiService;
    private final MutableLiveData<ArrayList<Comment>> commentsLiveData;

    public CommentViewModel() {
        commentsLiveData = new MutableLiveData<>();
        getViewModelComponent().inject(this);
    }

    private void fetchComments(int postId) {
        if (getView().isNetworkConnected()) {
            getView().showLoading(R.string.please_wait);
            mApiService.getComments(postId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new SingleObserver<ArrayList<Comment>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            getCompositeDisposable().add(d);
                        }

                        @Override
                        public void onSuccess(ArrayList<Comment> commentList) {
                            getView().hideLoading();
                            commentsLiveData.setValue(commentList);
                        }

                        @Override
                        public void onError(Throwable e) {
                            getView().hideLoading();
                            getView().onError(e.getMessage());
                        }
                    });
        } else getView().onError(R.string.err_network);
    }

    public MutableLiveData<ArrayList<Comment>> getCommentsLiveData(int commentId) {
        if (commentsLiveData.getValue() == null) fetchComments(commentId);
        return commentsLiveData;
    }
}
