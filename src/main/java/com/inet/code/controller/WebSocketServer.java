package com.inet.code.controller;

import com.inet.code.entity.vo.SocketUserInfo;
import com.inet.code.util.JwtUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName test
 * @Description
 * @Author drh
 * @Data 11:15 下午
 * @Version 1.0
 **/
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers=new CopyOnWriteArraySet<WebSocketServer>();

    private static ConcurrentHashMap<String, List<Session>> onlineNumberMap =new ConcurrentHashMap<>();

    private Session session;
    @OnOpen
    public void onOpen(Session session,@PathParam("Token") String token,@PathParam("Sid")String Sid){
        List<Session> sessionList = onlineNumberMap.computeIfAbsent(Sid, k -> new ArrayList<>());
        sessionList.add(session);

    }

    @OnClose
    public void onClose(Session session,@PathParam("Sid")String Sid){
        List<Session> sessionList = onlineNumberMap.get(Sid);
        sessionList.remove(session);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("Sid")String Sid,@PathParam("Token")String token) throws IOException {
        List<Session> sessions = onlineNumberMap.get(Sid);
        for (Session session1:sessions){
            session1.getBasicRemote().sendText(message);
        }
    }
    @OnError
    public void onError(Session session,Throwable throwable){
        System.out.println("发生异常");
        throwable.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }



}
