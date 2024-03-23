package Statement;

import Expr.Node;
import Expr.SyntaxErrorException;
import GameState.Player;


public interface Statement extends Node {
    boolean execute(Player user) throws SyntaxErrorException;
}
