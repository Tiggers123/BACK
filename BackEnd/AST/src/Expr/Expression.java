package Expr;

import GameState.Player;

import java.util.*;

public interface Expression extends Node {
    double evaluate(Player user)throws SyntaxErrorException;;
}