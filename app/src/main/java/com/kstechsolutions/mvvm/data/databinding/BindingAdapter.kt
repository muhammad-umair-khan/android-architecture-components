package com.kstechsolutions.mvvm.data.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("data")
fun <T> setData(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*> && data != null) {
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}