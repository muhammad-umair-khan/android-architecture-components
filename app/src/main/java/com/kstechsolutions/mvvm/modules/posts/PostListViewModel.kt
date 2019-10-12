package com.kstechsolutions.mvvm.modules.posts

import androidx.lifecycle.*
import com.kstechsolutions.mvvm.data.network.Resource
import com.kstechsolutions.mvvm.data.network.Status
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class PostListViewModel @Inject constructor(repository: PostListRepository) : ViewModel() {
    private val photosAndPostsUIModel = MediatorLiveData<PostsAndPhotosUIModel>()
    private val photosLiveData = MutableLiveData<Unit>()
    private val postsLiveData = MutableLiveData<Unit>()

    private val postsResult = postsLiveData.switchMap {
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(repository.getPosts())
        }
    }

    private val photosResult = photosLiveData.switchMap {
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(repository.getPhotos())
        }
    }

    init {
        loadPosts()
        loadPhotos()

        photosAndPostsUIModel.addSource(postsResult) { photosAndPostsUIModel.postValue(convertToUIModel(it)) }
        photosAndPostsUIModel.addSource(photosResult) { photosAndPostsUIModel.postValue(convertToUIModel(it)) }
    }

    fun uiModel(): LiveData<PostsAndPhotosUIModel> = photosAndPostsUIModel

    private fun loadPosts() {
        postsLiveData.value = Unit
    }

    private fun loadPhotos() {
        photosLiveData.value = Unit
    }

    private fun convertToUIModel(res: Resource<List<Any>>) = when (res.status) {
        Status.LOADING -> PostsAndPhotosUIModel(true)
        Status.SUCCESS -> combineData()
        Status.ERROR -> res.message?.let { PostsAndPhotosUIModel(errorMessage = it) }
    }

    private fun combineData(): PostsAndPhotosUIModel {
        val posts = postsResult.value
        val photos = photosResult.value

        return if (posts == null || photos == null)
            PostsAndPhotosUIModel()
        else {
            val list = photos.data?.let { posts.data?.zip(it) { post: Post, photo: Photo -> PostAndPhoto(post, photo) } }
            if (list != null) {
                PostsAndPhotosUIModel(data = list)
            } else PostsAndPhotosUIModel()
        }
    }
}