package com.example.readx.utiles

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksaplicationkotlin.R
import com.example.readx.ui.base.BaseAdapter
import com.example.readx.ui.base.BaseListAdapter
import com.example.readx.ui.screens.graduation_projects.gp_status.GradProjectStatus


@BindingAdapter(value = ["app:listItems"])
fun <T> setListItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseListAdapter<T>?)?.submitList(items)
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let {
        (view.adapter as BaseAdapter<T>?)?.setItems(it)
    }
}

@BindingAdapter(value = ["app:projectStatus"])
fun setProjectStatus(view: TextView, status: GradProjectStatus) {
    when (status) {
        GradProjectStatus.SUCCESS -> {
            view.text = view.context.getString(R.string.accepted)
            view.background =
                view.context.getDrawable(R.drawable.acceptstatus)
        }

        GradProjectStatus.PENDING -> TODO()
        GradProjectStatus.REJECTED -> TODO()
        GradProjectStatus.NONE -> TODO()
    }

}

@BindingAdapter(value = ["app:projectStatusImg"])
fun setProjectStatusImg(view: ImageView, status: GradProjectStatus) {
    when (status) {
        GradProjectStatus.SUCCESS -> view.setImageResource(R.drawable.accepted_project)
        GradProjectStatus.PENDING -> TODO()
        GradProjectStatus.REJECTED -> TODO()
        GradProjectStatus.NONE -> TODO()
    }
}


@BindingAdapter(value = ["app:showLoading"])
fun showLoading(view: View, isVisible: Boolean?) {
    Log.d("TAG", "showLoading:isVisible$isVisible ")
    view.isVisible = !(isVisible == null || isVisible == false)
}

@BindingAdapter(value = ["app:viewVisibilityOnItems"])
fun <T> hideIfItemsEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}

@BindingAdapter(value = ["app:viewVisibilityOnItemsList"])
fun <T> showIfItemsNotEmpty(view: View, items: List<T>) {
    view.isVisible = items.isEmpty()
}

@BindingAdapter(value = ["app:viewVisibility"])
fun hideWhenLoading(view: View, isVisible: Boolean) {
    if (isVisible)
        view.visibility = View.INVISIBLE
    else view.visibility = View.VISIBLE
}

@BindingAdapter(value = ["app:viewVisibilityNoResult"])
fun showNoResult(view: View, isVisible: Boolean) {
    view.isInvisible = !isVisible
}

@BindingAdapter(value = ["app:doNotShow"])
fun doNotShow(view: View, doNotWantToShow: Boolean) {
    view.isInvisible = doNotWantToShow
}

/*
@BindingAdapter("app:onSearchTextChanged")
fun EditText.onSearchTextChanged(viewModel: SearchViewModel) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            viewModel.onQueryChange(s.toString().trim())
        }

        override fun afterTextChanged(s: Editable?) {}
    })
}
*/

@BindingAdapter(
    "app:isFinished", "app:time", "app:homeTeamGoals", "app:awayTeamGoals",
    requireAll = true
)
fun TextView.setTimeOrResult(
    isFinished: Boolean,
    time: String,
    homeTeamGoals: Int,
    awayTeamGoals: Int
) {
    text = if (isFinished)
        "$homeTeamGoals  -  $awayTeamGoals"
    else time
}

//@BindingAdapter(value = ["app:listItems"])
//fun <T> setItems(view: RecyclerView, items: List<T>?) {
//    items?.let {
//        (view.adapter as BaseListAdapter<T>?)?.submitList(items)
//    }
//}


@BindingAdapter(value = ["app:noDataShow"])
fun noDataShow(view: View, doNotWantToShow: Boolean) {
    if (doNotWantToShow) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:doNotShowWhenNoData"])
fun doNotShowWhenNoData(view: View, doNotWantToShow: Boolean) {
    if (!doNotWantToShow) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("ImageUrl")
fun loadImg(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url)
        .placeholder(R.drawable.book)
        .centerCrop().into(imageView)
}

@BindingAdapter("setRating")
fun setRating(ratingBar: RatingBar, rate: Double) {
    ratingBar.rating = rate.toFloat()
}


@BindingAdapter(value = ["app:imageurl"])
fun setImageFromURL(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}