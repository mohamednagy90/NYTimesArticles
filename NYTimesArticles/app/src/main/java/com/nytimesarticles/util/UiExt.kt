package com.nytimesarticles.util

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.ViewSkeletonScreen

fun RecyclerView.showSkeleton(@LayoutRes skeletonLayoutId: Int, @ColorRes colorId: Int, count: Int): RecyclerViewSkeletonScreen {
    return Skeleton.bind(this)
        .load(skeletonLayoutId)
        .count(count)
        .color(colorId)
        .show()
}

fun View.showSkeleton(@LayoutRes skeletonLayoutId: Int, @ColorRes colorId: Int): ViewSkeletonScreen {
    return Skeleton.bind(this)
        .load(skeletonLayoutId)
        .color(colorId)
        .show()
}