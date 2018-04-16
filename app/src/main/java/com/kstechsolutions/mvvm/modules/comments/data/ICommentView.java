package com.kstechsolutions.mvvm.modules.comments.data;

import com.kstechsolutions.mvvm.modules.base.IBaseView;
import com.kstechsolutions.mvvm.modules.comments.model.Comment;

import java.util.ArrayList;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public interface ICommentView extends IBaseView {
    void onCommentsFetched(ArrayList<Comment> data);
}
