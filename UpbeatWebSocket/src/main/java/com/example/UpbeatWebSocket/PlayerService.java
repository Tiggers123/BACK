package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.GameState.Player;

import java.util.List;

public interface PlayerService {
    boolean createPlayer(PlayerAPI player);
    PlayerAPI getPlayer(String name);
    List<PlayerAPI> getPlayers();

}
