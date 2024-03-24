package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.GameState.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/Play")
@RestController
public class UpbeatController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public String createNewPlayer(@RequestBody PlayerAPI body){
        if (playerService.createPlayer(body)) return "Player created";
        return "Player already exists";
    }
    @GetMapping("/players")
    public List<PlayerAPI> getPlayerInformation() {
        return playerService.getPlayers();
    }
    @GetMapping("/configfile")
    public List<String> setconfig(@RequestBody String body) {
        return null;
    }
}
