package springboot.base.template.excel_porter.parser.factory

import org.springframework.stereotype.Component
import springboot.base.template.excel_porter.logger.LoggerUtil
import springboot.base.template.excel_porter.parser.service.JsonParserService
import springboot.base.template.excel_porter.parser.service.ParserService

@Component
class ParsingServiceFactory(
    private val loggerUtil: LoggerUtil
) {

    fun create(format: String): ParserService = when(format.lowercase()) {
        "json" -> JsonParserService(loggerUtil)
//        "csv" -> CsvParsingService()
//        "xml" -> XmlParsingService()
        else -> throw IllegalArgumentException("Unsupported format: $format")
    }

}