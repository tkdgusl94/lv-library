package com.leveloper.library.ui

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<D, VH : BaseViewHolder<ViewDataBinding, D>> :
    RecyclerView.Adapter<VH>() {

    protected val items = mutableListOf<D>()

    var onItemClickListener: OnItemClickListener<D>? = null

    interface OnItemClickListener<D> {
        fun onItemClick(data: D, position: Int)
    }

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(parent, viewType).apply {
            onItemClickListener?.let { listener ->
                itemView.setOnClickListener {
                    listener.onItemClick(getItem(adapterPosition), adapterPosition)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: VH) {
        holder.recycled()
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int = items.size

    open fun getItem(position: Int): D = items[position]

    open fun replaceAll(items: List<D>, useDiffCallback: Boolean = false) {
        val diffCallback = BaseDiffUtilCallback(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.run {
            clear()
            addAll(items)
        }
        if (useDiffCallback) {
            diffResult.dispatchUpdatesTo(this)
        } else {
            notifyDataSetChanged()
        }

    }
}
