package com.kstechsolutions.mvvm.modules.comments

/**
 * Created by muhammad umair shafique on 29/09/2019.
 */

data class CommentUIModel(val isLoading: Boolean = false, val data: List<Comment> = emptyList(), val errorMessage: String = "")

data class Comment(val name: String = "", val email: String = "", val body: String = "")
