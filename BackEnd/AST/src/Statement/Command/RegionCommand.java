package Statement.Command;

import Expr.Expression;
import Expr.SyntaxErrorException;
import GameState.Player;
import GameState.Region;
import Statement.Statement;


public class RegionCommand implements Statement {
    private Expression expression ;
    private  String action;
    public RegionCommand(String action, Expression expression){
        this.action = action ;
        this.expression = expression ;
    }
    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }

    @Override
    public boolean execute(Player user) throws SyntaxErrorException {
        Region region = user.getCityCrew();
        double fee = user.territory().getFee();
        if (this.action.equals("invest")){
            double amount = expression.evaluate(user);
            user.subBudget(fee);
            if(user.getBudget() < amount) {
                return true;
            } else {
                region.setOwner(user);
                region.addDeposit(amount);
                user.subBudget(amount);
                return true;
            }
            // collect
        }else {
            double collect = expression.evaluate(user);
            if (user.getBudget() < fee){
                return  false ;
            }
            user.subBudget(fee);
            if(region.getDeposit() < collect) {
                return true;
            } else {
                region.subDeposit(collect);
                user.addBudget(collect);
                if (region.getDeposit() == 0 ) region.ClearRegion(user) ;
            }

        }
        return true;

    }
}
