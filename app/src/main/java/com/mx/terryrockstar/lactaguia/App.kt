package com.mx.terryrockstar.lactaguia

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class App : Application() {

    @SuppressLint("StaticFieldLeak")
    var mContext: Context? = null

    override fun onCreate() {
        super.onCreate()
        setContext(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun setContext(context: Context) {
        mContext = context
    }

}
