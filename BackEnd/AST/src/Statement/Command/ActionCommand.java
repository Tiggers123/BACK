package Statement.Command;

import GameState.Player;
import Statement.Statement;

import java.lang.management.ThreadInfo;
import java.util.Map;

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
    public void execute(Player user) {
        if(action.equals("relocate")){
            int RowCenter = user.cityCenter.getRow();
            int ColCenter = user.cityCenter.getCol();
            int userRow = user.cityCrew.getRow();
            int userCol = user.cityCrew.getCol();
        }

    }
}
