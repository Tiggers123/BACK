package Expr;

import Statement.Statement;

import java.util.*;

public class ConstructionPlan implements Statement {
    private final List<Statement> statementList;

    public ConstructionPlan(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public StringBuilder prettyPrint(StringBuilder s) {
        return s;
    }

    public void execute(Map<String, Long> bindings) {

    }
}

