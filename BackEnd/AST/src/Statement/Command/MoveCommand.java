package Statement.Command;

import GameState.Player;
import Statement.Statement;

import java.util.Map;

public class MoveCommand implements Statement {
    Command command ;
    String Direction ;
    MoveCommand(Command command , String Direction){
        this.command = command ;
        this.Direction = Direction;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }

    @Override
    public void execute(Player user) {

    }
}
