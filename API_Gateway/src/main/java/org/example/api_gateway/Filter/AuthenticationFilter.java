package org.example.api_gateway.Filter;

import org.example.api_gateway.Route.RouteValidator;
import org.example.api_gateway.Util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;
    @Autowired
    private JWT jwt;
    @Autowired
    private RestTemplate template;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest loggedInUser = null;
            if (validator.validateRoute().test(exchange.getRequest())) {

                System.out.println("HEY");
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
//                System.out.println("********"+authHeader);
                try {
                    //REST call to AUTH service

                    System.out.println("Logged in user: " + jwt.extractUserName(authHeader));
                    template.getForObject("http://auth-service:9898/auth/validate/" + authHeader, String.class);
                    loggedInUser = exchange.getRequest().mutate().header("LoggedInUser", jwt.extractUserName(authHeader)).build();
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("invalid access...!");
                    throw new RuntimeException("unauthorized access to application");
                }
            }
            else {
                System.out.println("NOTTT");
            }
            return chain.filter(exchange.mutate().request(loggedInUser).build());
        });
    }

    public static class Config {
    }
}