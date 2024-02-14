package Statement.Command;

import GameState.Player;
import Statement.Statement;

public class ActionCommand implements Statement {
    private final String action;

    public ActionCommand(String command){
        this.action =  command ;
    }


    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(this.action);
        return s;
    }


    @Override
    public boolean execute(Player user) {
        if(action.equals("relocate")){
            int CenterRow = user.cityCenter.getRow();
            int CenterCol = user.cityCenter.getCol();
            int userRow = user.cityCrew.getRow();
            int userCol = user.cityCrew.getCol();
            double distance = Math.ceil(Math.sqrt(Math.pow(userCol - CenterCol,2)+Math.pow(userRow - CenterRow,2)));
            double cost = 5 * distance + 10 ;
            if (user.getBudget() >= cost && (user.cityCrew.owner == user)){
                user.subBudget(cost);
                user.cityCenter = user.cityCrew;
            }
        }
        return false;
    }
}
