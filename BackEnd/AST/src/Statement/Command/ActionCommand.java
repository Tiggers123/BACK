package AST.Statement.Command;

import AST.Statement.Statement;

import java.util.Map;

public class ActionCommand implements Statement {
    private Command action;

    public void prettyPrint(StringBuilder s) {
        s.append(this.action);
    }

    public void execute(Map<String, Long> bindings) {

    }
}
