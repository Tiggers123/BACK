package Expr;

import java.util.Map;

public class Variable implements   Expression{
    String name ;
    public Variable(String name){
        this.name = name;
    }
    @Override
    public double evaluate(Map<String, Double> bindings) throws SyntaxErrorException {
        if (bindings.containsKey(name)){
            return  bindings.get(name);
        }
        throw new SyntaxErrorException("undefined varible: " + name);
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(name);
        return  s ;
    }


}
