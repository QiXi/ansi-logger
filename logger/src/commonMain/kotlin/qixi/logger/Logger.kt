package qixi.logger

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.toLocalDateTime

enum class LogPriority {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR
}

interface Logger {

    fun isLoggable(priority: LogPriority): Boolean

    fun log(
        priority: LogPriority,
        tag: String,
        message: String,
        throwable: Throwable?,
    )

    fun v(tag: String, message: () -> String) =
        log(LogPriority.VERBOSE, tag, message, throwable = null)

    fun d(tag: String, message: () -> String) =
        log(LogPriority.DEBUG, tag, message, throwable = null)

    fun i(tag: String, message: () -> String) =
        log(LogPriority.INFO, tag, message, throwable = null)

    fun w(tag: String, throwable: Throwable, message: () -> String) =
        log(LogPriority.WARN, tag, message, throwable = throwable)

    fun e(tag: String, throwable: Throwable, message: () -> String) =
        log(LogPriority.ERROR, tag, message, throwable = throwable)

    companion object {
        val None = object : Logger {
            override fun isLoggable(priority: LogPriority): Boolean = false
            override fun log(
                priority: LogPriority,
                tag: String,
                message: String,
                throwable: Throwable?,
            ) = Unit
        }
        val Console = object : Logger {
            override fun isLoggable(priority: LogPriority): Boolean = true
            override fun log(
                priority: LogPriority,
                tag: String,
                message: String,
                throwable: Throwable?,
            ) {
                val time = now().toLocalDateTime(timeZone).time
                val timeString = time.toString().substring(0, 12)
                val level = Levels.getFrom(priority)
                val color = LogColors.getFrom(priority)
                println("$timeString ${fixedTag(tag)} $level ${color.call(message)} ${throwable ?: ""}")
            }
        }
    }
}

internal inline fun Logger.log(
    priority: LogPriority, tag: String, message: () -> String, throwable: Throwable? = null,
) {
    if (isLoggable(priority)) log(priority, tag, message(), throwable)
}