import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class ConstructionPlanParser {
    private ArrayList<String> tokens ;
    private int currentTokenIndex;
    public ConstructionPlanParser(ArrayList<String> tokens){
        this.tokens = tokens ;
        this.currentTokenIndex = 0 ;
    }
    public void parse(){
        while (currentTokenIndex < tokens.size()){
            Statement();
        }
    }
    public void Statement(){
        if (match("if")) {
            IfStatement();
        } else if (match("while")) {
            WhileStatement();
        } else if (match("{")) {
            BlockStatement();
        } else {
            Command();
        }
    }
    public void Command(){
        if (matchIdentifier()) {
            AssignmentStatement();
        } else {
            ActionCommand();
        }
    }
    public void AssignmentStatement(){
        Expression();
    }
    public void ActionCommand(){
        String token = tokens.get(currentTokenIndex);
        switch (token) {
            case "done":
                /// have to give more
            case "relocate":
//                match(token);
                break;
            case "move":
                MoveCommand();
                break;
            case "invest":
            case "collect":
                RegionCommand();
                break;
            case "shoot":
                AttackCommand();
                break;
            default:
                throw new RuntimeException("Invalid action command: " + token);
        }

    }
    public void MoveCommand(){
        expect("move");
        Direction();
    }
    public void RegionCommand(){
        if (match("invest") || match("collect")) {
            Expression();
        } else {
            throw new RuntimeException("Invalid region command");
        }
    }
    public void AttackCommand(){
        expect("shoot");
        Direction();
        Expression();
    }
    public void Direction(){
        String[] validDirections = {"up", "down", "upleft", "upright", "downleft", "downright"};
        String token = tokens.get(currentTokenIndex);
        if (Arrays.asList(validDirections).contains(token)) {
            match(token);
        } else {
            throw new RuntimeException("Invalid direction: " + token);
        }
    }
    public void BlockStatement(){
        while (!peek().equals("}")) {
            Statement();
        }
        expect("}");
    }
    public void IfStatement(){
        expect("(");
        Expression();
        expect(")");
        expect("then");
        Statement();
        expect("else");
        Statement();
    }
    public void WhileStatement(){
        expect("(");
        Expression();
        expect(")");
        Statement();
    }
    public void Expression(){
        expect("=");
        Term();
        while (match("+") || match("-")) {
            Term();
        }
    }
    public void Term (){
        Factor();
        while (match("*") || match("/") || match("%")) {
            Factor();
        }
    }
    public void Factor (){
        Power();
        while (match("^")) {
            Factor();
        }
    }
    public void Power(){
        if (matchNumber() || matchIdentifier()) {
            // Do nothing for simplicity
        } else if (match("(")) {
            Expression();
            expect(")");
        } else if (match("opponent") || match("nearby")) {
            InfoExpression();
        }
    }
    public void InfoExpression(){
        if (match("opponent") || match("nearby")) {
            Direction();
        } else {
            throw new RuntimeException("Invalid InfoExpression");
        }
    }
    public boolean match(String token) {
        if (currentTokenIndex < tokens.size() && tokens.get(currentTokenIndex).equals(token)) {
            currentTokenIndex++;
            return true;
        }
        return false;
    }

    private boolean matchIdentifier() {
        String token = tokens.get(currentTokenIndex);
        if (Pattern.matches("[a-zA-Z][a-zA-Z0-9]*", token) && !isReservedWord(token)){
            currentTokenIndex++;
            return true;
        }else {return false ;}
    }

    private boolean matchNumber() {
        String token = tokens.get(currentTokenIndex);
        try {
            long number = Long.parseLong(token);
            currentTokenIndex++;
            return number >= 0;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private boolean isReservedWord(String token) {
        List<String> reservedWords = Arrays.asList(
                "collect", "done", "down", "downleft", "downright", "else", "if", "invest",
                "move", "nearby", "opponent", "relocate", "shoot", "then", "up", "upleft",
                "upright", "while"
        );
        return reservedWords.contains(token);
    }
    public String expect(String token) {
        if (match(token)) {
            if (currentTokenIndex <= 0) {return tokens.get(currentTokenIndex) ;
            }else {
                return tokens.get(currentTokenIndex - 1);
            }
        } else {
            throw new RuntimeException("Expected token: " + token);
        }

    }
//    public boolean matchEx(String token) {
//        if (currentTokenIndex < tokens.size() && tokens.get(currentTokenIndex+1).equals(token)) {
//            currentTokenIndex++;
//            return true;
//        }
//        return false;
//    }
    public String peek() {
        if (currentTokenIndex < tokens.size()) {
            return tokens.get(currentTokenIndex);
        }
        return "";
    }
}
