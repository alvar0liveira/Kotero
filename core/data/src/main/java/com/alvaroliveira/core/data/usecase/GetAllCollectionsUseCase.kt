package com.alvaroliveira.core.data.usecase

import com.alvaroliveira.core.common.UseCase
import com.alvaroliveira.core.data.repository.CollectionsRepository
import com.alvaroliveira.core.model.collection.CollectionsItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllCollectionsUseCase(
    dispatcher: CoroutineDispatcher,
    private val repo: CollectionsRepository
): UseCase<GetAllCollectionsUseCase.Request, GetAllCollectionsUseCase.Response>(dispatcher) {

    data class Request(
        val userId: String
    ): UseCase.Request

    data class Response(
        val collections: List<CollectionsItem>
    ): UseCase.Response

    override suspend fun process(request: Request): Flow<Response> {
        return repo.getAllCollections(request.userId)
            .map {
                Response(it)
            }
    }
}