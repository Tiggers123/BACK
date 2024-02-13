package Statement.Command;

import GameState.Player;
import Statement.Statement;

import java.util.Map;

public class MoveCommand implements Statement {
    String command ;
    String Direction ;
    public  MoveCommand(String command , String Direction){
        this.command = command ;
        this.Direction = Direction;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }

    @Override
    public boolean execute(Player user) {

    }
}
