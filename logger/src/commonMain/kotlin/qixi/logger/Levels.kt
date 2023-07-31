package qixi.logger

object Levels {

    val verbose = LevelColors.verbose.call(text = " V ")
    val debug = LevelColors.debug.call(text = " D ")
    val info = LevelColors.info.call(text = " I ")
    val warning = LevelColors.warning.call(text = " W ")
    val error = LevelColors.error.call(text = " E ")

    fun getFrom(level: LogPriority): String = when (level) {
        LogPriority.VERBOSE -> verbose
        LogPriority.DEBUG -> debug
        LogPriority.INFO -> info
        LogPriority.WARN -> warning
        LogPriority.ERROR -> error
    }

}

object LevelColors {

    val verbose = AnsiColor.Both(15, 7)
    val debug = AnsiColor.Both(15, 2)
    val info = AnsiColor.Both(15, 6)
    val warning = AnsiColor.Both(16, 11)
    val error = AnsiColor.Both(16, 1)

    fun getFrom(level: LogPriority): AnsiColor = when (level) {
        LogPriority.VERBOSE -> verbose
        LogPriority.DEBUG -> debug
        LogPriority.INFO -> info
        LogPriority.WARN -> warning
        LogPriority.ERROR -> error
    }

}