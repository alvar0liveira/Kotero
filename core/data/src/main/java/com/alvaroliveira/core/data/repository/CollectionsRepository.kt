package com.alvaroliveira.core.data.repository

import com.alvaroliveira.core.model.collection.CollectionsItem
import kotlinx.coroutines.flow.Flow

interface CollectionsRepository {
    suspend fun getAllCollections(userId: String): Flow<List<CollectionsItem>>
}