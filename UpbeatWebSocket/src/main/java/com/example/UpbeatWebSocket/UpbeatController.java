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
    public List<String> createNewPlayer(@RequestBody String body){
        return this.playerService.createPlayer(body);
    }



    @GetMapping("/player/{name}")
    public String getPlayerInformation(@PathVariable("name") String name) {
        return playerService.getPlayer(name);
    }
}
