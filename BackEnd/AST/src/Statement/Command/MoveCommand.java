package Statement.Command;

import GameState.Player;
import GameState.Region;
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
        s.append("move");
        s.append(" ");
        s.append(this.Direction);
        return s;
    }

    @Override
    public boolean execute(Player user) {
        if(user.getBudget()< user.territory().getFee()){return false;}
        Region MoveTo = user.cityCrew.moveDirection(this.Direction);
        if (MoveTo == null) return  false ;
        if (MoveTo.owner == user || MoveTo.owner == null){
            user.cityCrew = MoveTo;
        }
        return true ;
    }
}
