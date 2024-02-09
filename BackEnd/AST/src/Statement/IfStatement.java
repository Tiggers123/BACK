package Statement;

import Expr.Expression;
import GameState.Player;

import java.util.Map;

public class IfStatement implements Statement{
    private Expression condition ;
    private Statement then ;
    private Statement ElsE;
    IfStatement(Expression condition , Statement then , Statement ElsE){
        this.condition= condition;
        this.then = then ;
        this.ElsE = ElsE ;
    }
    @Override
    public void execute(Player user) {

    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }
}
