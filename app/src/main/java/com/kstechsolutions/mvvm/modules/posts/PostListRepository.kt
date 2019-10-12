package com.kstechsolutions.mvvm.modules.posts

import androidx.lifecycle.liveData
import com.kstechsolutions.mvvm.data.network.Resource
import javax.inject.Inject

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class PostListRepository @Inject constructor(private val api: PostApi) {
    suspend fun getPosts() = liveData {
        emit(Resource.loading())
        try {
            val response = api.getPost()
            if (response.isSuccessful) {
                emit(Resource.success(response.body()))
            } else {
                emit(Resource.error(response.message() ?: ""))
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: ""))
        }
    }

    suspend fun getPhotos() = liveData {
        emit(Resource.loading())
        try {
            val response = api.getPhotos()
            if (response.isSuccessful) {
                emit(Resource.success(response.body()))
            } else {
                emit(Resource.error(response.message() ?: ""))
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: ""))
        }
    }
}
