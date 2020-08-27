package com.example.retrofitanecdotecrud.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.retrofitanecdotecrud.entity.Anecdote

class AnecdoteDiffUtilCallback(
    private var oldList: List<Anecdote>,
    private var newList: List<Anecdote>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }
}