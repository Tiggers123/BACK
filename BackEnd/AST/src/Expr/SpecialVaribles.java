package Expr;

import GameState.Player;

import java.util.Random;

public class SpecialVaribles implements Expression {
    String variables;
    public SpecialVaribles(String varibles){
        this.variables = varibles ;
    }
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {
        if (variables.equals("rows")){return user.territory().getTerritory_row() ;}else
        if (variables.equals("cols")){return user.territory().getTerritory_col() ;}else
        if (variables.equals("currow")){return user.cityCrew.getRow();}else
        if (variables.equals("curcol")){return  user.cityCrew.getCol();}else
        if (variables.equals("budget")){return  user.getBudget();}else
        if (variables.equals("deposit")){return user.cityCrew.getDeposit() ;}else
        if (variables.equals("int")){return  user.cityCrew.getInterestRate() ;}else
        if (variables.equals("maxdeposit")){return user.territory().getDEPOSITMax() ;}else
        if (variables.equals("random")){
            Random rand = new Random();
            int random = rand.nextInt(1000);
            return random ;
        }
        return 0;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        return  s.append(variables) ;
    }
}
