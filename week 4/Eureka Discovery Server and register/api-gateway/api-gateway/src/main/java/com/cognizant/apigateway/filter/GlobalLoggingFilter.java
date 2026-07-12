package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalLoggingFilter implements GlobalFilter, Ordered {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        logger.info("==================================");
        logger.info("Incoming Request");
        logger.info("Method : {}", exchange.getRequest().getMethod());
        logger.info("URI    : {}", exchange.getRequest().getURI());
        logger.info("Path   : {}", exchange.getRequest().getPath());
        logger.info("==================================");

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() ->
                        logger.info("Response Status : {}",
                                exchange.getResponse().getStatusCode())));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}