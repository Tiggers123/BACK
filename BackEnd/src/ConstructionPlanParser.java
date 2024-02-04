
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class ConstructionPlanParser {
    private final ExprTokenizer line ;
    public ConstructionPlanParser(ExprTokenizer Lineinput){
        this.line = Lineinput ;
    }
    public void parse() throws SyntaxErrorException {
        Statement();
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
        if (matchIdentifier()) {
            line.consume();
            AssignmentStatement();
        } else {
            ActionCommand();
        }
    }
    public void AssignmentStatement() throws SyntaxErrorException {
        line.consume("=");
        Expression();
    }
    public void ActionCommand() throws SyntaxErrorException {
        switch (line.peek()) {
            case "done":
                line.consume("done");
                break;
            case "relocate":
                line.consume("relocate");
                break;
            case "move":
                line.consume("move");
                MoveCommand();
                break;
            case "invest":
                line.consume("invest");
                RegionCommand();
                break;
            case "collect":
                line.consume("collect");
                RegionCommand();
                break;
            case "shoot":
                line.consume("shoot");
                AttackCommand();
                break;
            default:
                throw new RuntimeException("Invalid action command: " + line.peek());
        }

    }
    public void MoveCommand() throws SyntaxErrorException {
        Direction();
    }
    public void RegionCommand() throws SyntaxErrorException {
        if (line.peek("invest") || line.peek("collect")) {
            Expression();
        } else {
            throw new RuntimeException("Invalid region command");
        }
    }
    public void AttackCommand() throws SyntaxErrorException {
        if(line.peek("shoot")){
            Direction();
            Expression();
        }else {
            throw new SyntaxErrorException("Invalid command");
        }
    }
    public void Direction() throws SyntaxErrorException {
        String[] validDirections = {"up", "down", "upleft", "upright", "downleft", "downright"};
        String token = line.peek();
        if (Arrays.asList(validDirections).contains(token)) {
            // need to fix
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
            line.consume("+");
            Expression();
        }
    }
    public void Term () throws SyntaxErrorException {
        Factor();
        while (line.peek("*") || line.peek("/") || line.peek("%")) {
            line.consume();
            Term ();
        }
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
        if (matchIdentifier()){
            line.consume();
            System.out.println("dosomething form Power");
            return;
        }else if (matchNumber()) {
            line.consume();
            System.out.println("dosomething form Power");
            return;
        }
        if (line.peek("(")) {
            line.consume("(");
            Expression();
            line.consume(")");
        }
        InfoExpression();

    }
    public void InfoExpression() throws SyntaxErrorException {
        if (line.peek("nearby")) {
            line.consume();
            Direction();
        } else if(line.peek("opponent")){
            System.out.println("Call opponent funtion");
        }else {
            throw new RuntimeException("Invalid InfoExpression");
        }
    }


    private boolean matchIdentifier() throws SyntaxErrorException {
        return Pattern.matches("[a-zA-Z][a-zA-Z0-9]*", line.peek());
    }

    private boolean matchNumber() {
        try {
            long number = Long.parseLong(line.peek());
            return number >= 0;
        } catch (NumberFormatException | SyntaxErrorException e) {
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



}
