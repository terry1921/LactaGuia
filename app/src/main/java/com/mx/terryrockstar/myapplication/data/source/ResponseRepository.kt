package com.mx.terryrockstar.myapplication.data.source

import com.mx.terryrockstar.myapplication.base.domain.model.Response
import com.mx.terryrockstar.myapplication.data.FilterType
import com.mx.terryrockstar.myapplication.data.Result
import com.mx.terryrockstar.myapplication.utils.Print
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResponseRepository(private val remote: DataSource, private val local: DataSource) : Repository {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    /**
     * Used to force [getInstance] to create a new instance the next time it's called
     */
    override fun destroyInstance() {
        INSTANCE?.remote?.destroyInstance()
        INSTANCE?.local?.destroyInstance()
        INSTANCE = null
    }

    override suspend fun getResponse(forceUpdate: Boolean, currentFiltering: FilterType): Result<String> {
        return withContext(ioDispatcher) {

            val result = fetchData(forceUpdate, currentFiltering)

            (result as? Result.Error)?.let {
                return@withContext Result.Error(it.response)
            }

            (result as? Result.Success)?.let { response ->
                return@withContext Result.Success(response.data)
            }

            return@withContext result
        }
    }

    private fun fetchData(forceUpdate: Boolean, currentFiltering: FilterType): Result<String> {
        try {
            val result = when(currentFiltering) {
                FilterType.Filter_ONE,
                FilterType.Filter_TWO -> {
                    if (forceUpdate) {
                        remote.getResponse()
                    } else {
                        local.getResponse()
                    }
                }
            }
            when (result) {
                is Result.Error -> {
                    Print.w("Remote data source fetch failed")
                }
                is Result.Success -> {
                    return result
                }
                else -> throw IllegalStateException("Remote data")
            }

            if (forceUpdate) {
                return Result.Error(Response("No se puede forzar la actualización: la fuente de datos remota no está disponible", "", 500))
            }

            return result
        } catch (e: Exception) {
            Print.e(javaClass.simpleName, e.message, e.cause)
            return Result.Error(Response("Error Interno del Servidor", "", 500))
        }
    }

    companion object {

        private var INSTANCE: ResponseRepository? = null

        /**
         * Return a single instance of this class, create if it necessary
         * @param remote Remote server data source
         * @param local Local database data source
         * @return instance of [ResponseRepository]
         */
        @JvmStatic
        fun getInstance(remote: DataSource, local: DataSource): ResponseRepository{
            if (INSTANCE == null) {
                INSTANCE = ResponseRepository(remote, local)
            }
            return INSTANCE as ResponseRepository
        }
    }

}