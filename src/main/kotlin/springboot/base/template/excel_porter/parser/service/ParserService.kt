package springboot.base.template.excel_porter.parser.service

import org.springframework.stereotype.Service
import java.io.InputStream

@Service
interface ParserService {
    fun parse(inputStream: InputStream): List<Map<String, Any>>  // 파일, 바이너리용
    fun parse(inputString: String): List<Map<String, Any>>     // 텍스트용
}