package Statement.Command;

import Statement.Statement;

import java.util.Map;

public class RegionCommand implements Statement {
    @Override
    public void execute(Map<String, Long> bindings) {

    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }
}
