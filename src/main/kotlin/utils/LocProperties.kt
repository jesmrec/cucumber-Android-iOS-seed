package utils

import java.io.FileInputStream
import java.io.IOException
import java.util.Properties

class LocProperties private constructor() {

    companion object {
        var properties: Properties? = null
    }

    init {
        try {
            val properties: Properties? = Properties()
            val inputStream = FileInputStream("execution.properties")
            properties?.load(inputStream)
        } catch (e: IOException) {

        }
    }


}
