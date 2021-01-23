package com.mx.terryrockstar.myapplication.utils

import com.mx.terryrockstar.myapplication.base.domain.usecase.GetDataUseCase
import com.mx.terryrockstar.myapplication.data.source.ResponseRepository
import com.mx.terryrockstar.myapplication.data.source.local.LocalSource
import com.mx.terryrockstar.myapplication.data.source.remote.RemoteSource

class Injection {

    companion object {
        private fun provideRepository(): ResponseRepository {
            return ResponseRepository.getInstance(RemoteSource.getInstance(), LocalSource.getInstance())
        }

        fun provideGetDataUseCase() : GetDataUseCase{
            return GetDataUseCase(provideRepository())
        }
    }

}