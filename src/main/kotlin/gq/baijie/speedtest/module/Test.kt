package gq.baijie.speedtest.module

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class TestConfiguration {

    @Bean
    fun testRouterFunction(userHandler: UserHandler): RouterFunction<ServerResponse> {
        //Java:  route(GET("/test"), request -> ServerResponse.ok().body(Mono.just("test66"), String.class));
//        return route(GET("/test"), HandlerFunction<ServerResponse> { _ -> ServerResponse.ok().body(Mono.just("test66"), String::class.java) })
        return router {
            GET("/test") { ServerResponse.ok().syncBody("test") }
        }
    }

}
