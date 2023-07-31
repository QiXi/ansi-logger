package qixi.logger.test

import org.junit.jupiter.api.Test
import qixi.logger.AnsiColors
import qixi.logger.Logger
import qixi.logger.colorTag

class Simple {

    val logger = Logger.Console
    val blueTag = colorTag("blue Tag", AnsiColors.blue)
    val redTag = colorTag("red Tag", AnsiColors.red)
    val greenTag = colorTag("green Tag", AnsiColors.green)
    val cyanTag = colorTag("cyan Tag", AnsiColors.cyan)
    val yellowTag = colorTag("yellow Tag", AnsiColors.yellow)
    val magentaTag = colorTag("magenta Tag", AnsiColors.magenta)
    val whiteTag = colorTag("white Tag", AnsiColors.white)

    @Test
    fun main() {
        logger.v("TAG") { "message" }
        logger.v(whiteTag) { "message" }
        logger.v(blueTag) { "message" }
        logger.d(redTag) { "debug message" }
        logger.d(greenTag) { "debug message" }
        logger.i(cyanTag) { "info message" }
        logger.w(yellowTag, Throwable("warning")) { "message" }
        logger.e(magentaTag, Throwable("error")) { "message" }
    }

}