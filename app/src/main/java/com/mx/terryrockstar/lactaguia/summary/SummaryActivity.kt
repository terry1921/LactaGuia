package com.mx.terryrockstar.lactaguia.summary

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.THEME
import com.mx.terryrockstar.lactaguia.main.domain.model.Theme
import com.mx.terryrockstar.lactaguia.utils.isPair
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.theme_five.*

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val theme: Theme? = intent.getParcelableExtra(THEME)

        close.setOnClickListener { onBackPressed() }

        theme?.let {
            if (it.id.isPair()) {
                container.setBackgroundColor(ContextCompat.getColor(this@SummaryActivity, R.color.purple_800))
                topColorBar.setImageResource(R.drawable.ic_summary_top_purple)
                topColorFigure.setImageResource(R.drawable.ic_summary_background_purple)
            } else {
                container.setBackgroundColor(ContextCompat.getColor(this@SummaryActivity, R.color.pink_800))
                topColorBar.setImageResource(R.drawable.ic_summary_top_pink)
                topColorFigure.setImageResource(R.drawable.ic_summary_background_pink)
            }
            themeFive.visibility = View.GONE
            if (it.id == 5) {
                themeFive.visibility = View.VISIBLE
                allTextWeb.visibility = View.GONE

                allTextWeb1.isVerticalScrollBarEnabled = false
                allTextWeb1.setBackgroundColor(Color.TRANSPARENT)
                allTextWeb1.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null)
                allTextWeb1.loadData(getString(R.string.text_5), "text/html; charset=utf-8", "utf-8")

                allTextWeb2.isVerticalScrollBarEnabled = false
                allTextWeb2.setBackgroundColor(Color.TRANSPARENT)
                allTextWeb2.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null)
                allTextWeb2.loadData(getString(R.string.text_5_1), "text/html; charset=utf-8", "utf-8")
            } else {
                allTextWeb.isVerticalScrollBarEnabled = false
                allTextWeb.setBackgroundColor(Color.TRANSPARENT)
                allTextWeb.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null)
                allTextWeb.loadData(getString(it.text), "text/html; charset=utf-8", "utf-8")
            }
        }


    }
}