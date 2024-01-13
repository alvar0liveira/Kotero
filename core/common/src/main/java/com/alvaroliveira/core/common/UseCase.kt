package com.alvaroliveira.core.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

abstract class UseCase<I: UseCase.Request, O: UseCase.Response>(
    private val dispatcher: CoroutineDispatcher
) {
    interface Request
    interface Response

    suspend fun execute(request: I): Flow<Result<O>> = process(request)
        .map {
            Result.success(it)
        }
        .flowOn(dispatcher)
        .catch {
            emit(Result.failure(it))
        }

    abstract suspend fun process(request: I): Flow<O>
}