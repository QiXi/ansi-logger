# Ansi-logger

KMP logger

<img src="images/simple.png" width="773" height="185">

## Usage

```kotlin
    val logger = Logger.Console
    val redTag = colorTag("Class", AnsiColors.red)
    logger.v(redTag) { "message" }
```
