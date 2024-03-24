package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.GameState.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UpbeatController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public String createNewPlayer(@RequestBody String body){
        if (this.playerService.getPlayers().contains(body)){
            return "Player already exists";
        }
        this.playerService.createPlayer(body);
        return "Player created";
    }



    @GetMapping("/players")
    public List<String> getPlayerInformation() {
        return playerService.getPlayers();
    }
}
