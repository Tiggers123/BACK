package Statement;

import Expr.Expression;

import java.util.Map;

public class WhileStatement implements Statement{
    private Expression condition ;
    private Statement statement ;
    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append("while ( ");
        condition.prettyPrint(s);
        s.append(" ) ");
        statement.prettyPrint(s);
        return s ;
    }

    @Override
    public void execute(Map<String, Long> bindings) {

    }
}
