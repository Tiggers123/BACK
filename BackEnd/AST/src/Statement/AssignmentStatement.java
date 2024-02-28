package Statement;

import Expr.*;
import GameState.Player;

public class AssignmentStatement implements Statement{
    private final Identifier identifier ;
    private final Expression expression ;

    public AssignmentStatement(Identifier identifier , Expression expression){
        this.identifier = identifier ;
        this.expression = expression ;
    }

    @Override
    public boolean execute(Player user) throws SyntaxErrorException {
        String v = this.identifier.getName();
//        if (user.variable.containsKey(v)){
//            user.variable.
//            return true ;
//        }
        double value = this.expression.evaluate(user);
        user.variable.put(v,value);
        return true;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        this.identifier.prettyPrint(s);
        s.append(" = ");
        this.expression.prettyPrint(s);
        return s;
    }
}
