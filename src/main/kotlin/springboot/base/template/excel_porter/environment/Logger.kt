package springboot.base.template.excel_porter.environment

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class Logger(
    private val environmentUtils: EnvironmentUtils
) {

    @PostConstruct
    fun logEnvironment() {
        println("✅ 현재 애플리케이션 환경: ${environmentUtils.getEnvironment()}")
    }
}