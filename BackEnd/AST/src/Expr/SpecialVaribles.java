package Expr;

import GameState.Player;

import java.util.Map;

public class SpecialVaribles implements Expression {
    String varibles ;
    public SpecialVaribles(String varibles){
        this.varibles = varibles ;
    }
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {

    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

    }
}
