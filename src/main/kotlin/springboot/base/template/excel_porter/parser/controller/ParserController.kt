package springboot.base.template.excel_porter.parser.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import springboot.base.template.excel_porter.parser.factory.ParsingServiceFactory
import springboot.base.template.excel_porter.parser.http.ParseRequest
import springboot.base.template.excel_porter.parser.util.InputStreamUtil
import springboot.base.template.excel_porter.utils.CommonResponse
import springboot.base.template.excel_porter.utils.SuccessResponse

@RestController
@RequestMapping("/api/parser")
class ParserController(
    private val parsingServiceFactory: ParsingServiceFactory
) {

    @PostMapping("/text")
    fun uploadTextType(@RequestBody parseRequest : ParseRequest) : ResponseEntity<CommonResponse> {
        val parsingService = parsingServiceFactory.create(parseRequest.format) //해당 텍스트 서비스 객체 받기

        //결과값 처리
        val result = parseRequest.inputText?.let { parsingService.parse(it) }
            ?: throw IllegalArgumentException("inputText is required")

        return ResponseEntity.ok(SuccessResponse(message = "Text Type Parsing Map Success", data = result))
    }

    @PostMapping("/file/{format}")
    fun uploadFileType(
        @PathVariable format: String,
        @RequestParam("file") file: MultipartFile
    ): ResponseEntity<CommonResponse> {
        val inputStream = file.inputStream
        //TODO 추가 개발
        return ResponseEntity.ok(SuccessResponse(message = "File Type Parsing Map Success", data = null))
    }


}