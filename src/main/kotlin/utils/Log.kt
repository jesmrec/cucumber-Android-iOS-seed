package utils

import io.pages.LoginPage
import java.io.IOException
import java.time.LocalDateTime
import java.util.Date
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

object Log {
    var logger: Logger = Logger.getLogger(LoginPage::class.java.getName())
    private var fileHandler: FileHandler? = null
    private val platform: String = System.getProperty("platform")

    fun init() {
        try {
            logger.getLevel()
            //Adding log files to folder called "logs", created
            fileHandler = FileHandler(
                "logs/" + platform + "_" + LocalDateTime.now().toString() + ".log",
                5 * 1024000, 1, true
            )
            fileHandler!!.setFormatter(object : SimpleFormatter() {
                private val format = "[%1\$tF %1\$tT] [%2$-7s] %3\$s %n"

                @Synchronized
                override fun format(logRecord: LogRecord): String {
                    return String.format(
                        format,
                        Date(logRecord.millis),
                        logRecord.level.localizedName,
                        logRecord.message
                    )
                }
            })
            logger.setLevel(Level.FINE)
            fileHandler!!.setLevel(Level.FINE)
            logger.addHandler(fileHandler)
        } catch (e: IOException) {
            log(Level.SEVERE, "Exception in FileHandler: " + e.message)
        }
    }

    fun log(level: Level, message: String) {
        logger.log(level, message)
    }
}
