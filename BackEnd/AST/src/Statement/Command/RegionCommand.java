package Statement.Command;

import Expr.Expression;
import GameState.Player;
import GameState.Region;
import Statement.Statement;

import java.util.Map;

public class RegionCommand implements Statement {
    private Expression expression ;
    private  Command action;
    RegionCommand(Command action , Expression expression){
        this.action = action ;
        this.expression = expression ;
    }
    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }

    @Override
    public void execute(Player user) {

    }
}
