package Expr;

import java.util.Map;

public class IntLit implements Expression {
    double val ;
    public IntLit(double val){
        this.val = val ;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(val);
        return s ;
    }
    @Override
    public double evaluate(Map<String, Double> bindings) throws SyntaxErrorException {
        return val ;
    }
}
