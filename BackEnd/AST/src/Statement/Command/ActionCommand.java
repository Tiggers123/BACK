package Statement.Command;

import GameState.Player;
import Statement.Statement;

import java.lang.management.ThreadInfo;
import java.util.Map;

public class ActionCommand implements Statement {
    private final String action;

    ActionCommand(String command){
        if (command.equals("done") || command.equals("relocate")){
            this.action =  command ;
        }
    }


    public StringBuilder prettyPrint(StringBuilder s) {
        s.append(this.action);
        return s;
    }


    @Override
    public void execute(Player user) {

    }
}
