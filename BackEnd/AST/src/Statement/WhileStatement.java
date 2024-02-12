package Statement;

import Expr.Expression;
import GameState.Player;

import java.util.Map;

public class WhileStatement implements Statement{
    private final Expression condition ;
    private final Statement statement ;
    public  WhileStatement(Expression condition , Statement statement){
        this.condition = condition ;
        this.statement = statement ;
    }
    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append("while ( ");
        condition.prettyPrint(s);
        s.append(" ) ");
        statement.prettyPrint(s);
        return s ;
    }

    @Override
    public void execute(Player user) {

    }
}
