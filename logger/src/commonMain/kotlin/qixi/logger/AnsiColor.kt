package qixi.logger

internal const val ansiEsc = "\u001b["
internal const val ansiDefault = "${ansiEsc}0m"

sealed class AnsiColor(val foreground: Int?, val background: Int?) {
    val enabled = foreground != null || background != null
    private val both = foreground != null && background != null

    class Both(foreground: Int, background: Int) : AnsiColor(foreground, background)

    class Foreground(color: Int) : AnsiColor(color, null)

    class Background(color: Int) : AnsiColor(null, color)

    fun call(text: String): String = if (enabled) "${this}$text$ansiDefault" else text

    override fun toString(): String = when {
        both -> "${ansiEsc}38;5;${foreground}m${ansiEsc}48;5;${background}m"
        foreground != null -> "${ansiEsc}38;5;${foreground}m"
        background != null -> "${ansiEsc}48;5;${background}m"
        else -> ""
    }

    fun toBackground(): AnsiColor = Background(this.foreground ?: 0)

    fun toForeground(): AnsiColor = Foreground(this.background ?: 0)

}