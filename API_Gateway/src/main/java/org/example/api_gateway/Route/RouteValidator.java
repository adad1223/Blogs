package org.example.api_gateway.Route;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
@Component
public class RouteValidator {
    public static final List<String> endpoints = List.of("/login", "/register", "/validate/**");

    public Predicate<ServerHttpRequest> validateRoute() {
        return request -> endpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
    }
}
