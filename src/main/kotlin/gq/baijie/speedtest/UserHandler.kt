package gq.baijie.speedtest

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

import reactor.core.publisher.Mono

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
