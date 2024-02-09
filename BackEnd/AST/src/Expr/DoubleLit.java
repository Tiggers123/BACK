package Expr;

import GameState.Player;

import java.util.Map;

public class DoubleLit implements Expression {
    double val ;
    public DoubleLit(double val){
        this.val = val ;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(val);
        return s ;
    }
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {
        return val ;
    }
}
