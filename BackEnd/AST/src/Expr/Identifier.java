package Expr;

import GameState.Player;

import java.util.Map;

public class Identifier implements   Expression{
    public String name ;
    public Identifier(String name){
        this.name = name;
    }
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {
        if (user.variable.containsKey(name)){
            return  user.variable.get(name);
        }else {
            user.variable.put(name , 0.0);
            return user.variable.get(name);
        }
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(name);
        return  s ;
    }


}
