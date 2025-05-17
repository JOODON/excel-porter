package springboot.base.template.excel_porter.parser.http

import org.springframework.web.multipart.MultipartFile

data class ParseRequest(
    val format: String,
    val inputText: String? = null,
    val inputFile: MultipartFile? = null
)