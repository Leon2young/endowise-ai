package org.endow.framework.test

import org.endow.framework.annotation.Param
import org.endow.framework.annotation.Tool
import java.io.File

class TestTools {

    @Tool(
        params = [
            Param(param = "city", description = "CityName", required = true)
        ],
        description = "getTodayWeather"
    )
    fun getWeather(city: String?): String {
        return "Today's weather is cloudy, with a high wind warning."
    }

    @Tool(description = "getUserCity")
    fun getCity(): String {
        return "Taian"
    }

   //写论文pdf
    @Tool(
        description = "writeFile",
        params = [
            Param(param = "filePath", description = "FilePath", required = true),
            Param(
                param = "content",
                description = "Content",
                required = true
            )],
        group = "article"
    )
    fun writeFile(filePath: String, content: String) {
        val file = File(filePath)
        file.writeText(content)
    }
    //读论文pdf
    @Tool(
        description = "readFile",
        params = [
            Param(param = "filePath", description = "FilePath", required = true)
        ],
        group = "article"
    )
    fun readFile(filePath: String): String {
        val file = File(filePath)
        return file.readText()
    }

}