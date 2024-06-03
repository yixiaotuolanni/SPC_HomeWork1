package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/circuitBreakerA")
    public Mono<String> circuitBreakerAFallback(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("Service is temporarily unavailable due to circuit breaker.");
    }
}
