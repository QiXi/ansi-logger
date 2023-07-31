package qixi.logger

object LogColors {

    val verbose = AnsiColor.Foreground(7)
    val debug = AnsiColor.Foreground(2)
    val info = AnsiColor.Foreground(4)
    val warning = AnsiColor.Foreground(214)
    val error = AnsiColor.Foreground(1)

    fun getFrom(level: LogPriority): AnsiColor = when (level) {
        LogPriority.VERBOSE -> verbose
        LogPriority.DEBUG -> debug
        LogPriority.INFO -> info
        LogPriority.WARN -> warning
        LogPriority.ERROR -> error
    }

}