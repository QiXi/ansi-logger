package qixi.logger

import kotlinx.datetime.TimeZone

internal val timeZone = TimeZone.currentSystemDefault()
private const val TAG_FORMATTER = "                    "
private const val FORMATTER_LENGTH = TAG_FORMATTER.length

internal fun fixedTag(tag: String): String {
    if (tag.contains(ansiEsc)) return tag
    return if (tag.length > FORMATTER_LENGTH) {
        tag.substring(0, FORMATTER_LENGTH)
    } else {
        "$tag${TAG_FORMATTER.substring(0, FORMATTER_LENGTH - tag.length)}"
    }
}

public fun colorTag(tag: String, color: AnsiColor): String {
    return color.call(fixedTag(tag))
}