import com.alvaroliveira.core.model.collection.CollectionsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsService {
    //@Headers("Authorization: Bearer XjajOkXQppRePjDsMBpIEt8Z")
    @GET("users/{id}/collections")
    suspend fun getAllCollections(@Path("id") id: String): List<CollectionsItem>

    //@Headers("Authorization: Bearer XjajOkXQppRePjDsMBpIEt8Z")
    @GET("users/{userId}/collections/{collectionId}/items/")
    suspend fun getTopItemsCollection(
        @Path("userId") userId: String,
        @Path("collectionId") collectionId: String,
        @Query("limit") limit: Int = 100,
        @Query("start") start: Int = 0,
    ): List<ItemItem>

    @GET("users/{userId}/items/{itemKey}")
    suspend fun getItem(
        @Path("userId") userId: String,
        @Path("itemKey") itemKey: String
    ): ItemItem

    @Headers("Content-Type: application/pdf")
    @GET("users/{userId}/items/{itemKey}/file/view")
    suspend fun getPDF(
        @Path("userId") userId: String,
        @Path("itemKey") itemKey: String
    ): Call<Nothing>
}