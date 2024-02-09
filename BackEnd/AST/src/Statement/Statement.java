package Statement;

import Expr.Node;
import GameState.Player;

import java.util.*;

public interface Statement extends Node {
    void execute(Player user);
}
