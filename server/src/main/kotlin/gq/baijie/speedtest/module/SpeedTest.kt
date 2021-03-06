package gq.baijie.speedtest.module

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Configuration
class SpeedTestConfiguration {
    @Bean
    fun speedTestRouterFunction() = router {
        GET("/speedtest", ::speedTest)
    }
}

fun speedTest(request: ServerRequest): Mono<ServerResponse> {
    val blockSize = request.queryParam("blocksize").orElse(null)?.toBigIntegerOrNull()?:1.toBigInteger()
    val blockCount = request.queryParam("blockcount").orElse(null)?.toBigIntegerOrNull()?:512.toBigInteger()
    return ServerResponse.ok()
            .contentLength((blockCount * blockSize).toLong())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(body(blockCount.toLong(), blockSize.toInt()))
}

fun body(blockCount: Long, blockSize: Int): Flux<ByteArray> = Flux.just(ByteArray(blockSize)).repeat(blockCount)
