package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.GameState.Player;
import com.example.UpbeatWebSocket.GameState.Region;
import com.example.UpbeatWebSocket.GameState.Territory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlayerRepository implements PlayerService{
    private List<String> players = new ArrayList<>();
    @Override
    public List<String> createPlayer(String name) {
        if(players.contains(name))
            return players;
        players.add(name);
        return players;
    }
    @Override
    public String getPlayer(String name) {
        if (players.contains(name)){
            return name;
        }
        return "Not Found";
    }

    @Override
    public List<String> getPlayers() {
        return  players ;
    }

}
