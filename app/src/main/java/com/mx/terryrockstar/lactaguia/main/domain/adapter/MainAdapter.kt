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
import com.mx.terryrockstar.lactaguia.main.domain.model.Theme
import com.mx.terryrockstar.lactaguia.utils.isPair

class MainAdapter(private val listener: (Theme) -> Unit): RecyclerView.Adapter<MainAdapter.Holder>() {

    private val list: MutableList<Theme> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addAll(items: MutableList<Theme>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class Holder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<AppCompatTextView>(R.id.title)
        private val subtitle = view.findViewById<AppCompatTextView>(R.id.subtitle)
        private val image = view.findViewById<AppCompatImageView>(R.id.image)
        private val themeCard = view.findViewById<CardView>(R.id.themeCard)

        fun bind(theme: Theme) {
            title.setText(theme.title)
            subtitle.setText(theme.subtitle)
            image.setImageResource(theme.image)
            if (theme.id.isPair()) {
                themeCard.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.purple_600))
            } else {
                themeCard.setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.pink_600))
            }

            view.setOnClickListener { listener(theme) }
        }

    }

}