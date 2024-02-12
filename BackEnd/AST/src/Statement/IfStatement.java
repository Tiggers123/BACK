package Statement;

import Expr.Expression;
import GameState.Player;

import java.util.Map;

public class IfStatement implements Statement{
    private Expression condition ;
    private Statement statementAfterThen ;
    private Statement statementAfterElsE;
    public  IfStatement(Expression condition , Statement statementAfterThen , Statement statementAfterElsE){
        this.condition= condition;
        this.statementAfterThen = statementAfterThen ;
        this.statementAfterElsE = statementAfterElsE ;
    }
    @Override
    public void execute(Player user) {

    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }
}
