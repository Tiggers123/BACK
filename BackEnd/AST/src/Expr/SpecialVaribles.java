package Expr;

import java.util.Map;

public class SpecialVaribles implements Expression {
    String varibles ;
    public SpecialVaribles(String varibles){
        this.varibles = varibles ;
    }
    @Override
    public double evaluate(Map<String, Double> bindings) throws SyntaxErrorException {
//        if(name.equals("rows")) return player.territory().TERRITORY_ROW();
//        else if(name.equals("cols")) return player.territory().TERRITORY_COL();
//        else if(name.equals("currow")) return player.cityCrew.getRow();
//        else if(name.equals("curcol")) return player.cityCrew.getCol();
//        else if(name.equals("budget")) return Math.floor(player.getBudget());
//        else if(name.equals("deposit")){
//            double deposit = Math.floor(player.cityCrew.getDeposit());
//            if(player.cityCrew.owner == player) return deposit;
//            else return 0-deposit;
//        }else if(name.equals("int")) return Math.round(player.cityCrew.getInterestRate());
//        else if(name.equals("maxdeposit")) return player.territory().MAX_DEPOSIT();
//        else if(name.equals("random")) return Math.floor(Math.random()*1000);
//
//        if(!player.variableSet.containsKey(name)) player.variableSet.put(this.name, 0d);
//        return player.variableSet.get(name);
        return  0 ;
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

    }
}
