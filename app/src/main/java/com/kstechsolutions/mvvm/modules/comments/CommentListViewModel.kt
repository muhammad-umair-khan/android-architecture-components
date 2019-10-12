package com.kstechsolutions.mvvm.modules.comments

import androidx.lifecycle.*
import com.kstechsolutions.mvvm.data.network.Resource
import com.kstechsolutions.mvvm.data.network.Status
import com.kstechsolutions.mvvm.modules.posts.PostAndPhoto
import com.squareup.picasso.Picasso
import javax.inject.Inject

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class CommentListViewModel @Inject constructor(repo: CommentListRepository) : ViewModel() {
    private val commentsLiveData = MutableLiveData<Int>()

    private val commentUIModel = commentsLiveData.switchMap {
        liveData {
            emitSource(repo.getComments(it).switchMap { convertToUIModel(it) })
        }
    }

    private fun convertToUIModel(resource: Resource<List<Comment>>) = liveData {
        when (resource.status) {
            Status.LOADING -> emit(CommentUIModel(isLoading = true))
            Status.SUCCESS -> emit(resource.data?.let { CommentUIModel(data = it) })
            Status.ERROR -> emit(resource.message?.let { CommentUIModel(errorMessage = it) })
        }
    }

    fun commentUIModel(): LiveData<CommentUIModel?> = commentUIModel

    /**
     * To trigger commentsLiveData.switchMap, we need to set value of commentsLiveData
     * @param postId
     */
    fun setPostId(postId: Int) {
        commentsLiveData.value = postId
    }
}