package qixi.logger

object AnsiColors {

    // Foreground
    val default = AnsiColor.Foreground(0)
    val black = AnsiColor.Foreground(16)
    val red = AnsiColor.Foreground(1)
    val green = AnsiColor.Foreground(10)
    val yellow = AnsiColor.Foreground(11)
    val blue = AnsiColor.Foreground(12)
    val magenta = AnsiColor.Foreground(5)
    val cyan = AnsiColor.Foreground(14)
    val white = AnsiColor.Foreground(255)

    // Background
    val bgBlack = AnsiColor.Background(16)
    val bgRed = AnsiColor.Background(1)
    val bgGreen = AnsiColor.Background(10)
    val bgYellow = AnsiColor.Background(11)
    val bgBlue = AnsiColor.Background(12)
    val bgMagenta = AnsiColor.Background(5)
    val bgCyan = AnsiColor.Background(14)
    val bgWhite = AnsiColor.Background(15)

}