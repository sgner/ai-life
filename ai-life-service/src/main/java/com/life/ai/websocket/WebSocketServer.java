package com.life.ai.websocket;

import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;
import org.apache.ibatis.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/ws/{sid}")
public class WebSocketServer {
//    static Log log = Lo
    @OnOpen
    public void onOpen(){
        System.out.println("");
    }
}
