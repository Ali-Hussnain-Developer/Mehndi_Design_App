package com.example.mehndidesignapp.bindingAdapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mehndidesignapp.model.HomePageModelClass

object MyBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, url: Int) {
        Glide.with(view).load(url).fitCenter().into(view)
    }

    @JvmStatic
    @BindingAdapter("setMehndiTitle")

    fun setMehndiTitle(textView: TextView, obj: HomePageModelClass) {
        textView.text = obj.mehndiTitle
    }


}

