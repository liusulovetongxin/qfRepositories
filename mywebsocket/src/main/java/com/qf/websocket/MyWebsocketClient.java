package com.qf.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @version V1.0
 * @Project mywebsocket
 * @Package com.qf.websocket
 * @Description:
 * @Date 2022/5/31 11:14
 */
@ServerEndpoint("/websocket/{name}")
public class MyWebsocketClient {

    private String name;
    private Session session;

    private static Map<String, Session> allClients = new ConcurrentHashMap<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session) {
        System.err.println("MyWebsocketClient中的方法onOpen 执行了------>"+name+"=====>"+session);
        allClients.put(name, session);
        this.name = name;
        this.session = session;
    }


    @OnMessage
    public void onMessage(Session session, String message) {
        System.err.println("MyWebsocketClient中的方法onMessage 执行了"+"---->"+session+"=======>"+message);

        try {
            Map<String,String> map = objectMapper.readValue(message, Map.class);
            String toUser = map.get("toUser");
            String msg = map.get("msg");
            Session toSession = allClients.get(toUser);
            if (toSession != null&&toSession.isOpen()) {
                toSession.getAsyncRemote().sendText("收到来自于:" + name + " 的消息,内容是:" + msg);
            }else{
                session.getAsyncRemote().sendText("对方不在线");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @OnClose
    public void onClose(Session session) {
        System.err.println("MyWebsocketClient中的方法onClose 执行了"+"---->"+session);
        allClients.remove(name);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("MyWebsocketClient中的方法onError 执行了" + "---->" + session + "======>" + throwable.getMessage());
        allClients.remove(name);
    }
}
