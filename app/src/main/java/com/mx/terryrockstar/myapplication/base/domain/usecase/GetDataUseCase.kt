package com.mx.terryrockstar.myapplication.base.domain.usecase

import com.mx.terryrockstar.myapplication.base.domain.model.Response
import com.mx.terryrockstar.myapplication.data.FilterType
import com.mx.terryrockstar.myapplication.data.Result
import com.mx.terryrockstar.myapplication.data.source.Repository

class GetDataUseCase(private val repository: Repository) {

    suspend operator fun invoke(forceUpdate: Boolean = false, currentFiltering: FilterType): Result<List<String>> {

        val postResult = repository.getResponse(forceUpdate, currentFiltering)

        if (postResult is Result.Success<*>) {
            return if (postResult.data.isNotEmpty()) {
                Result.Success(postResult.data)
            } else {
                Result.Error(Response("Error de sincronización de datos", "", 500))
            }
        }
        return postResult
    }

}