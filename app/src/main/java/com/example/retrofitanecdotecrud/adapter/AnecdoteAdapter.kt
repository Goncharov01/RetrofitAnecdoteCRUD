package com.example.retrofitanecdotecrud.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitanecdotecrud.R
import com.example.retrofitanecdotecrud.entity.Anecdote
import kotlinx.android.synthetic.main.anecdote_item.view.*


class AnecdoteAdapter(
    private var anecdotes: List<Anecdote>,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<AnecdoteAdapter.AnecdoteViewHolder>() {

    fun setAnecdoteList(newList: List<Anecdote>) {
        val diffUtilCallback = AnecdoteDiffUtilCallback(this.anecdotes, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)

        this.anecdotes = newList
        println("!!!!ADAPTER GET LIST $newList")
        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnecdoteViewHolder {
        return AnecdoteViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.anecdote_item,
                    parent,
                    false
                ),
            onItemClickListener
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: AnecdoteViewHolder, position: Int) {
        holder.bind(anecdotes[position])
    }

    override fun getItemCount(): Int = anecdotes.size

    inner class AnecdoteViewHolder(
        view: View,
        private val onItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(view) {

        @RequiresApi(Build.VERSION_CODES.N)
        fun bind(anecdote: Anecdote) {
            itemView.post_text.text =
                Html.fromHtml(anecdote.elementPureHtml, Html.FROM_HTML_MODE_LEGACY)
            itemView.site_text.text = anecdote.site
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(anecdote)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(anecdote: Anecdote)
    }
}