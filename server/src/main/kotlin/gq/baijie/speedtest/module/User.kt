package gq.baijie.speedtest.module

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

import reactor.core.publisher.Mono

@Configuration
class UserConfiguration {

    @Bean
    fun usersRouterFunction(userHandler: UserHandler): RouterFunction<ServerResponse> {
        return router {
            ("/users" and accept(MediaType.APPLICATION_JSON)).nest {
                GET("/{user}", userHandler::getUser)
                GET("/{user}/customers", userHandler::getUserCustomers)
                DELETE("/{user}", userHandler::deleteUser)
            }
        }
    }

}

@Component
class UserHandler {

    fun getUser(request: ServerRequest): Mono<ServerResponse> {
        // ...
        return ServerResponse.ok().syncBody("""{"name":"${request.pathVariable("user")}", "age": 17}""")
    }

    fun getUserCustomers(request: ServerRequest): Mono<ServerResponse> {
        // ...
        return Mono.empty()
    }

    fun deleteUser(request: ServerRequest): Mono<ServerResponse> {
        // ...
        return Mono.empty()
    }

}
