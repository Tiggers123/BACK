package Statement;

import Expr.Expression;
import Expr.SyntaxErrorException;
import GameState.Player;

public class WhileStatement implements Statement{
    private final Expression expression ;
    private final Statement statement ;
    public  WhileStatement(Expression expression , Statement statement){
        this.expression = expression ;
        this.statement = statement ;
    }
    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append("while ( ");
        expression.prettyPrint(s);
        s.append(" ) ");
        statement.prettyPrint(s);
        return s ;
    }

    @Override
    public boolean execute(Player user) throws SyntaxErrorException {
        double e = this.expression.evaluate(user);
        for (int counter = 0; counter < 10000 && e > 0; counter++){
            if(!this.statement.execute(user)){
                return false;
            }
            e = this.expression.evaluate(user);
        }
        return true;
    }
}
