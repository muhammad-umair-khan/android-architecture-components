package com.kstechsolutions.mvvm.modules.posts


data class PostsAndPhotosUIModel(val isLoading: Boolean = false, val data: List<PostAndPhoto> = emptyList(), val errorMessage: String = "")

data class Post(val id: Int = 0, val title: String = "", val body: String = "")

data class Photo(val id: Int = 0, val title: String = "", val url: String = "")

data class PostAndPhoto(val post: Post = Post(), val photo: Photo = Photo())

