package com.kstechsolutions.mvvm.modules.comments

import androidx.lifecycle.liveData
import com.kstechsolutions.mvvm.data.network.Resource
import javax.inject.Inject

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class CommentListRepository @Inject constructor(private val api: CommentApi) {
    suspend fun getComments(postId: Int) = liveData {
        emit(Resource.loading())
        try {
            val response = api.getPostComments(postId)
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
