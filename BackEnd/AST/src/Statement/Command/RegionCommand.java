package Statement.Command;

import Expr.Expression;
import Expr.SyntaxErrorException;
import GameState.Player;
import GameState.Region;
import Statement.Statement;

import java.util.Map;

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
        Region region =  user.cityCrew;
        double fee = user.territory().getFee();
        if (this.action.equals("invest")){
            double cost = expression.evaluate(user)+fee;
            if(user.getBudget() < cost) {
                user.subBudget(fee);
                return false ;
            } else {
                region.owner = user ;
                region.addDeposit(cost-fee);
                user.subBudget(cost);
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
                if (region.getDeposit() == 0 ) region.DeleteRegion(user) ;
                user.addBudget(collect);
            }

        }
        return true;

    }
}
