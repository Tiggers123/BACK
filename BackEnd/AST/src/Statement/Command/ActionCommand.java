package Statement.Command;

import Expr.SyntaxErrorException;
import GameState.Player;
import Statement.Statement;


public class ActionCommand implements Statement {
    private final String action;

    public ActionCommand(String command){
        if (command.equals("done") || command.equals("relocate")){
            this.action =  command ;
        }
        else this.action = "";
    }


    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(this.action);
        return s;
    }

    @Override
    public boolean execute(Player user) throws SyntaxErrorException{
        if(action.equals("relocate")){
            int CenterRow = user.getCityCenter().getRow();
            int CenterCol = user.getCityCenter().getCol();
            int userRow = user.getCityCrew().getRow();
            int userCol = user.getCityCrew().getCol();
            double distance = Math.ceil(Math.sqrt(Math.pow(userCol - CenterCol,2)+Math.pow(userRow - CenterRow,2)));
            double cost = 5 * distance + 10 ;
            if (user.getBudget() >= cost && (user.getCityCrew().getOwner() == user)){
                user.subBudget(cost);
                user.setCityCenter(user.getCityCrew());
            }
        }
        return false;
    }
}
