package com.mx.terryrockstar.lactaguia.main.domain.adapter

import android.graphics.Color
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.domain.model.SubTopic

class SubTopicAdapter: RecyclerView.Adapter<SubTopicAdapter.Holder>()  {

    private val list: MutableList<SubTopic> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addAll(items: MutableList<SubTopic>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class Holder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<AppCompatTextView>(R.id.topicSubTitle)
        private val webText = view.findViewById<WebView>(R.id.topicSubText)
        private val images2 = view.findViewById<View>(R.id.images2)
        private val images3 = view.findViewById<View>(R.id.images3)
        private val images4 = view.findViewById<View>(R.id.images4)
        private val images5 = view.findViewById<View>(R.id.images5)

        init {
            webText.visibility = View.GONE
            webText.isVerticalScrollBarEnabled = false
            webText.setBackgroundColor(Color.TRANSPARENT)
        }

        fun bind(subTopic: SubTopic) {
            if (subTopic.id >= 50) {
                title.visibility = View.GONE
                webText.visibility = View.VISIBLE
            }
            title.setText(subTopic.title)
            val text = view.context.getString(R.string.html_start) + view.context.getString(subTopic.text) + view.context.getString(R.string.html_end)
            val html = Base64.encodeToString(text.toByteArray(), Base64.DEFAULT)
            webText.loadData(html, "text/html; charset=UTF-8", "base64")

            when (subTopic.id) {
                50 -> {
                    images2.visibility = View.VISIBLE
                }
                51 -> {
                    images3.visibility = View.VISIBLE
                }
                52 -> {
                    images4.visibility = View.VISIBLE
                }
                53 -> {
                    images5.visibility = View.VISIBLE
                }
            }

            title.setOnClickListener {
                webText.visibility = if (webText.isVisible) View.GONE else View.VISIBLE
            }
        }

    }

}