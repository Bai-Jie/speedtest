package gq.baijie.speedtest.module

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class TestConfiguration {

    @Bean
    fun testRouterFunction() = router {
        GET("/test") { ServerResponse.ok().syncBody("test") }
    }

}
