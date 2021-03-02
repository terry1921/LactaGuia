package com.mx.terryrockstar.lactaguia.summary

import android.graphics.Color
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.TOPIC
import com.mx.terryrockstar.lactaguia.main.domain.adapter.SubTopicAdapter
import com.mx.terryrockstar.lactaguia.main.domain.model.Topic
import com.mx.terryrockstar.lactaguia.utils.isPair
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {

    private lateinit var mAdapter: SubTopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val topic: Topic? = intent.getParcelableExtra(TOPIC)
        close.setOnClickListener { onBackPressed() }
        mAdapter = SubTopicAdapter()
        subTopics.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
        initUI(topic)
    }

    private fun initUI(topic: Topic?) {
        topic?.let { t ->
            // color background
            if (t.id.isPair()) {
                container.setBackgroundColor(ContextCompat.getColor(this@SummaryActivity, R.color.purple_theme))
                topColorBar.setImageResource(R.drawable.ic_summary_top_purple)
                topColorFigure.setImageResource(R.drawable.ic_summary_background_purple)
            } else {
                container.setBackgroundColor(ContextCompat.getColor(this@SummaryActivity, R.color.pink_theme))
                topColorBar.setImageResource(R.drawable.ic_summary_top_pink)
                topColorFigure.setImageResource(R.drawable.ic_summary_background_pink)
            }

            topicTitle.text = getString(t.title)
            if (t.text != -1) {
                topicText.visibility = View.VISIBLE
                topicText.isVerticalScrollBarEnabled = false
                topicText.setBackgroundColor(Color.TRANSPARENT)
                topicText.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null)
                val text = getString(R.string.html_start) + getString(topic.text) + getString(R.string.html_end)
                val html = Base64.encodeToString(text.toByteArray(Charsets.UTF_8), Base64.DEFAULT)
                topicText.loadData(html, "text/html", "base64")
            }
            if (!t.subtopics.isNullOrEmpty()) {
                subTopics.visibility = View.VISIBLE
                mAdapter.addAll(t.subtopics)
            } else {
                subTopics.visibility = View.GONE
            }
            if (t.id == 5) {
                image1.visibility = View.VISIBLE
            }
        }
    }
}