package Expr;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

class BinaryArithExprTest {
    DoubleLit zero = new DoubleLit(0);
    DoubleLit one = new DoubleLit(1);
    DoubleLit Neone = new DoubleLit(-1);
    DoubleLit LargeInt = new DoubleLit(1000);
    DoubleLit LargeInt2 = new DoubleLit(1001);
    DoubleLit LargeNeInt = new DoubleLit(-1000);
    DoubleLit LargeNeInt2 = new DoubleLit(-1001);
    Map<String,  Double> table = new HashMap<>();
    public void Upmap(Map<String,  Double> table) {
        table.put("x",100.0);
    }

    @Test
    public void Plush() throws SyntaxErrorException {
        Upmap(table);
        assertEquals(1,new BinaryArithExpr(zero,"+" , one).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"+" , zero).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(zero,"+" , Neone).evaluate(table));
        assertEquals(1000,new BinaryArithExpr(zero,"+" , LargeInt).evaluate(table));
        assertEquals(-1000,new BinaryArithExpr(zero,"+" , LargeNeInt).evaluate(table));
    }
    @Test
    public void SubT()throws  SyntaxErrorException{
        Upmap(table);
        assertEquals(-1*one.evaluate(table),new BinaryArithExpr(zero,"-" , one).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"-" , zero).evaluate(table));
        assertEquals(1,new BinaryArithExpr(zero,"-" , Neone).evaluate(table));
        assertEquals(-1*LargeInt.evaluate(table),new BinaryArithExpr(zero,"-" , LargeInt).evaluate(table));
        assertEquals(-1*LargeNeInt.evaluate(table),new BinaryArithExpr(zero,"-" , LargeNeInt).evaluate(table));
    }
    @Test
    public void MutiP()throws SyntaxErrorException{
        assertEquals(0,new BinaryArithExpr(zero,"*" , one).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"*" , zero).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"*" , Neone).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"*" , LargeInt).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"*" , LargeNeInt).evaluate(table));
    }
    @Test void Divi()throws  SyntaxErrorException{
        assertEquals(0,new BinaryArithExpr(zero,"/" , one).evaluate(table));
        assertEquals(NaN,new BinaryArithExpr(zero,"/" , zero).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"/" , Neone).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"/" , LargeInt).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"/" , LargeNeInt).evaluate(table));
    }
    @Test void ModPer()throws  SyntaxErrorException{
        assertEquals(0,new BinaryArithExpr(zero,"%" , one).evaluate(table));
        assertEquals(NaN,new BinaryArithExpr(zero,"%" , zero).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"%" , Neone).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"%" , LargeInt).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"%" , LargeNeInt).evaluate(table));
    }
    @Test void Powe()throws  SyntaxErrorException{
        assertEquals(0,new BinaryArithExpr(zero,"^" , one).evaluate(table));
//        assertEquals(NaN,new BinaryArithExpr(zero,"^" , zero).evaluate(table));
        assertEquals(POSITIVE_INFINITY,new BinaryArithExpr(zero,"^" , Neone).evaluate(table));
        assertEquals(0,new BinaryArithExpr(zero,"^" , LargeInt).evaluate(table));
        assertEquals(POSITIVE_INFINITY,new BinaryArithExpr(zero,"^" , LargeNeInt).evaluate(table));

        assertEquals(1,new BinaryArithExpr(one,"^" , one).evaluate(table));
        assertEquals(1,new BinaryArithExpr(one,"^" , zero).evaluate(table));
        assertEquals(1,new BinaryArithExpr(one,"^" , Neone).evaluate(table));
        assertEquals(1,new BinaryArithExpr(one,"^" , LargeInt).evaluate(table));
        assertEquals(1,new BinaryArithExpr(one,"^" , LargeNeInt).evaluate(table));

        assertEquals(-1,new BinaryArithExpr(Neone,"^" , one).evaluate(table));
        assertEquals(1,new BinaryArithExpr(Neone,"^" , zero).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(Neone,"^" , Neone).evaluate(table));
        assertEquals(1,new BinaryArithExpr(Neone,"^" , LargeInt).evaluate(table));
        assertEquals(1,new BinaryArithExpr(Neone,"^" , LargeNeInt).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(Neone,"^" , LargeInt2).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(Neone,"^" , LargeNeInt2).evaluate(table));


        assertEquals(-1,new BinaryArithExpr(Neone,"^" , one).evaluate(table));
        assertEquals(1,new BinaryArithExpr(Neone,"^" , zero).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(Neone,"^" , Neone).evaluate(table));
        assertEquals(1,new BinaryArithExpr(Neone,"^" , LargeInt).evaluate(table));
        assertEquals(1,new BinaryArithExpr(Neone,"^" , LargeNeInt).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(Neone,"^" , LargeInt2).evaluate(table));
        assertEquals(-1,new BinaryArithExpr(Neone,"^" , LargeNeInt2).evaluate(table));
    }
}