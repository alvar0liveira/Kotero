package com.alvaroliveira.core.data.usecase

import ItemItem
import com.alvaroliveira.core.common.UseCase
import com.alvaroliveira.core.data.repository.ItemsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCollectionItemsUseCase(
    dispatcher: CoroutineDispatcher,
    private val repo: ItemsRepository
): UseCase<GetCollectionItemsUseCase.Request, GetCollectionItemsUseCase.Response>(dispatcher) {

    override suspend fun process(request: Request): Flow<Response> {
        return repo
            .run {
                getItemsCollection(request.userId, request.collectionKey)
            }
            .map {
                Response(it)
            }

    }

    data class Request(
        val userId: String,
        val collectionKey: String
    ): UseCase.Request

    data class Response(
        val items: List<ItemItem>
    ): UseCase.Response
}