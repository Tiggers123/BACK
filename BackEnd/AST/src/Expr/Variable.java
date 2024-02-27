package Expr;

import GameState.Player;

public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Player player) throws SyntaxErrorException {
        // Retrieve the value of the variable from the player
        return player.getVariable(name);
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(name);
        return s;
    }
}
