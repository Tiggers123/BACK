package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.GameState.Player;

import java.util.List;

public interface PlayerService {
    List<String> createPlayer(String name);
    String getPlayer(String name);
}
