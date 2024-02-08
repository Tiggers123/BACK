package Expr;

import java.util.*;

public interface Expression extends Node {
    void evaluate(Map<String, Double> bindings);
}