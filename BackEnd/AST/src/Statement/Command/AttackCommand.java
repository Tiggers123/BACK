package Statement.Command;

import Expr.Expression;
import GameState.Player;
import Statement.Statement;

import java.util.Map;

public class AttackCommand implements Statement {
    String Direction ;
    Expression expression ;
    public AttackCommand(String Direction, Expression expression){
        this.Direction = Direction;
        this.expression = expression ;

    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        return s;
    }

    @Override
    public boolean execute(Player user) {
        return false;
    }
}
