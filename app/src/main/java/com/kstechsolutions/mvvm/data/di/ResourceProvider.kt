package com.kstechsolutions.mvvm.data.di


import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.annotation.ArrayRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import javax.inject.Inject

class ResourceProvider @Inject constructor(private val context: Context) {
    @NonNull
    fun getText(@StringRes resId: Int): CharSequence {
        return context.getText(resId)
    }

    @NonNull
    fun getTextArray(@ArrayRes resId: Int): Array<CharSequence> {
        return context.resources.getTextArray(resId)
    }

    @NonNull
    fun getQuantityText(@PluralsRes resId: Int, quantity: Int): CharSequence {
        return context.resources.getQuantityText(resId, quantity)
    }

    @NonNull
    fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }

    @NonNull
    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, formatArgs)
    }

    @NonNull
    fun getStringArray(@ArrayRes resId: Int): Array<String> {
        return context.resources.getStringArray(resId)
    }

    @NonNull
    fun getQuantityString(@PluralsRes resId: Int, quantity: Int): String {
        return context.resources.getQuantityString(resId, quantity)
    }

    @NonNull
    fun getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any): String {
        return context.resources.getQuantityString(resId, quantity, formatArgs)
    }

    fun getInteger(@IntegerRes resId: Int): Int {
        return context.resources.getInteger(resId)
    }

    @NonNull
    fun getIntArray(@ArrayRes resId: Int): IntArray {
        return context.resources.getIntArray(resId)
    }

    fun getBoolean(@BoolRes resId: Int): Boolean {
        return context.resources.getBoolean(resId)
    }

    fun getDimension(@DimenRes resId: Int): Float {
        return context.resources.getDimension(resId)
    }

    fun getDimensionPixelSize(@DimenRes resId: Int): Int {
        return context.resources.getDimensionPixelSize(resId)
    }

    fun getDimensionPixelOffset(@DimenRes resId: Int): Int {
        return context.resources.getDimensionPixelOffset(resId)
    }

    fun getDrawable(@DrawableRes resId: Int): Drawable? {
        return ContextCompat.getDrawable(context, resId)
    }

    fun getTypedArray(@ArrayRes resId: Int): TypedArray {
        return context.resources.obtainTypedArray(resId)
    }

    @ColorInt
    fun getColor(@ColorRes resId: Int): Int {
        return ContextCompat.getColor(context, resId)
    }

    fun getColorStateList(@ColorRes resId: Int): ColorStateList? {
        return ContextCompat.getColorStateList(context, resId)
    }

    @Nullable
    @Throws(Resources.NotFoundException::class)
    fun getFont(@FontRes id: Int): Typeface? {
        return ResourcesCompat.getFont(context, id)
    }

    fun loadAnimation(@AnimRes id: Int): Animation {
        return AnimationUtils.loadAnimation(context, id)
    }

    fun getBitmapDrawable(bitmap: Bitmap): BitmapDrawable? {
        return BitmapDrawable(context.resources, bitmap)
    }
}