package com.mx.terryrockstar.myapplication.data.source

import com.mx.terryrockstar.myapplication.data.FilterType
import com.mx.terryrockstar.myapplication.data.Result

interface Repository {

    fun destroyInstance()

    suspend fun getResponse(forceUpdate: Boolean, currentFiltering: FilterType): Result<String>

}