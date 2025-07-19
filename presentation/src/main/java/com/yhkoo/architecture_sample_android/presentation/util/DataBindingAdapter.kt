package com.yhkoo.architecture_sample_android.presentation.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber

@BindingAdapter("bind:image_url")
fun ImageView.bindImageUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        Timber.w("Image URL is null or empty")
        return
    }

    val requestBuilder: RequestBuilder<Drawable> =
        Glide.with(context).asDrawable().sizeMultiplier(0.1f)

    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .thumbnail(requestBuilder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(RequestOptions().timeout(10000))
        .listener(object : com.bumptech.glide.request.RequestListener<Drawable> {
            override fun onLoadFailed(
                e: com.bumptech.glide.load.engine.GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Timber.e(e, "Failed to load image: $url")
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                dataSource: com.bumptech.glide.load.DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                Timber.d("Image loaded successfully: $url")
                return false
            }
        })
        .into(this)
}
