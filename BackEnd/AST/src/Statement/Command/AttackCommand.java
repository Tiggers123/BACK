package Statement.Command;

import Expr.Expression;
import Expr.SyntaxErrorException;
import GameState.Player;
import GameState.Region;
import Statement.Statement;
import GameState.Territory;

public class AttackCommand implements Statement {
    String Direction ;
    Expression expression ;
    public AttackCommand(String Direction, Expression expression){
        this.Direction = Direction;
        this.expression = expression ;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append("shoot ");
        s.append(this.Direction);
        s.append(" ");
        s.append(this.expression);
        return s;
    }

    @Override
    public boolean execute(Player user) throws SyntaxErrorException {
        double cost = this.expression.evaluate(user);

        if(user.getBudget() < user.territory().getFee()) return true;
        user.subBudget(user.territory().getFee());

        if(user.getBudget() < cost) return true;
        user.subBudget(cost);

        //missing direction
    }
}
