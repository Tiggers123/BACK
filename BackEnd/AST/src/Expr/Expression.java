package Expr;

import java.util.*;

public interface Expression extends Node {
    double evaluate(Map<String, Double> bindings)throws SyntaxErrorException;;
}