package com.ex.skydictionary.internal.mapper

interface IMapper<In, Out> {

    fun map(data: In): Out

}
