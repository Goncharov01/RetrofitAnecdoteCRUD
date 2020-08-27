package com.example.retrofitanecdotecrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitanecdotecrud.entity.Anecdote
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val anecdote = intent.extras?.get("anecdote") as Anecdote
        anecdoteTV.text = anecdote.elementPureHtml
    }
}