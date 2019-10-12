package com.kstechsolutions.mvvm.modules.posts

import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

interface PostApi {
    @GET("posts")
    suspend fun getPost(): Response<List<Post>>

    @GET("photos")
    suspend fun getPhotos(): Response<List<Photo>>
}