package com.example.UpbeatWebSocket.game;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    // Player Connect
    @MessageMapping("/room.addUser")
    @SendTo("/topic/public")
    public PlayerMessage addUser(PlayerMessage message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
    //Send Map
    @MessageMapping("/room.sendMap")
    @SendTo("/topic/public")
    public PlayerMessage addUser(PlayerMessage message) {
        return message;
    }


//    // สร้าง Game ใหม่
//    public void createGame() {
//        // สร้าง Game ใหม่
//    }
//
//    // สร้าง Game ใหม่
//    public void joinGame() {
//        // สร้าง Game ใหม่
//    }
//
//    // สร้าง Game ใหม่
//    public void startGame() {
//        // สร้าง Game ใหม่
//    }
//
//    // สร้าง Game ใหม่
//    public void endGame() {
//        // สร้าง Game ใหม่
//    }
}
