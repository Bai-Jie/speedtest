package gq.baijie.speedtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfiguration {

  @Bean
  public RouterFunction<ServerResponse> echoRouterFunction() {
    return route(GET("/echo").or(POST("/echo")), EchoHandlerKt::echo);
  }

  @Bean
  public RouterFunction<ServerResponse> userRouterFunction(UserHandler userHandler) {
    return route(GET("/users/{user}").and(accept(APPLICATION_JSON)), userHandler::getUser)
            .andRoute(GET("/users/{user}/customers").and(accept(APPLICATION_JSON)), userHandler::getUserCustomers)
            .andRoute(DELETE("/users/{user}").and(accept(APPLICATION_JSON)), userHandler::deleteUser);
  }

}
