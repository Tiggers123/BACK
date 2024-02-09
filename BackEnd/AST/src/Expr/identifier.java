package Expr;

import java.util.Map;

public class identifier implements   Expression{
    String name ;
    public identifier(String name){
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
