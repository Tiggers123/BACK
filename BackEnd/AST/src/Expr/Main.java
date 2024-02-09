package Expr;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SyntaxErrorException {
        Map<String,  Double> table = new HashMap<>();
        table.put("x",100.0);
        DoubleLit one = new DoubleLit(100) ;
        DoubleLit two = new DoubleLit(100);
        identifier x = new identifier("x");
        BinaryArithExpr o = new BinaryArithExpr(one ,"^", two );
        System.out.println(o.evaluate(table));
    }
}
