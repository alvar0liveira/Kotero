import com.alvaroliveira.core.database.entity.item.ItemEntity
import com.alvaroliveira.core.model.common.Library
import com.alvaroliveira.core.model.common.toItemLibraryEntity
import com.alvaroliveira.core.model.common.toLibrary
import com.alvaroliveira.core.model.item.Data
import com.alvaroliveira.core.model.item.LinksX
import com.alvaroliveira.core.model.item.Meta
import com.alvaroliveira.core.model.item.toItemData
import com.alvaroliveira.core.model.item.toItemDataEntity
import com.alvaroliveira.core.model.item.toItemLinksEntity
import com.alvaroliveira.core.model.item.toItemMeta
import com.alvaroliveira.core.model.item.toItemMetaEntity
import com.alvaroliveira.core.model.item.toLinksX
import com.squareup.moshi.Json

data class ItemItem(
    @Json(name = "data")
    val itemData: Data?,
    @Json(name = "key")
    val key: String,
    @Json(name = "library")
    val library: Library?,
    @Json(name = "links")
    val links: LinksX?,
    @Json(name = "meta")
    val meta: Meta?,
    @Json(name = "version")
    val version: Int?
)

fun ItemItem.toItemEntity(): ItemEntity {
    return ItemEntity(
        itemData = itemData?.toItemDataEntity(),
        keyOfItem = key,
        libraryOfItem = library?.toItemLibraryEntity(),
        linksOfItem = links?.toItemLinksEntity(),
        metaOfItem = meta?.toItemMetaEntity(),
        versionOfItem = version ?: 0
    )
}


fun ItemEntity.toItemItem(): ItemItem {
    return ItemItem(
        itemData = itemData?.toItemData(),
        key = keyOfItem,
        library = libraryOfItem?.toLibrary(),
        links = linksOfItem?.toLinksX(),
        meta = metaOfItem?.toItemMeta(),
        version = versionOfItem
    )
}