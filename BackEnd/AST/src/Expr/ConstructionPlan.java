package Expr;

import GameState.Player;
import Statement.Statement;

import java.util.*;

public class ConstructionPlan implements Node {
    private List<Statement> statementList;

    public ConstructionPlan(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public StringBuilder prettyPrint(StringBuilder s) {
        for (Statement statement : this.statementList){
            statement.prettyPrint(s);
            s.append("/n");
        }
        return s ;
    }


    public void execute(Player user) throws SyntaxErrorException {
        for (Statement statement : this.statementList){
            if (!(statement.execute(user))) return ; // if false return
        }
    }
}

