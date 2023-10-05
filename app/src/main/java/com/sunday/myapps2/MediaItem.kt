package com.sunday.myapps2

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
) {
    enum class Type { PHOTO, VIDEO }
}

// elementos de prueba
fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "https://loremflickr.com/400/400/cat?lock=$it",
        type = if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
    )
}
