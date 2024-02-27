package Expr;

import GameState.Player;

public interface Expression extends Node {
    double evaluate(Player user) throws SyntaxErrorException;
}
