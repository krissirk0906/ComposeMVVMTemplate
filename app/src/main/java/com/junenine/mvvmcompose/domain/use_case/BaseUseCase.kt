package com.junenine.composeWithMVVM.domain.use_case

interface BaseUseCase<In, Out> {
    fun execute(input: In): Out
}