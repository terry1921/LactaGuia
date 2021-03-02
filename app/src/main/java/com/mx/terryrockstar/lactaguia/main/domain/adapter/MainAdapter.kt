package com.mx.terryrockstar.lactaguia.main.domain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.domain.model.Topic
import com.mx.terryrockstar.lactaguia.utils.isPair

class MainAdapter(private val listener: (Topic) -> Unit): RecyclerView.Adapter<MainAdapter.Holder>() {

    private val list: MutableList<Topic> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addAll(items: MutableList<Topic>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class Holder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<AppCompatTextView>(R.id.title)
        private val image = view.findViewById<AppCompatImageView>(R.id.image)
        private val themeCard = view.findViewById<CardView>(R.id.themeCard)

        fun bind(topic: Topic) {
            title.setText(topic.title)
            image.setImageResource(topic.image)
            if (topic.id.isPair()) {
                themeCard.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.purple_theme))
            } else {
                themeCard.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.pink_theme))
            }
            view.setOnClickListener { listener(topic) }
        }

    }

}