package com.junenine.composeTemplate.domain.useCase

interface BaseUseCase<In, Out> {
    fun execute(input: In): Out
}