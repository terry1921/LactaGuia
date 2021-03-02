package com.mx.terryrockstar.lactaguia.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.domain.adapter.MainAdapter
import com.mx.terryrockstar.lactaguia.main.domain.repository.DataRepository
import com.mx.terryrockstar.lactaguia.summary.SummaryActivity
import kotlinx.android.synthetic.main.activity_main.*

const val TOPIC = "topic"

class MainActivity : AppCompatActivity() {

    private var mAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = MainAdapter {  topic ->
            val intent = Intent(this@MainActivity, SummaryActivity::class.java)
            intent.putExtra(TOPIC, topic)
            startActivity(intent)
        }
        listTheme.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    override fun onResume() {
        super.onResume()
        val list = DataRepository().list
        mAdapter?.addAll(list)
    }

}