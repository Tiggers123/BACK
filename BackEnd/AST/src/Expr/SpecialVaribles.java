package Expr;

import GameState.Player;

public class SpecialVaribles implements Expression {
    String variables;
    public SpecialVaribles(String varibles){
        this.variables = varibles ;
    }
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {
        return 0;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        return  new StringBuilder() ;
    }
}
