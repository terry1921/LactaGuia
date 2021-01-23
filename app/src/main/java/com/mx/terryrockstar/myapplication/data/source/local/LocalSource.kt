package com.mx.terryrockstar.myapplication.data.source.local

import com.mx.terryrockstar.myapplication.data.Result
import com.mx.terryrockstar.myapplication.data.source.DataSource

class LocalSource : DataSource {

    /**
     * Used to force [getInstance] to create a new instance the next time it's called
     */
    override fun destroyInstance() {
        INSTANCE = null
    }

    override fun getResponse(): Result<String> {
        TODO("Not yet implemented")
    }

    companion object {

        private var INSTANCE: DataSource? = null

        /**
         * Return a single instance of this class, create if it necessary
         * @return instance of [LocalSource]
         */
        @JvmStatic
        fun getInstance(): DataSource {
            if (INSTANCE == null) {
                INSTANCE = LocalSource()
            }
            return INSTANCE as DataSource
        }
    }
}