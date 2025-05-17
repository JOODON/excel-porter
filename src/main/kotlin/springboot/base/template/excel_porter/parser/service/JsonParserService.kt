package springboot.base.template.excel_porter.parser.service

import org.springframework.http.HttpStatus
import springboot.base.template.excel_porter.exception.CustomException
import springboot.base.template.excel_porter.logger.LoggerUtil
import java.io.InputStream

class JsonParserService(
    private val loggerUtil: LoggerUtil
) : ParserService {

    override fun parse(inputStream: InputStream): List<Map<String, Any>> {
        //TODO 추후 개발
        return emptyList()
    }

    override fun parse(inputString: String): List<Map<String, Any>> {
        loggerUtil.logInfo("Entered JsonParserService.parse() with input")

        if (!isJson(inputString)){
            throw CustomException(errorCode = 101,     message = "유효한 JSON 배열 문자열이 아닙니다.",  httpStatus = HttpStatus.NOT_FOUND)
        }

        return emptyList()
    }


    fun isJson(inputString: String) : Boolean {
        return false
    }

}