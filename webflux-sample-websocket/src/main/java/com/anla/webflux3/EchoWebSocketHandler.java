package com.anla.webflux3;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

public class EchoWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session
            .receive()
            .map(WebSocketMessage::getPayloadAsText)
            // 收到直接返回
            .map(tm -> "Echo: " + tm)
            .map(session::textMessage)
            .as(session::send);
    }
}
