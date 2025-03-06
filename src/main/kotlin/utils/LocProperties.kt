package utils

import java.nio.file.Files
import java.nio.file.Paths
import java.util.Properties

class LocProperties() {

    companion object {

        val properties: Properties = Properties()

        init {
            try {
                Files.newInputStream(Paths.get("execution.properties")).use { properties.load(it) }
            } catch (e: Exception) {
                println("Fail when loading properties file: ${e.message}")
            }
        }

        fun getProperty(clave: String): String? = properties.getProperty(clave)
    }
}
