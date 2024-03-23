package com.example.UpbeatWebSocket.game;

import lombok.Getter;

import java.awt.*;
@Getter
public class PlayerMessage {
    private String content;
    private String sender;
    private MessageType type;
}
