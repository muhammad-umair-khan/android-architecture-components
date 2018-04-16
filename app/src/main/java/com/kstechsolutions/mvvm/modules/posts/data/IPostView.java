package com.kstechsolutions.mvvm.modules.posts.data;

import com.kstechsolutions.mvvm.modules.base.IBaseView;
import com.kstechsolutions.mvvm.modules.posts.model.PostAndPhoto;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public interface IPostView extends IBaseView {
    void onPostsPhotosFetched(PostAndPhoto data);

    void onListItemClicked(int id, String title, String url);

}
