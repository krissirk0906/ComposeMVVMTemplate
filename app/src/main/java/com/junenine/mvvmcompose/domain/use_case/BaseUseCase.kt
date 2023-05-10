package com.junenine.mvvmcompose.domain.use_case

interface BaseUseCase<In, Out> {
    fun execute(input: In): Out
}