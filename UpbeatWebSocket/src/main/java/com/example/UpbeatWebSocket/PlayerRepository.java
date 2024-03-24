package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.GameState.Player;
import com.example.UpbeatWebSocket.GameState.Region;
import com.example.UpbeatWebSocket.GameState.Territory;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Getter
public class PlayerRepository implements PlayerService{
    private List<PlayerAPI> players = new ArrayList<>() ;
    @Override
    public boolean createPlayer(PlayerAPI player) {
        if (players.contains(player)){
            return false;
        }
        players.add(player);
        return true;
    }


    @Override
    public PlayerAPI getPlayer(String name) {
        for (PlayerAPI player : players){
            if (player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }
    @Override
    public List<PlayerAPI> getPlayers() {
        return players;
    }



}
