package gq.baijie.speedtest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class RoutingConfiguration {

    @Bean
    fun echoRouterFunction(): RouterFunction<ServerResponse> {
//        return route(GET("/echo").or(POST("/echo")), HandlerFunction<ServerResponse> { echo(it) })
        return router {
//            GET("/echo", ::echo)
//            POST("/echo", ::echo)
//            (GET("/echo") or POST("/echo"))(::echo)
//            ((method(HttpMethod.GET) or method(HttpMethod.POST)) and "/echo")(::echo)
            val GET = method(HttpMethod.GET)
            val POST = method(HttpMethod.POST)
            ((GET or POST) and "/echo")(::echo)
        }
    }

    @Bean
    fun usersRouterFunction(userHandler: UserHandler): RouterFunction<ServerResponse> {
        return router {
            ("/users" and accept(APPLICATION_JSON)).nest {
                GET("/{user}", userHandler::getUser)
                GET("/{user}/customers", userHandler::getUserCustomers)
                DELETE("/{user}", userHandler::deleteUser)
            }
        }
    }

    @Bean
    fun testRouterFunction(userHandler: UserHandler): RouterFunction<ServerResponse> {
        //Java:  route(GET("/test"), request -> ServerResponse.ok().body(Mono.just("test66"), String.class));
//        return route(GET("/test"), HandlerFunction<ServerResponse> { _ -> ServerResponse.ok().body(Mono.just("test66"), String::class.java) })
        return router {
            GET("/test") { ServerResponse.ok().syncBody("test") }
        }
    }

}
