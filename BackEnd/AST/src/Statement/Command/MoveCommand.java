package Statement.Command;

import GameState.Player;
import GameState.Region;
import Statement.Statement;


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
        Region MoveTo = user.getCityCrew().moveDirection(this.Direction);
        if (MoveTo == null) return  true ;
        if (MoveTo.owner == user || MoveTo.owner == null){
            user.setCityCrew(MoveTo);
        }
        return true ;
    }
}
