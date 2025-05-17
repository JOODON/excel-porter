package springboot.base.template.excel_porter.parser.util

import java.io.File
import java.io.InputStream

object InputStreamUtil {

    fun toInputStream(input: Any): InputStream = when (input) {
        is InputStream -> input
        is String -> input.byteInputStream()
        is ByteArray -> input.inputStream()
        is File -> input.inputStream()
        else -> throw IllegalArgumentException("Unsupported input type: ${input::class}")
    }
}