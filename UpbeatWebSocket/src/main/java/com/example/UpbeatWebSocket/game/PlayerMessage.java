package com.example.UpbeatWebSocket.game;

import lombok.Builder;
import lombok.Getter;

import java.awt.*;
@Getter
@Builder
public class PlayerMessage {
    private String content;
    private String sender;
    private MessageType type;
}
