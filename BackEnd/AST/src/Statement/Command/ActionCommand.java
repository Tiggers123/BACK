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
    public boolean execute(Player user) throws SyntaxErrorException {
//        return true;
    }
}
