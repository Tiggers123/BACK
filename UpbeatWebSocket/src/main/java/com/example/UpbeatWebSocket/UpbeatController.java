package com.example.UpbeatWebSocket;

import com.example.UpbeatWebSocket.Expr.SyntaxErrorExpr;
import com.example.UpbeatWebSocket.GameState.Player;
import com.example.UpbeatWebSocket.GameState.Territory;
import com.example.UpbeatWebSocket.Parser.SyntaxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/Play")
@RestController
public class UpbeatController {
    @Autowired
    private PlayerRepository playerService;

    @PostMapping("/player")
    public String createNewPlayer(@RequestBody PlayerAPI body){
        if (playerService.createPlayer(body)) return "Player created";
        return "Player already exists";
    }
    @PostMapping("/startGame")
    public int gameStart(@RequestBody boolean body){
        if (playerService.getConfigFile().isEmpty()) return 0;
        String[] nameOfPlayer = new String[playerService.getPlayers().size()];
        for (int i = 0; i < playerService.getPlayers().size(); i++) {
            nameOfPlayer[i] = playerService.getPlayers().get(i).getName();
        }

        int row  = playerService.getConfigFile().getFirst().getRow();
        int col = playerService.getConfigFile().getFirst().getCol();
        long init_budget = playerService.getConfigFile().getFirst().getInit_budget();
        long init_center_dep = playerService.getConfigFile().getFirst().getInit_center_dep();
        long rev_cost = playerService.getConfigFile().getFirst().getRev_cost();
        long max_dep = playerService.getConfigFile().getFirst().getMax_dep();
        long interest_pct = playerService.getConfigFile().getFirst().getInterest_pct();
        Territory territory = new Territory(row, col, init_budget, init_center_dep, rev_cost, interest_pct, max_dep, nameOfPlayer);
        playerService.addTerritory(territory);
        return territory.getTerritory_col();
    }



    @GetMapping("/players")
    public List<PlayerAPI> getPlayerInformation() {
        return playerService.getPlayers();
    }

    @PostMapping("/sendContruction")
    public void setContruction(@RequestBody String body) throws SyntaxErrorException, SyntaxErrorExpr {
        Territory territory = playerService.getPlayers().getFirst().getTerritory();
        Player p1 = territory.getPlayer().get(0);
        p1.Command(body);
        p1.evaluatePlan();
        updateMap();
    }
    private void updateMap(){
        Territory territory = playerService.getPlayers().getFirst().getTerritory();
        int[][] map = new int[territory.getTerritory_row()][territory.getTerritory_col()];
        for (int i = 0; i < territory.getTerritory_row(); i++){
            for (int j = 0; j < territory.getTerritory_col(); j++){
                if (territory.getRegion(i,j) == null) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 100 ;
                }
            }
        }
    }
    @PostMapping("/configfile")
    public String setconfig(@RequestBody ConfigFile body) {
        playerService.setConfigFile(body) ;
        return "Config file set";
    }
    @GetMapping("/config")
    public List<ConfigFile> getconfig() {
        return playerService.getConfigFile();
    }
}
