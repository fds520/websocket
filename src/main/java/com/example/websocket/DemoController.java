package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * @author: fds
 * @date: 2018/7/9
 * @description: 描述
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private WebSocketPushHandler webSocketPushHandler;

    @GetMapping("/test/{userId}")
    public void test(@PathVariable(value = "userId") String userId) {

        System.out.println("测试竟来了");
        TextMessage textMessage = new TextMessage("后台主动推送消息".getBytes());
        webSocketPushHandler.sendMessageToUser(userId, textMessage);
    }
}
