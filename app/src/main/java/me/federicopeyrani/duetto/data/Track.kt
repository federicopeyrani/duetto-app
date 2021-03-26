package me.federicopeyrani.duetto.data

import me.federicopeyrani.spotify_web_api.objects.ImageObject
import me.federicopeyrani.spotify_web_api.objects.TrackObject
import java.util.concurrent.TimeUnit
import kotlin.time.toDuration

fun TrackObject.toTrack() = Track(
    id = id,
    title = name,
    artist = artists.joinToString(", ") { it.name },
    album = album.name,
    duration = duration
        .toDuration(TimeUnit.MILLISECONDS)
        .toComponents { min, sec, _ -> "$min:${sec.toString().padStart(2, '0')}" },
    albumArtUrls = album.images
)

class Track(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val duration: String,
    val albumArtUrls: Array<ImageObject>,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Track

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}