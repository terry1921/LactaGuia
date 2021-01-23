package com.mx.terryrockstar.myapplication.data.source.remote

import com.mx.terryrockstar.myapplication.data.source.DataSource

class RemoteSource : DataSource {

    /**
     * Used to force [getInstance] to create a new instance the next time it's called
     */
    override fun destroyInstance() {
        INSTANCE = null
    }

    companion object {

        private var INSTANCE: DataSource? = null

        /**
         * Return a single instance of this class, create if it necessary
         * @return instance of [RemoteSource]
         */
        @JvmStatic
        fun getInstance(): DataSource {
            if (INSTANCE == null) {
                INSTANCE = RemoteSource()
            }
            return INSTANCE as DataSource
        }
    }
}