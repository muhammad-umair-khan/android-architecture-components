package com.kstechsolutions.mvvm.modules.comments

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

interface CommentApi {
    @GET("posts/{id}/comments")
    suspend fun getPostComments(@Path("id") id: Int): Response<List<Comment>>
}