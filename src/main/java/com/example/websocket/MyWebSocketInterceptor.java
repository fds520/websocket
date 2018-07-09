package com.example.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @Author:bj
 * @Date:2018/6/28
 * @Desc:
 */
public class MyWebSocketInterceptor implements HandshakeInterceptor {

    /**
     * 在握手之前执行该方法, 继续握手返回true, 中断握手返回false. 通过attributes参数设置WebSocketSession的属性
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {

        if (request instanceof ServletServerHttpRequest) {
            String userId = ((ServletServerHttpRequest) request).getServletRequest().getParameter("userId");
            attributes.put("userId", userId);
        }

        return true;
    }

    /**
     * 在握手之后执行该方法. 无论是否握手成功都指明了响应状态码和相应头.
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {

    }
}