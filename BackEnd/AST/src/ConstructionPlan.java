
import AST.Statement.Statement;

import java.util.*;

public class ConstructionPlan implements Statement {
    private final List<Statement> statementList;

    public ConstructionPlan(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public void prettyPrint(StringBuilder s) {

    }

    public void execute(Map<String, Long> bindings) {

    }
}

