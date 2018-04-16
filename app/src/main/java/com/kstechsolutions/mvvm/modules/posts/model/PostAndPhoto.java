package com.kstechsolutions.mvvm.modules.posts.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class PostAndPhoto implements Serializable {
    public final ArrayList<Post> mPosts;
    public final ArrayList<Photo> mPhotos;

    public PostAndPhoto(ArrayList<Post> post, ArrayList<Photo> photos) {
        mPosts = post;
        mPhotos = photos;
    }


}
