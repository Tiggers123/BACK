package Statement.Command;

import Expr.SyntaxErrorException;
import GameState.Player;
import Statement.Statement;

import java.lang.management.ThreadInfo;
import java.util.Map;

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
            int RowCenter = user.cityCenter.getRow();
            int ColCenter = user.cityCenter.getCol();
            int userRow = user.cityCrew.getRow();
            int userCol = user.cityCrew.getCol();
            //Do something more than
        }

        return true;
    }
}
