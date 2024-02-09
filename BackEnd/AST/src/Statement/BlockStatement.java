package Statement;

import java.util.Map;

public class BlockStatement implements Statement{

    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }

    @Override
    public void execute(Map<String, Long> bindings) {

    }
}
