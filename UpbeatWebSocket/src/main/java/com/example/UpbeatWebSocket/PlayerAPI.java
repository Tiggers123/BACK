package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.game.MessageType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlayerAPI {
    private String name;
    private String plan;
    private int money;

}
