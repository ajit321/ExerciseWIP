package com.wipro.exercise.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wipro.exercise.R
import com.wipro.exercise.model.bean.Row
import kotlinx.android.synthetic.main.row_home_page_adapter.view.*
import kotlinx.android.synthetic.main.row_home_page_adapter.view.txtTitle
import kotlinx.android.synthetic.main.row_home_page_without_description.view.*
import kotlinx.android.synthetic.main.row_home_page_without_image.view.*

class HomePageAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val TYPE_TITLE = 1
        const val TYPE_IMAGE = 2
        const val TYPE_DESCRIPTION = 3
    }

    private var mData = ArrayList<Row>()

    fun setData(data: ArrayList<Row>) {
        mData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TITLE -> HomeViewHolder(
                layoutInflater.inflate(
                    R.layout.row_home_page_adapter,
                    parent,
                    false
                )
            )
            TYPE_IMAGE -> HomeViewHolderWithOutImage(
                layoutInflater.inflate(
                    R.layout.row_home_page_without_image,
                    parent,
                    false
                )
            )
            TYPE_DESCRIPTION -> HomeViewHolderWithOutDescription(
                layoutInflater.inflate(
                    R.layout.row_home_page_without_description,
                    parent,
                    false
                )
            )

            else ->HomeViewHolder(
                layoutInflater.inflate(
                    R.layout.row_home_page_adapter,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {
            TYPE_TITLE -> {
                val viewHolder = holder as HomeViewHolder
                viewHolder.setBind(mData[position])
            }
            TYPE_IMAGE -> {
                val viewHolder = holder as HomeViewHolderWithOutImage
                viewHolder.setBind(mData[position])
            }
            TYPE_DESCRIPTION -> {
                val viewHolder = holder as HomeViewHolderWithOutDescription
                viewHolder.setBind(mData[position])
            }

        }

    }


    override fun getItemCount(): Int = mData.size
    override fun getItemViewType(position: Int): Int {
        return when {
            mData[position].description == null -> {
                TYPE_DESCRIPTION
            }
            mData[position].imageHref == null -> {
                TYPE_IMAGE
            }
            else -> {
                TYPE_TITLE
            }
        }
    }


    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setBind(
            users: Row
        ) = itemView.apply {
            txtTitle.text = users.title
            txtDescription.text = users.description
            Glide.with(context)
                .load(users.imageHref)
                .into(imageView)
        }

    }

    class HomeViewHolderWithOutImage(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setBind(
            users: Row
        ) = itemView.apply {
            txtWithDescTitle.text = users.title
            txtWithDescription.text = users.description

        }

    }

    class HomeViewHolderWithOutDescription(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setBind(
            users: Row
        ) = itemView.apply {
            txtWithImageTitle.text = users.title
            Glide.with(context)
                .load(users.imageHref)
                .into(ivImageView)
        }

    }
}

