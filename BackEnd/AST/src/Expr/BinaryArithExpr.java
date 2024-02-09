package Expr;

import java.util.Map;

public class BinaryArithExpr implements Expression{
    Expression left ;
    Expression right ;
    String op ;
    public BinaryArithExpr(Expression left , String op , Expression right){
        this.left = left ;
        this.op = op;
        this.right = right ;
    }
    @Override
    public double evaluate(Map<String, Double> bindings) throws SyntaxErrorException {
        double lv = left.evaluate(bindings);
        double rv = right.evaluate(bindings);
        double result = 0;
        if (op.equals("+")){result = lv + rv ;}else
        if (op.equals("-")){result =lv - rv ;}else
        if (op.equals("*")) {result = lv * rv;}else
        if (op.equals("/")) {result = lv / rv;}else
        if (op.equals("%")) {result = lv % rv;}else
        if (op.equals("^")) {result = Math.pow(lv, rv);}else {throw new SyntaxErrorException("Don't found operater");}
        if (result == 0){
            result = Math.abs(result);
        }
        return result ;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append("(");
        left.prettyPrint(s);
        s.append(op);
        right.prettyPrint(s);
        s.append(")");
        return s ;
    }
}
