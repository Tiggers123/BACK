package Statement.Command;

import Expr.SyntaxErrorException;
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
    public boolean execute(Player user) throws SyntaxErrorException {
        if(user.getBudget()< user.territory().getFee()){return false;}
        user.subBudget(user.territory().getFee());
        Region MoveTo = user.getCityCrew().moveDirection(this.Direction);
        if (MoveTo == null) return  true ;
        if (MoveTo.getOwner() == user || MoveTo.getOwner() == null){
            user.setCityCrew(MoveTo);
        }
        return true ;
    }
}
