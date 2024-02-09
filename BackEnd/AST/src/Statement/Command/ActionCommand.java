package Statement.Command;

import Statement.Statement;

import java.util.Map;

public class ActionCommand implements Statement {
    private Command action;

    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(this.action);
        return s;
    }

    public void execute(Map<String, Long> bindings) {

    }
}
