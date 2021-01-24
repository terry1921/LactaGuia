package com.mx.terryrockstar.lactaguia.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.domain.adapter.MainAdapter
import com.mx.terryrockstar.lactaguia.main.domain.model.Theme
import com.mx.terryrockstar.lactaguia.summary.SummaryActivity
import kotlinx.android.synthetic.main.activity_main.*

const val THEME = "theme"

class MainActivity : AppCompatActivity() {

    private var mAdapter: MainAdapter? = null
    private val mutableList: MutableList<Theme> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = MainAdapter {  theme ->
            val intent = Intent(this@MainActivity, SummaryActivity::class.java)
            intent.putExtra(THEME, theme)
            startActivity(intent)
        }
        listTheme.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }

        getDataList()

    }

    private fun getDataList() {
        mutableList.add(
            Theme(
                1,
                R.string.title_1,
                R.string.subtitle_1,
                R.drawable.ic_ico_1,
                R.string.text_1
            )
        )
        mutableList.add(
            Theme(
                2,
                R.string.title_2,
                R.string.subtitle_2,
                R.drawable.ic_ico_2,
                R.string.text_2
            )
        )
        mutableList.add(
            Theme(
                3,
                R.string.title_3,
                R.string.subtitle_3,
                R.drawable.ic_ico_3,
                R.string.text_3
            )
        )
        mutableList.add(
            Theme(
                4,
                R.string.title_4,
                R.string.subtitle_4,
                R.drawable.ic_ico_4,
                R.string.text_4
            )
        )
        mutableList.add(
            Theme(
                5,
                R.string.title_5,
                R.string.subtitle_5,
                R.drawable.ic_ico_5,
                R.string.text_5
            )
        )
        mutableList.add(
            Theme(
                6,
                R.string.title_6,
                R.string.subtitle_6,
                R.drawable.ic_ico_6,
                R.string.text_6
            )
        )
        mutableList.add(
            Theme(
                7,
                R.string.title_7,
                R.string.subtitle_7,
                R.drawable.ic_ico_7,
                R.string.text_7
            )
        )
        mutableList.add(
            Theme(
                8,
                R.string.title_8,
                R.string.subtitle_8,
                R.drawable.ic_ico_8,
                R.string.text_8
            )
        )
        mutableList.add(
            Theme(
                9,
                R.string.title_9,
                R.string.subtitle_9,
                R.drawable.ic_ico_9,
                R.string.text_9
            )
        )
        mutableList.add(
            Theme(
                10,
                R.string.title_10,
                R.string.subtitle_10,
                R.drawable.ic_ico_10,
                R.string.text_10
            )
        )
        mutableList.add(
            Theme(
                11,
                R.string.title_11,
                R.string.subtitle_11,
                R.drawable.ic_ico_11,
                R.string.text_11
            )
        )
        mutableList.add(
            Theme(
                12,
                R.string.title_12,
                R.string.subtitle_12,
                R.drawable.ic_ico_12,
                R.string.text_12
            )
        )
        mutableList.add(
            Theme(
                13,
                R.string.title_13,
                R.string.subtitle_13,
                R.drawable.ic_ico_13,
                R.string.text_13
            )
        )
        mutableList.add(
            Theme(
                14,
                R.string.title_14,
                R.string.subtitle_14,
                R.drawable.ic_ico_14,
                R.string.text_14
            )
        )
    }

    override fun onResume() {
        super.onResume()
        mAdapter?.addAll(mutableList)
    }

}