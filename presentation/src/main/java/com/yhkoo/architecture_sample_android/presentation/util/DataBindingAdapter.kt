package com.yhkoo.architecture_sample_android.presentation.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("bind:image_url")
fun ImageView.bindImageUrl(url: String?) {
    val requestBuilder: RequestBuilder<Drawable> =
        Glide.with(context).asDrawable().sizeMultiplier(0.1f)

    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .thumbnail(requestBuilder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
