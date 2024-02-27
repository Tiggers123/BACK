package Expr;

import GameState.Player;
import GameState.Region;
import GameState.Territory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public void Upmap(Map<String,  Double> table) {
        table.put("x",100.0);
    }



    public Player doplayer() {
        List<Player> player =new ArrayList<>();
        Territory map = new Territory(9 , 9 , 100 ,100 ,100 ,100 ,100 , new String[]{"Ton"});
        ConstructionPlan x = new ConstructionPlan(new ArrayList<>());
        Player ton = new Player("Ton" , map , new Region(1 , 1));
        ton.variable.put("x" , 100.0);
        return  ton ;
    }

    @Test
    public void Plush() throws SyntaxErrorException {
        Player user = doplayer();
        assertEquals(1, new BinaryArithExpr(zero, "+", one).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "+", zero).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(zero, "+", Neone).evaluate(user));
        assertEquals(1000, new BinaryArithExpr(zero, "+", LargeInt).evaluate(user));
        assertEquals(-1000, new BinaryArithExpr(zero, "+", LargeNeInt).evaluate(user));
    }

    @Test
    public void SubT() throws SyntaxErrorException{
        Player user = doplayer();
        assertEquals(-1 * one.evaluate(user), new BinaryArithExpr(zero, "-", one).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "-", zero).evaluate(user));
        assertEquals(1, new BinaryArithExpr(zero, "-", Neone).evaluate(user));
        assertEquals(-1 * LargeInt.evaluate(user), new BinaryArithExpr(zero, "-", LargeInt).evaluate(user));
        assertEquals(-1 * LargeNeInt.evaluate(user), new BinaryArithExpr(zero, "-", LargeNeInt).evaluate(user));
    }

    @Test
    public void MutiP() throws SyntaxErrorException{
        Player user = doplayer();
        assertEquals(0, new BinaryArithExpr(zero, "*", one).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "*", zero).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "*", Neone).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "*", LargeInt).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "*", LargeNeInt).evaluate(user));
    }

    @Test
    void Divi() throws SyntaxErrorException{
        Player user = doplayer();
        assertEquals(0, new BinaryArithExpr(zero, "/", one).evaluate(user));
        assertThrows(ArithmeticException.class, () -> {
            new BinaryArithExpr(zero, "/", zero).evaluate(user);
        });
        assertEquals(0, new BinaryArithExpr(zero, "/", Neone).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "/", LargeInt).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "/", LargeNeInt).evaluate(user));
    }


    @Test
    void ModPer() throws SyntaxErrorException{
        Player user = doplayer();
        assertEquals(0, new BinaryArithExpr(zero, "%", one).evaluate(user));
        assertEquals(NaN, new BinaryArithExpr(zero, "%", zero).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "%", Neone).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "%", LargeInt).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "%", LargeNeInt).evaluate(user));
    }

    @Test
    void Powe() throws SyntaxErrorException{
        Player user = doplayer();
        assertEquals(0, new BinaryArithExpr(zero, "^", one).evaluate(user));
//        assertEquals(NaN,new BinaryArithExpr(zero,"^" , zero).evaluate(table));
        assertEquals(POSITIVE_INFINITY, new BinaryArithExpr(zero, "^", Neone).evaluate(user));
        assertEquals(0, new BinaryArithExpr(zero, "^", LargeInt).evaluate(user));
        assertEquals(POSITIVE_INFINITY, new BinaryArithExpr(zero, "^", LargeNeInt).evaluate(user));

        assertEquals(1, new BinaryArithExpr(one, "^", one).evaluate(user));
        assertEquals(1, new BinaryArithExpr(one, "^", zero).evaluate(user));
        assertEquals(1, new BinaryArithExpr(one, "^", Neone).evaluate(user));
        assertEquals(1, new BinaryArithExpr(one, "^", LargeInt).evaluate(user));
        assertEquals(1, new BinaryArithExpr(one, "^", LargeNeInt).evaluate(user));

        assertEquals(-1, new BinaryArithExpr(Neone, "^", one).evaluate(user));
        assertEquals(1, new BinaryArithExpr(Neone, "^", zero).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(Neone, "^", Neone).evaluate(user));
        assertEquals(1, new BinaryArithExpr(Neone, "^", LargeInt).evaluate(user));
        assertEquals(1, new BinaryArithExpr(Neone, "^", LargeNeInt).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(Neone, "^", LargeInt2).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(Neone, "^", LargeNeInt2).evaluate(user));


        assertEquals(-1, new BinaryArithExpr(Neone, "^", one).evaluate(user));
        assertEquals(1, new BinaryArithExpr(Neone, "^", zero).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(Neone, "^", Neone).evaluate(user));
        assertEquals(1, new BinaryArithExpr(Neone, "^", LargeInt).evaluate(user));
        assertEquals(1, new BinaryArithExpr(Neone, "^", LargeNeInt).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(Neone, "^", LargeInt2).evaluate(user));
        assertEquals(-1, new BinaryArithExpr(Neone, "^", LargeNeInt2).evaluate(user));
    }

    @Test
    void DivisionByZero() {
        Player user = doplayer();
        assertThrows(ArithmeticException.class, () -> {
            new BinaryArithExpr(one, "/", zero).evaluate(user);
            new BinaryArithExpr(Neone, "/", zero).evaluate(user);
        });
    }

    @Test
    void CombinationOfOperations() throws SyntaxErrorException {
        Player user = doplayer();
        // Test combination of operations
        assertEquals(5.0, new BinaryArithExpr(new BinaryArithExpr(new DoubleLit(2), "+", new DoubleLit(3)), "*", new DoubleLit(1)).evaluate(user));
        // Expected result: 5.0
    }

    @Test
    public void testConstructionPlan() throws SyntaxErrorException, Parser.SyntaxErrorException {
        Player player = setUpGame();

        List<String> p = Command("t=1+5");
        player.setPlan(p);
        player.evaluatePlan();
        assertEquals(6,player.variable.get("t"));

        double deposit = player.getCityCrew().getDeposit();
        p = Command("d = deposit / 4");
        player.setPlan(p);
        player.evaluatePlan();
        assertEquals(deposit / 4, player.variable.get("d"));

        double budget = player.getBudget();
        p = Command("b = budget - 25");
        player.setPlan(p);
        player.evaluatePlan();
        assertEquals(budget - 25, player.variable.get("b"));
    }




    private List<String> Command(String command){
        List<String> file =  new ArrayList<>();
        file.add(command);
        return file;
    }

    public Player setUpGame()  {
        String[] p = {"Ton"};
        Territory map = new Territory(5, 5, 110000, 500, 100, 100, 100, p);
        List<Player> p1 = map.getPlayer();
        return p1.get(0);
    }
}
