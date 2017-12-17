package gq.baijie.speedtest.module

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.http.HttpMethod
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono


@Configuration
class EchoConfiguration {

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

}

fun echo(request: ServerRequest): Mono<ServerResponse> {
    // ...
    /*println(request.toString())
    println(request.queryParams())
    println(request.headers())
    println(request.attributes())
    println(request.cookies())*/
    request.apply {
        listOf(toString(),
                queryParams(),
                headers(),
                attributes(),
                cookies())
                .forEach { println(it) }
    }
//        println(request.body { inputMessage, _ -> inputMessage.body.reduce(0){t, u -> t + u.capacity() }.block() })
//        println(request.body { inputMessage, _ -> inputMessage.body.reduce{t, u -> t.write(u) }.block() }?.asByteBuffer()?.let { StandardCharsets.UTF_8.decode(it) })
//        println(request.body { inputMessage, _ -> inputMessage.body.reduce{t, u -> t.write(u) }.block()}?.let { StandardCharsets.UTF_8.decode(it.asByteBuffer()) })
//        println(request.body(BodyExtractors.toFormData()).block())
//        println(request.body(BodyExtractors.toMono(String::class.java)).block())
//        println(request.bodyToMono(String::class.java).block())
//        println(request.bodyToMono<String>().block())
    println()

//        return ServerResponse.ok().body(Mono.just(request.toString()), String::class.java)
//        return ServerResponse.ok().body(request.bodyToMono<String>())
//        return ServerResponse.ok().body(request.bodyToFlux<DataBuffer>())
    return ServerResponse.ok()
            .apply { request.headers().contentType().ifPresent { contentType(it) } }
            .body(request.bodyToFlux<DataBuffer>())
}
