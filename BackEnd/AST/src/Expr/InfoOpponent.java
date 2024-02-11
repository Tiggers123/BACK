package Expr;

import GameState.Player;

public class InfoOpponent implements  Expression{
    public  InfoOpponent(){};
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {
        return 0;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        return null;
    }
}
