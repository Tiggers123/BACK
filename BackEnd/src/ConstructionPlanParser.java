
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class ConstructionPlanParser {
    private final ExprTokenizer line ;
    public ConstructionPlanParser(ExprTokenizer Lineinput){
        this.line = Lineinput ;
    }
    public void parse() throws SyntaxErrorException {
        while (this.line.line.size() != line.pos){
            Statement();
        }
    }
    public void Statement() throws SyntaxErrorException {
        if (line.peek("if")) {
            line.consume("if");
            IfStatement();
        } else if (line.peek("while")) {
            line.consume("while");
            WhileStatement();
        } else if (line.peek("{")) {
            line.consume("{");
            BlockStatement();
        } else {
            Command();
        }
    }
    public void Command() throws SyntaxErrorException {
        if (line.peek().matches("\\b(?:done|relocate|move|invest|collect|shoot)\\b")){
            ActionCommand();
        }else if (matchIdentifier()) {
            line.consume();
            AssignmentStatement();
        }

    }
    public void AssignmentStatement() throws SyntaxErrorException {
        line.consume("=");
        Expression();
    }
    public void ActionCommand() throws SyntaxErrorException {
        if(line.peek("done")) {
            line.consume("done");
            System.out.println("Turn is end");
        }
        if(line.peek("relocate")){
            line.consume("relocate");
            System.out.println("Turn is end");
        }
        if (line.peek("move")){
            line.consume("move");
            MoveCommand();
        }
        if(line.peek("invest")){
            RegionCommand();}
        if(line.peek("collect")){
            RegionCommand();}
        if(line.peek("shoot")){
            AttackCommand();
        }

    }
    public void MoveCommand() throws SyntaxErrorException {
        Direction();
    }
    public void RegionCommand() throws SyntaxErrorException {
        if(line.peek("invest")){
            line.consume("invest");
            Expression();
        }
        if(line.peek("collect")){
            line.consume("collect");
            line.consume("(");
            Expression();
            line.consume(")");
        }
    }
    public void AttackCommand() throws SyntaxErrorException {
        if(line.peek("shoot")){
            line.consume("shoot");
            Direction();
            Expression();
        }else {
            throw new SyntaxErrorException("Invalid command");
        }
    }
    public void Direction() throws SyntaxErrorException {
        String[] validDirections = {"up", "down", "upleft", "upright", "downleft", "downright" };
        String token = line.peek();
        if (Arrays.asList(validDirections).contains(token)) {
            // need to fix
            line.consume();
            System.out.println(line.peek());
        } else {
            throw new RuntimeException("Invalid direction: " + token);
        }
    }
    public void BlockStatement() throws SyntaxErrorException {
        while (!line.peek().equals("}")) {
            Statement();
        }
        if (line.peek("}")){
            line.consume("}");
        }
    }
    public void IfStatement() throws SyntaxErrorException {
        line.consume("(");
        Expression();
        line.consume(")");
        line.consume("then");
        Statement();
        line.consume("else");
        Statement();
    }
    public void WhileStatement() throws SyntaxErrorException {
        line.consume("(");
        Expression();
        line.consume(")");
        Statement();
    }
    public void Expression() throws SyntaxErrorException {
        Term();
        if(line.peek("+")) {
            line.consume("+");
            Expression();
        }
        if(line.peek("-")){
            line.consume("-");
            Expression();
        }
    }
    public void Term () throws SyntaxErrorException {
        Factor();
        if(line.peek("*")){
            line.consume("*");
            Term ();
        }
        if(line.peek("/")){
            line.consume("/");
            Term ();
        }
        if(line.peek("%")){
            line.consume("%");
            Term ();
        }

    }
    public void Factor () throws SyntaxErrorException {
        Power();
        while (line.peek("^")) {
            line.consume("^");
            Factor();
        }
    }
    public void Power() throws SyntaxErrorException {

        if (isSpecialVariables(line.peek())){
            line.consume();
            System.out.println("It SpecialVariables it will do something here");
            return;
        }
        if (line.peek("nearby") || line.peek("opponent")){
            InfoExpression();
        }
        if (line.peek("(")) {
            line.consume("(");
            Expression();
            line.consume(")");
        }
        if (matchIdentifier()){
            line.consume();
            System.out.println("dosomething form Power");
            return;
        }else if (matchNumber()) {
            line.consume();
            System.out.println("dosomething form Power");
            return;
        }

    }
    public void InfoExpression() throws SyntaxErrorException {
        if (line.peek("nearby")) {
            line.consume("nearby");
            Direction();
        } else if(line.peek("opponent")){
            line.consume("opponent");
            System.out.println("Call opponent funtion");
        }else {
            throw new RuntimeException("Invalid InfoExpression");
        }
    }


    private boolean matchIdentifier() throws SyntaxErrorException {
        if (!isReservedWord(line.peek())){
            return Pattern.matches("[a-zA-Z][a-zA-Z0-9]*", line.peek());
        }else {
            return false ;
        }

    }

    private boolean matchNumber() {
        try {
            long number = Long.parseLong(line.peek());
            return number >= 0;
        } catch (NumberFormatException | SyntaxErrorException e) {
            return false;
        }

    }
    private boolean isReservedWord(String word) {
        List<String> reservedWords = Arrays.asList(
                "collect", "done", "down", "downleft", "downright", "else", "if", "invest",
                "move", "nearby", "opponent", "relocate", "shoot", "then", "up", "upleft",
                "upright", "while"
        );
        return  reservedWords.contains(word);
    }
    private boolean isSpecialVariables(String word){
        List<String> reservedWords = Arrays.asList(
                "rows", "cols","currow", "curcol",
                "budget", "deposit", "int" , "maxdeposit" ,"random"
        );
        return reservedWords.contains(word);
    }
    private boolean isInformationWord(String word){
        List<String> reservedWords = Arrays.asList(
                "opponent","nearby"
        );
        return reservedWords.contains(word);
    }




}
