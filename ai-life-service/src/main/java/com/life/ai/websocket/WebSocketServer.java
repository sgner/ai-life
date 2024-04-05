package com.life.ai.websocket;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/ws/{sid}")
public class WebSocketServer {

}
