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
//    @GetMapping("/{name}")
//    public String hello(@PathVariable("name") String name){
//        return name;
//    }
    @PostMapping("/player")
    public List<String> createNewPlayer(@RequestBody String body){
        return this.playerService.createPlayer(body);
    }

//    @PutMapping("/player/{name}")
//    public Player addClick(@PathVariable("name") String name) {
////        Player player = playerService.incrementClick(name);
//        return player;
//    }

//    @GetMapping("/player/leaderboard")
//    public List<Player> getPlayerLeaderboard() {
//        return playerService.getPlayerLeaderboard();
//    }

    @GetMapping("/player/{name}")
    public String getPlayerInformation(@PathVariable("name") String name) {
        return playerService.getPlayer(name);
    }
}
