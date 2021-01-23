package com.mx.terryrockstar.myapplication.data.source

import com.mx.terryrockstar.myapplication.data.Result

interface DataSource {

    fun destroyInstance()

    fun getResponse(): Result<String>

}