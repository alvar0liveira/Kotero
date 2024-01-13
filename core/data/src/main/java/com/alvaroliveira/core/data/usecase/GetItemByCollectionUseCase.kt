package com.alvaroliveira.core.data.usecase

import ItemItem
import com.alvaroliveira.core.common.UseCase
import com.alvaroliveira.core.data.repository.ItemsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class GetItemByCollectionUseCase(
    dispatcher: CoroutineDispatcher,
    private val repo: ItemsRepository
): UseCase<GetItemByCollectionUseCase.Request, GetItemByCollectionUseCase.Response>(dispatcher) {

    override suspend fun process(request: Request): Flow<Response> {
        return repo
            .getItem(request.userId, request.itemKey, request.collectionKey)
            .map {
                Response(it)
            }
    }

    data class Request(
        val userId: String,
        val itemKey: String,
        val collectionKey: String
    ): UseCase.Request

    data class Response(
        val item: ItemItem
    ): UseCase.Response
}